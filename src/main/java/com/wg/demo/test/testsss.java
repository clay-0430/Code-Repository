package com.wg.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author wg
 */
@Data
public class testsss {

    private Object object;

    public static void main(String[] args) {

//        PhTimesCardOperationRecordFeature feature = PhTimesCardOperationRecordFeature.builder().activityId(213123L).templateName("dasd").build();
//
//        PhTimesCardOperationRecordFeature result = JSONObject.parseObject(null, PhTimesCardOperationRecordFeature.class);
//
//        System.out.println(Optional.ofNullable(result).map(PhTimesCardOperationRecordFeature::getTemplateName).orElse(null));

//        Map<String, Integer> left = ImmutableMap.of(
//                "a", 1,
//                "b", 2,
//                "c", 3);
//        System.out.println(left.getOrDefault("d", 100));
//
//
//        Map<String, Integer> map = new HashMap<>();
//        map.put("a", 1);
//        map.put("b", 2);
//        map.put("c", 3);
//        System.out.println(map.getOrDefault("d", 100));
//
//        Map<String, Integer> ga = ImmutableMap.<String, Integer>builder()
//                .put("a", 1)
//                .put("b", 2)
//                .put("c", 3)
//                .build();
//        System.out.println(ga.getOrDefault("d", 100));

        for (int i = 0; i < 100; i++)
            System.out.println(getRecordNo(2318591231L, 12));

    }

    private static Long getRecordNo(long input, int length) {
        long n1 = decideN(input, length);
        long n = n1 + System.currentTimeMillis() % 1000000000L + getUUIDNumber();
        return decideN(n, length);
    }

    private static Long decideN(Long num, int length) {
        String numStr = num + "";
        String s = numStr.length() >= length ? numStr.substring(0, length) : StringUtils.rightPad(numStr, length, "0");
        return Long.valueOf(s);
    }

    public static Integer getUUIDNumber() {
        int i = UUID.randomUUID().toString().hashCode();
        i = i < 0 ? -i : i;
        return i;
    }


}
