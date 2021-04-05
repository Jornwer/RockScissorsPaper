package com.jornwer;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        try {
            checkArgs(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Menu.start(Arrays.asList(args));
    }

    private static void checkArgs(String[] args) throws Exception {
        if (args.length < 3)
            throw new Exception("There must be 3 or more params");
        if (args.length % 2 == 0) {
            throw new Exception("There must be an odd number of params");
        }
        if (new HashSet<>(Arrays.asList(args)).size() != args.length) {
            throw new Exception("There must be distinct params");
        }
    }
}
