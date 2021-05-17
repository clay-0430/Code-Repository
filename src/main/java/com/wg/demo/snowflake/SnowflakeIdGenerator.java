//package com.wg.demo.snowflake;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
///**
// * Description: snowflaske生成器
// *
// * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
// * @date Create on 2019/9/17
// * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
// */
//@Component
//@Slf4j
//@ConditionalOnProperty(name = {"redis.enable"}, havingValue = "true", matchIfMissing = false)
//public class SnowflakeIdGenerator {
//
//    @Autowired
//    private RedisManager redisManager;
//
//    private static final String REDIS_KEY_PREFIX = "snowflakeId:b2c:distribution-solution:";
//
//    private static final String REDIS_KEY_COLON = ":";
//
//    private static final long REDIS_KEY_EXPIRE_SECOND_TIME = 240;
//
//    private SnowflakeId snowflakeId = null;
//
//    /**
//     * 机器信息
//     */
//    private String machineUnique;
//    /**
//     * 工作者ID
//     */
//    private Long workerId;
//    /**
//     * 数组区ID
//     */
//    private Long dataCenterId;
//    /**
//     * 顺序号
//     */
//    private Long sequence;
//    /**
//     * 寻址计数
//     */
//    private int seekCount = 0;
//    /**
//     * 段最大边界32
//     */
//    private static final int SEGMENT_MAX_BOUNDARY = 32;
//
//    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//
//    @PostConstruct
//    public void init() {
//        machineUnique = getIpAddress();
//        workerId = getUniqueIdByRedis("workerId");
//        dataCenterId = getUniqueIdByRedis("dataCenterId");
//        sequence = redisManager.increment(REDIS_KEY_PREFIX + "sequence", 1) % 10000;
//        snowflakeId = new SnowflakeId(workerId, dataCenterId, sequence);
//
//        scheduledExecutorService.scheduleWithFixedDelay(
//                this::extendedLease,
//                REDIS_KEY_EXPIRE_SECOND_TIME / 2,
//                REDIS_KEY_EXPIRE_SECOND_TIME / 2,
//                TimeUnit.SECONDS
//        );
//    }
//
//    @PreDestroy
//    public void destory() {
//        if (workerId != null) {
//            redisManager.del(REDIS_KEY_PREFIX + "workerId" + REDIS_KEY_COLON + workerId);
//        }
//        if (dataCenterId != null) {
//            redisManager.del(REDIS_KEY_PREFIX + "dataCenterId" + REDIS_KEY_COLON + dataCenterId);
//        }
//    }
//
//    /**
//     * 延长租约
//     */
//    public void extendedLease() {
//        String workerKey = REDIS_KEY_PREFIX + "workerId" + REDIS_KEY_COLON + workerId;
//        if (!StringUtils.isEmpty(redisManager.get(workerKey))) {
//            redisManager.expire(workerKey, REDIS_KEY_EXPIRE_SECOND_TIME);
//        }
//        String dataCenterKey = REDIS_KEY_PREFIX + "dataCenterId" + REDIS_KEY_COLON + dataCenterId;
//        if (!StringUtils.isEmpty(redisManager.get(dataCenterKey))) {
//            redisManager.expire(dataCenterKey, REDIS_KEY_EXPIRE_SECOND_TIME);
//        }
//
//        log.info(String.format("SnowflakeId进行续约: " + machineUnique));
//    }
//
//    /**
//     * 获取工作ID，redis方式
//     *
//     * @param uniqueKey
//     * @return
//     */
//    private Long getUniqueIdByRedis(String uniqueKey) {
//        long id = redisManager.increment(REDIS_KEY_PREFIX + uniqueKey, 1) % SEGMENT_MAX_BOUNDARY;
//
//        String workerKey = REDIS_KEY_PREFIX + uniqueKey + REDIS_KEY_COLON + id;
//        if (redisManager.setIfAbsent(workerKey, machineUnique, REDIS_KEY_EXPIRE_SECOND_TIME)) {
//            return id;
//        }
//
//        if (seekCount >= SEGMENT_MAX_BOUNDARY) {
//            String errorMsg = "snowflakeId寻址" + SEGMENT_MAX_BOUNDARY + "次，没有找到ID";
//            log.error(errorMsg);
//            return 1L;
//            //throw new RuntimeException();
//        }
//
//        seekCount++;
//        return getUniqueIdByRedis(uniqueKey);
//    }
//
//    /**
//     * 获取本机IP地址
//     *
//     * @return
//     */
//    public String getIpAddress() {
//        try {
//            InetAddress inetAddress = InetAddress.getLocalHost();
//            return inetAddress.toString();
//        } catch (UnknownHostException e) {
//            throw new RuntimeException("无法获取本机地址");
//        }
//    }
//
//    /**
//     * 获取Long类型序列号
//     *
//     * @return
//     */
//    public Long generatorSerialId() {
//        if (snowflakeId == null) {
//            throw new RuntimeException("snowflakeId生成失败");
//        }
//
//        return snowflakeId.nextId();
//    }
//}
