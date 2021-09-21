package com.epicness.blackholes.game.logic;

import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

import static com.badlogic.gdx.Input.Keys.*;

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
            case W:
                logic.getShipHandler().Accelerate(((GameStuff)stuff).playerShip);
        }
    }
}