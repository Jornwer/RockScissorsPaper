package com.jornwer;

public class Game {
    public static Result judgeWinner(int playerChoice, int computerChoice, int argsNum) {
        playerChoice--;
        if (playerChoice == computerChoice) {
            return Result.DRAW;
        }
        for (int i = 1; i <= argsNum / 2; i++) {
            if ((playerChoice + i) % argsNum == (computerChoice)) {
                return Result.LOSE;
            }
        }
        return Result.WIN;
    }
}
