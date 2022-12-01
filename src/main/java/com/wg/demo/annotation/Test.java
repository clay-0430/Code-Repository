package com.wg.demo.annotation;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wg
 * @date 2021/2/5
 */
public class Test {

    private final static String format = "<phoneme alphabet=\"py\" ph=\"%s\">%s</phoneme>%s";

    private final static Pattern pattern = generateKeywordPattern("姓名,名称,称谓,名字");

    private static final ObjectMapper objectMapper = new CustomObjectMapper();

    private static final int MAX_RETRY_COUNT = 3;

    public static void main(String[] args) throws JsonProcessingException {

        String image = "https://byrobot-test.oss-cn-hangzhou.aliyuncs.com/certificate/2022-11/20221130171311362_1522.jpg";
        final String[] split = image.split("/");
        System.out.println(split[split.length - 1]);
        System.out.println(image);


//        List<String> list1 = null;
//        List<String> list2 = Lists.newArrayList("12222222223","13333333334","14444444445");
//
//        final List<String> collect = Stream.of(list1, list2).filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.toList());
//
//        System.out.println(collect);

//        list1.addAll(list2);
//
//        list1.retainAll(list2);
//
//        System.out.println(list1);


//        MessagePayloadModel messagePayload = MessagePayloadModel.builder()
//                .name("111111")
//                .count(3)
//                .build();
//        MessagePayloadModel messagePayload2 = MessagePayloadModel.builder()
//                .name("222222")
//                .count(3)
//                .build();
//        String jsonString1 = JSON.toJSONString(messagePayload);
//        String jsonString2 = JSON.toJSONString(messagePayload2);
//        List<String> list = Lists.newArrayList(jsonString1, jsonString2);
//        List<MessagePayloadModel> res = Lists.newArrayList();
//        list.forEach(o -> {
//            MessagePayloadModel messagePayloadModel = null;
//            try {
//                messagePayloadModel = objectMapper.readValue(o, MessagePayloadModel.class);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            if (countNum(messagePayloadModel) > MAX_RETRY_COUNT) {
//                return;
//            }
//            res.add(messagePayloadModel);
//        });
//
//        System.out.println(list);
//        System.out.println(res);

//        final String replace = StringUtils.replace("192.168.177.165", ".", "");
//        System.out.println(replace);
//        long v2 = System.currentTimeMillis();
//        long v1 = (v2 / 1000) * 1000;
//
//
//        System.out.println(v2);
//        System.out.println(v1);

//        String name = "令狐冲";
//        String fName = "令狐";
//        String lName = StringUtils.remove(name, fName);
//        System.out.println(lName);
//        String replace = String.format(format, "lin2hu2", fName, lName);
//        System.out.println(replace);


//        Map<String, String> map = new HashMap<>();
//        map.put("令狐", "lin2hu2");
//        map.put("虎", "mao1");
//        map.put("诸葛", "zhu1ge3");
//
//        CustomerInfoExtVO vo = new CustomerInfoExtVO();
//        vo.setName("name");
//        vo.setPhone("17777777777");
//        Map<String, String> userMap = new HashMap<>();
//        userMap.put("客户姓名","令狐冲");
//        vo.setProperties(userMap);
//        List<CustomerInfoExtVO> customerInfoExtVOList = Lists.newArrayList(vo);
//
//
//        customerInfoExtVOList
//                .parallelStream()
//                .map(CustomerInfoExtVO::getProperties)
//                .flatMap(properties -> properties.entrySet().stream())
//                .filter(entry -> pattern.matcher(entry.getKey()).matches())
//                .forEach(entry -> checkAndReplaceSuName(entry, map));
//
//        System.out.println(vo);


    }

    private static int countNum(MessagePayloadModel messagePayloadModel) {
        int count = Optional.of(messagePayloadModel.getCount()).orElse(0);
        if (count >= MAX_RETRY_COUNT) {
            System.out.println("over");
        }
        messagePayloadModel.setCount(++count);
        return count;
    }

    private static void checkAndReplaceSuName(Map.Entry entry, Map<String, String> map) {

        if (Objects.isNull(entry)) {
            return;
        }

        String value = (String) entry.getValue();
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            if (value.startsWith(stringStringEntry.getKey())) {
                String fName = stringStringEntry.getKey();
                String lName = StringUtils.remove(value, fName);
                String replace = String.format(format, stringStringEntry.getValue(), fName, lName);
                entry.setValue(replace);
                break;
            }
        }
    }

    private static void checkAndReplaceSuName(Map.Entry entry) {
        entry.setValue("4444");
    }

    public static Pattern generateKeywordPattern(String keyword) {
        if (StringUtils.isBlank(keyword)) {
            return null;
        }
        String[] keywords = StringUtils.split(keyword, ",");
        List<String> filteredKeywords = new ArrayList<>();
        for (String x1 : keywords) {
            if (StringUtils.isBlank(x1)) {
                continue;
            }
            filteredKeywords.add(StringUtils.trim(x1).replaceAll("<>", ","));
        }
        if (filteredKeywords.isEmpty()) {
            return null;
        }
        filteredKeywords.sort((o1, o2) -> o2.length() - o1.length());
        String pattern1 = StringUtils.join(filteredKeywords, "|");
        Pattern resultPattern = null;
        try {
            resultPattern = Pattern.compile(".*?(" + pattern1 + ").*?");
        } catch (Exception e) {
            return null;
        }
        return resultPattern;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class MessagePayloadModel {
        private String name;
        private Boolean flag = false;
        private int count = 0;
    }

    private static class CustomObjectMapper extends ObjectMapper {

        private static final String dateFormatPattern = "yyyy-MM-dd HH:mm:ss";

        public CustomObjectMapper() {
            // 设置时间格式
            this.setDateFormat(new SimpleDateFormat(dateFormatPattern));

            // 反序列化时可能出现bean对象中没有的字段, 忽略
            this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
    }

}
