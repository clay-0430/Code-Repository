package com.wg.demo.thread.lock;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 汪贯
 * @desc
 */
public class Condi {

    public static void main(String[] args) {
        // 10:1,20:2,30:3
        String[] stepsStr = new String[]{"10:1,20:2,30:3"};
        Map<Long, Long> steps = Stream.of(stepsStr)
                .collect(Collectors.toMap(s -> Long.valueOf(s.split(":")[0]),
                        s -> Long.valueOf(s.split(":")[1])));
        List<Long> keys = Lists.newArrayList(steps.keySet());
        keys = keys.stream().sorted().collect(Collectors.toList());
        Long ahead = 0L;
        Iterator<Long> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Long back = iterator.next();
            // 左闭右开
            ahead = back;
        }
    }

}
