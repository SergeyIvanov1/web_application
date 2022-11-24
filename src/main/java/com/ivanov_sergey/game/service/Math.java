package com.ivanov_sergey.game.service;

public class Math {
    public int sumPositive(int a, int b){
        if (a < 0){
            throw new RuntimeException("a must be > 0");
        }

        if (b < 0){
            throw new RuntimeException("b must be > 0");
        }
        if (((long)a + (long)b) >= Integer.MAX_VALUE){
            throw new RuntimeException("ever  loading");
        }
        return a + b;
    }
}
