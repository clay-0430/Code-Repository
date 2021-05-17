package com.wg.demo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 汪贯
 * @desc
 */
public class LocalCache {

    //对本地内存缓存进行维护
    //构建一个本地缓存，缓存的对象是用户ID以及部分用户的信息，在从缓存中获取数据时，如果发现缓存上次更新时间超过30分钟，则需要自动更新一次缓存。

    @Data
    public class UserInfo {
        private String userId;
        private String userName;
        private String cardNo;
    }

    //: TODO 可自行定义需要的变量
    public static final Map<Object, UserInfo> localCache = new ConcurrentHashMap<Object, UserInfo>();

    /**
     初始化用户信息缓存
     */
    public void initUserInfoCache(Object key, UserInfo userInfo, long timeOut){
        long currentTime = System.currentTimeMillis();
        UserInfo value = localCache.get(key);
        if (localCache.keySet().contains(key)){

        }
//: TODO 完成此处的代码
    }



    public UserInfo getUserInfoFromCacheById(String id){
//: TODO 完成此处的代码
        long currentTime = System.currentTimeMillis();
        UserInfo userInfo = localCache.get(id);
        if (userInfo == null){
            return null;
        }
        return new UserInfo();
    }



    public void updateUserInfoCache(){
        localCache.clear();
//: TODO 完成此处的代码
    }
}
