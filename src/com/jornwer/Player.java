package com.jornwer;

import java.util.Scanner;

public class Player {
    public static int choose(int argsNum) {
        System.out.println("Enter you move:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int playerChoice;
            if (scanner.hasNextInt()) {
                playerChoice = scanner.nextInt();
                if (playerChoice <= argsNum) {
                    return playerChoice;
                } else {
                    System.out.println("Incorrect choice. Try again");
                }
            }
        }
    }
}
