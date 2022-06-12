//package com.shannonAJ.leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author ShannonAJ
// * @description LRUCache
// * @date 2022/3/17
// */
//public class LRUCache {
//
//    class DLinkNode {
//        int key;
//        int val;
//        DLinkNode pre;
//        DLinkNode next;
//
//        public DLinkNode(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//
//        public DLinkNode() {
//        }
//    }
//
//    private Map<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode>();
//    private int size;
//    private int capacity;
//    private DLinkNode head, tail;
//
//    public LRUCache(int capacity) {
//        this.size = 0;
//        this.capacity = capacity;
//        head = new DLinkNode();
//        tail = new DLinkNode();
//        head.next = tail;
//        tail.pre = head;
//
//    }
//
//    public int get(int key) {
//        DLinkNode node = cache.get(key);
//        if (node == null) {
//            return -1;
//        }
//
//        // move
//        return node.val;
//    }
//
//    public void put(int key, int value) {
//        DLinkNode node = cache.get(key);
//        if (node == null) {
//            DLinkNode newNode = new DLinkNode(key, value);
//            cache.put(key, newNode);
//            // add
//            size++;
//            if (size > capacity) {
//                DLinkNode tail = removeTail();
//                cache.remove(tail.key);
//                size--;
//            }
//        }else {
//            node.val = value;
//            //move
//        }
//    }
//
//    private void addToHead(DLinkNode node) {
//        node.pre = head;
//        node.next = head.next;
//        head.next.pre = node;
//        head.next = node;
//    }
//
//    private void removeNode(DLinkNode node) {
//        node.pre.next = node.next;
//        node.next.pre = node.pre;
//    }
//
//    private void moveToHead(DLinkNode node) {
//        removeNode(node);
//        addToHead(node);
//    }
//
//
//}
