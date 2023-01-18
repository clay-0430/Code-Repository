package com.wg.demo.calculate.code;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : dongpo
 */
public class MultiThreadWordCount {

    public static Map<String, Integer> count(int threadNum, List<File> files) throws FileNotFoundException {
        final HashMap<String, Integer> result = new HashMap<>();
        final ArrayList<Map<String, Integer>> allFilesFutureWordsCount = new ArrayList<>();
        for (File file : files) {
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            allFilesFutureWordsCount.add(readAFileAndCountWord(reader, threadNum));
        }

        for (Map<String, Integer> aFileWordCount : allFilesFutureWordsCount) {
            mergeAFileWordCountIntoResultMap(aFileWordCount, result);
        }

        return result;
    }

    private static void mergeAFileWordCountIntoResultMap(Map<String, Integer> aFileWordCount, HashMap<String, Integer> result) {
        for (Map.Entry<String, Integer> entry : aFileWordCount.entrySet()) {
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    private static Map<String, Integer> readAFileAndCountWord(BufferedReader reader, int threadNum) {
        final Map<String, Integer> aFileWordCount = new HashMap<>();
        final ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < threadNum; i++) {
            new Thread(new JobWorker(lock, reader, aFileWordCount)).start();
        }
        return aFileWordCount;
    }

    static class JobWorker implements Runnable {
        private final ReentrantLock lock;
        private final BufferedReader reader;
        private final Map<String, Integer> aFileWordCount;

        public JobWorker(ReentrantLock lock, BufferedReader reader, Map<String, Integer> aFileWordCount) {
            this.lock = lock;
            this.reader = reader;
            this.aFileWordCount = aFileWordCount;
        }

        @Override
        public void run() {
            lock.lock();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    final String[] words = line.split(" ");
                    for (String word : words) {
                        aFileWordCount.put(word, aFileWordCount.getOrDefault(word, 0) + 1);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

}
