package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

import static com.badlogic.gdx.Input.Keys.*;
import static com.epicness.blackholes.game.GameConstants.SHIP_TURN_SPEED;

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
                ((GameStuff)stuff).playerShip.setAccelerating(true);
                break;
            case Q:
                ((GameStuff)stuff).playerShip.setAngularVelocity(SHIP_TURN_SPEED);
                break;
            case E:
                ((GameStuff)stuff).playerShip.setAngularVelocity(-SHIP_TURN_SPEED);
        }
    }

    @Override
    public void keyUp(int keycode) {
        switch(keycode) {
            case W:
                ((GameStuff)stuff).playerShip.setAccelerating(false);
                ((GameStuff)stuff).playerShip.setAcceleration(new Vector2(0, 0));
                break;
            case Q:
            case E:
                ((GameStuff)stuff).playerShip.setAngularVelocity(0);

        }
    }
}