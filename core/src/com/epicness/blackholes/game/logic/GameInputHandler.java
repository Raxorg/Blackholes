package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

import static com.badlogic.gdx.Input.Keys.E;
import static com.badlogic.gdx.Input.Keys.ENTER;
import static com.badlogic.gdx.Input.Keys.Q;
import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.blackholes.game.GameConstants.SHIP_TURN_SPEED;

public class GameInputHandler extends InputHandler {

    @Override
    public void keyDown(int keycode) {
        GameLogic logic = (GameLogic) this.logic;
        GameStuff stuff = (GameStuff) this.stuff;
        switch (keycode) {
            case SPACE:
                logic.getWeaponsHandler().player1Fire();
                break;
            case ENTER:
                logic.getWeaponsHandler().player2Fire();
                break;
            case W:
                stuff.playerShip.setAccelerating(true);
                break;
            case Q:
                stuff.playerShip.setAngularVelocity(SHIP_TURN_SPEED);
                break;
            case E:
                stuff.playerShip.setAngularVelocity(-SHIP_TURN_SPEED);
        }
    }

    @Override
    public void keyUp(int keycode) {
        GameStuff stuff = (GameStuff) this.stuff;
        switch (keycode) {
            case W:
                stuff.playerShip.setAccelerating(false);
                stuff.playerShip.setAcceleration(new Vector2(0, 0));
                break;
            case Q:
            case E:
                stuff.playerShip.setAngularVelocity(0);

        }
    }
}