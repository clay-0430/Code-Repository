//package com.wg.demo.snowflake;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @Author: 荀凡
// * @Description: snowflakeId
// * 来源：https://segmentfault.com/a/1190000011282426
// * 相关文章：https://cloud.tencent.com/developer/article/1074907
// * @date: Created in 3:18 PM 2019/2/2
// * @modified By:
// **/
//@Slf4j
//public class SnowflakeId {
//
//    private long workerId;
//    private long dataCenterId;
//    private long sequence;
//
//    public SnowflakeId(long workerId, long dataCenterId, long sequence){
//        // sanity check for workerId
//        if (workerId > maxWorkerId || workerId < 0) {
//            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",
//                    maxWorkerId));
//        }
//        if (dataCenterId > maxDatacenterId || dataCenterId < 0) {
//            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",
//                    maxDatacenterId));
//        }
//        log.info(
//                "worker starting. timestamp left shift {}, datacenter id bits {}, worker id bits {}, sequence bits {}, workerid {}",
//                timestampLeftShift,
//                datacenterIdBits,
//                workerIdBits,
//                sequenceBits,
//                workerId
//        );
//
//        this.workerId = workerId;
//        this.dataCenterId = dataCenterId;
//        this.sequence = sequence;
//    }
//
//    private long twepoch = 1609378974657L;
//
//    private long workerIdBits = 5L;
//    private long datacenterIdBits = 5L;
//    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
//    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
//    private long sequenceBits = 12L;
//
//    private long workerIdShift = sequenceBits;
//    private long datacenterIdShift = sequenceBits + workerIdBits;
//    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
//    private long sequenceMask = -1L ^ (-1L << sequenceBits);
//
//    private long lastTimestamp = -1L;
//
//    public long getWorkerId(){
//        return workerId;
//    }
//
//    public long getDataCenterId(){
//        return dataCenterId;
//    }
//
//    public long getTimestamp(){
//        return System.currentTimeMillis();
//    }
//
//    public synchronized long nextId(){
//        long timestamp = timeGen();
//
//        if (timestamp < lastTimestamp) {
//            log.info("clock is moving backwards.  Rejecting requests until {}.", lastTimestamp);
//            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
//                    lastTimestamp - timestamp
//            ));
//        }
//
//        if (lastTimestamp == timestamp) {
//            sequence = (sequence + 1) & sequenceMask;
//            if (sequence == 0) {
//                timestamp = tilNextMillis(lastTimestamp);
//            }
//        } else {
//            sequence = 0;
//        }
//
//        lastTimestamp = timestamp;
//        return ((timestamp - twepoch) << timestampLeftShift) | (dataCenterId << datacenterIdShift) | (workerId
//                << workerIdShift) | sequence;
//    }
//
//    private long tilNextMillis(long lastTimestamp){
//        long timestamp = timeGen();
//        while (timestamp <= lastTimestamp) {
//            timestamp = timeGen();
//        }
//        return timestamp;
//    }
//
//    private long timeGen(){
//        return System.currentTimeMillis();
//    }
//
//    /**
//     * 测试
//     *
//     * @param args
//     */
//    public static void main(String[] args){
//        io.terminus.distribution.common.utils.SnowflakeId worker = new io.terminus.distribution.common.utils.SnowflakeId(31, 31, 3000000);
//        Integer maxTime = 30;
//        for (int i = 0; i < maxTime; i++) {
//            System.out.println(worker.nextId());
//        }
//    }
//}
