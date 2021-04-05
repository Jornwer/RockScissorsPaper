package com.jornwer;

import java.util.List;

public class Menu {
    private final List<String> args;
    private final String key;
    private final String HMAC;
    private final int computerMove;

    private Menu(List<String> args) {
        this.args = args;
        key = KeyGenerator.generateRandomKey();
        computerMove = Computer.makeMove(args.size());
        HMAC = new HmacGenerator(key, String.valueOf(computerMove)).generateHmacSha();
    }

    private void mainMenu() {
        System.out.println("HMAC: " + HMAC);
        System.out.println("Available moves:");
        for (int i = 0; i < args.size(); i++) {
            System.out.println(i + 1 + " - " + args.get(i));
        }
        System.out.println(0 + " - exit");
    }

    public static void start(List<String> args) {
        Menu menu = new Menu(args);
        menu.mainMenu();
        menu.result();
    }

    private void result() {
        int choose = Player.choose(args.size());
        System.out.println("Your move: " + args.get(choose - 1));
        System.out.println("Computer move: " + args.get(computerMove));
        Result winner = Game.judgeWinner(choose, computerMove, args.size());
        displayWinner(winner);
        System.out.println("HMAC key: " + key);
    }

    private void displayWinner(Result winner) {
        switch (winner) {
            case WIN -> System.out.println("You win");
            case LOSE -> System.out.println("You lose");
            case DRAW -> System.out.println("Its a draw");
        }
    }
}
