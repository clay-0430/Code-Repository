package com.wg.demo.calculate.leetcode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : dongpo
 */
public class LRUCache {

    class LRUNode {
        String key;
        Object value;
        LRUNode pre;
        LRUNode next;
        Long expireTime;

        public LRUNode(String key, Object value, Long expireTIme) {
            this.key = key;
            this.value = value;
            this.expireTime = expireTIme;
        }
    }

    Map<String, LRUNode> map = new ConcurrentHashMap<>();
    int capacity;
    LRUNode head;
    LRUNode tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public Map<String, LRUNode> getAll() {
        return map;
    }

    public void put(String key, Object value, Long expireTime) {
        //判断头节点是否为空
        //从map获取出value，如果不为空则更新，为空需要清理后插入
        //变更头尾节点
        if (head == null) {
            LRUNode node = new LRUNode(key, value, expireTime);
            head = node;
            tail = head;
            map.put(key, node);
        }
        LRUNode node = map.get(key);
        if (node != null) {
            node.value = value;
            node.expireTime = expireTime == null ? null : System.currentTimeMillis() + expireTime;
            removeAndInsert(node);
        } else {
            LRUNode insertNode = new LRUNode(key, value, expireTime);
            //判断容量
            if (map.size() >= capacity) {
                LRUNode tempDeleteNode = tail;
                while (true) {
                    if(tempDeleteNode==null){
                        map.remove(tail.key);
                        tail = tail.pre;
                        tail.next = null;
                    }
                    if (tempDeleteNode.expireTime != null && tempDeleteNode.expireTime <= System.currentTimeMillis()) {
                        map.remove(node.key);
                        tempDeleteNode.pre.next = tempDeleteNode.next;
                        tempDeleteNode.next.pre = tempDeleteNode.pre;
                        tempDeleteNode = null;
                        break;
                    }
                    tempDeleteNode = tempDeleteNode.pre;
                }
            }
            map.put(key, insertNode);
            head.pre = insertNode;
            insertNode.next = head;
            insertNode.pre = null;
            head = insertNode;
        }
    }

    private Object get(String key){
        LRUNode node = map.get(key);
        if (node!=null){
            removeAndInsert(node);
            return node.value;
        }
        return null;
    }

    private void removeAndInsert(LRUNode node) {
        if (node == head) {
            return;
        } else if (node == tail) {
            tail = node.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put("1", "1111", null);
        cache.put("2", "2222", null);
        System.out.println(cache.getAll());
        System.out.println(cache.get("1"));
    }


}
