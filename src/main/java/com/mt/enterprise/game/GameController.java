package com.mt.enterprise.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game/start")
    public String startGame() {
        return gameService.startGame();
    }

    @GetMapping("/game/guess")
    public String guess(@RequestParam int number) {
        return gameService.guessNumber(number);
    }
}
