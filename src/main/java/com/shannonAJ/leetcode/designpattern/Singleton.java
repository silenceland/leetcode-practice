package com.shannonAJ.leetcode.designpattern;

/**
 * @author ShannonAJ
 * @description Singleton
 * @date 2022/1/21
 * 懒汉式
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton instance = null;
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


