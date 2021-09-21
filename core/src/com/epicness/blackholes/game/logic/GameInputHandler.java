package com.epicness.blackholes.game.logic;

import com.epicness.fundamentals.input.InputHandler;

import static com.badlogic.gdx.Input.Keys.ENTER;
import static com.badlogic.gdx.Input.Keys.SPACE;

public class GameInputHandler extends InputHandler {

    @Override
    public void keyDown(int keycode) {
        GameLogic logic = (GameLogic) this.logic;
        switch (keycode) {
            case SPACE:
                logic.getWeaponsHandler().player1Fire();
                break;
            case ENTER:
                logic.getWeaponsHandler().player2Fire();
                break;
        }
    }
}