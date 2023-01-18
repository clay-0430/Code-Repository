package com.wg.demo.calculate.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @Author : dongpo
 */
public class 统计文件单词个数 {

    static List<String> fileList;

    public static Map<String, Integer> count(int threadNum,
                                             List<File> files) throws FileNotFoundException, ExecutionException, InterruptedException {
        final ExecutorService threadPool = Executors.newFixedThreadPool(threadNum);
        final HashMap<String, Integer> result = new HashMap<>();
        final ArrayList<Future<Map<String, Integer>>> allFilesFutureWordsCount = new ArrayList<>();
        for (String filePath : fileList) {
            final BufferedReader reader = new BufferedReader(new FileReader(filePath));
            allFilesFutureWordsCount.addAll(readAFileAndCountWord(reader, threadPool, threadNum));
        }

        for (Future<Map<String, Integer>> future : allFilesFutureWordsCount) {
            final Map<String, Integer> aFileWordCount = future.get();
            mergeAFileWordCountIntoResultMap(aFileWordCount, result);
        }

        return result;
    }

    private static void mergeAFileWordCountIntoResultMap(Map<String, Integer> aFileWordCount, HashMap<String, Integer> result) {
        for (Map.Entry<String, Integer> entry : aFileWordCount.entrySet()) {
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    private static ArrayList<Future<Map<String, Integer>>> readAFileAndCountWord(BufferedReader reader,
                                                                                 ExecutorService threadPool,
                                                                                 int threadNum) {
        final ArrayList<Future<Map<String, Integer>>> allFilesWordCount = new ArrayList<>();
        for (int i = 0; i < threadNum; i++) {
            allFilesWordCount.add(threadPool.submit(new JobWorker(reader)));
        }

        return allFilesWordCount;
    }

    static class JobWorker implements Callable<Map<String, Integer>> {
        private final BufferedReader reader;

        public JobWorker(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            String line;
            final HashMap<String, Integer> aFileWordCount = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                final String[] words = line.split(" ");
                for (String word : words) {
                    aFileWordCount.put(word, aFileWordCount.getOrDefault(word, 0) + 1);
                }
            }
            return aFileWordCount;
        }
    }
}
