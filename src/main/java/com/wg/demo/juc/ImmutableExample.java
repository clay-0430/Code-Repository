package com.wg.demo.juc;

/**
 * @author wg
 * @date 2021/3/4
 */


import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 不可变的类型：
 *
 * final 关键字修饰的基本数据类型
 * String
 * 枚举类型
 * Number 部分子类，如 Long 和 Double 等数值包装类型，BigInteger 和 BigDecimal 等大数据类型。但同为 Number 的原子类 AtomicInteger 和 AtomicLong 则是可变的。
 * 对于集合类型，可以使用 Collections.unmodifiableXXX() 方法来获取一个不可变的集合。
 */
public class ImmutableExample {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> immutableMap = Collections.unmodifiableMap(map);
        map.put("ss", 1);

    }
}
