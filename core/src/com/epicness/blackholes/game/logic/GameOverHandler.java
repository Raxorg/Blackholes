package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Ship;

public class GameOverHandler {

    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private boolean gameOver;

    public void checkGameOver(Ship ship) {
        boolean gameOver = true;
        for (int i = 0; i < ship.getComponents().size(); i++) {
            if (!ship.getComponents().get(i).isDestroyed()) {
                gameOver = false;
            }
        }
        if (gameOver) {
            showGameOver();
        }
    }

    public void showGameOver() {
        stuff.gameOverOverlay.setColor(Color.WHITE);
        gameOver = true;
    }

    public void restart() {
        if (!gameOver) {
            return;
        }
        stuff.initializeStuff();
        logic.initialLogic();
        gameOver = false;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}