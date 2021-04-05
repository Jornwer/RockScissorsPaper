package com.jornwer;

import java.util.Random;

public class Computer {
    public static int makeMove(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }
}
