package com.silenceland.leetcode.designpattern;

/**
 * @author silenceland
 * @description Singleton2
 * @date 2022/1/21
 * 饿汉式
 */
public class Singleton2 {

    private Singleton2() {

    }

    private static Singleton2 instance = new Singleton2();
    public static Singleton2 getInstance() {
        return instance;
    }
}
