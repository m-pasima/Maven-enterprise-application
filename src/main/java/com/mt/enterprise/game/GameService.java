package com.mt.enterprise.game;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    private final Random random = new Random();
    private int targetNumber = -1;

    public String startGame() {
        targetNumber = random.nextInt(10) + 1; // 1-10
        return "Guess a number between 1 and 10";
    }

    public String guessNumber(int number) {
        if (targetNumber == -1) {
            return "Game not started. Call /game/start first.";
        }
        if (number == targetNumber) {
            targetNumber = -1; // reset the game
            return "Congratulations! You guessed the number!";
        } else if (number < targetNumber) {
            return "Too low! Try again.";
        } else {
            return "Too high! Try again.";
        }
    }
}
