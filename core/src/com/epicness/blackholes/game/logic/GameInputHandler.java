package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.fundamentals.input.InputHandler;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.CONTROL_RIGHT;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.ENTER;
import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.R;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.blackholes.game.GameConstants.SHIP_TURN_SPEED;

public class GameInputHandler extends InputHandler {

    @Override
    public void keyDown(int keycode) {
        GameLogic logic = (GameLogic) this.logic;
        GameStuff stuff = (GameStuff) this.stuff;
        switch (keycode) {
            case ENTER:
                logic.getWeaponsHandler().player2Fire();
                break;
            case SPACE:
                logic.getWeaponsHandler().player1Fire();
                break;
            // Ship 1 controls
            case W:
                stuff.player1Ship.setAccelerating(true);
                break;
            case A:
                stuff.player1Ship.setAngularVelocity(SHIP_TURN_SPEED);
                break;
            case D:
                stuff.player1Ship.setAngularVelocity(-SHIP_TURN_SPEED);
                break;
            case F:
                logic.getShipHandler().shoot(stuff.player1Ship);
                break;
            // Ship 2 controls
            case UP:
                stuff.player2Ship.setAccelerating(true);
                break;
            case LEFT:
                stuff.player2Ship.setAngularVelocity(SHIP_TURN_SPEED);
                break;
            case RIGHT:
                stuff.player2Ship.setAngularVelocity(-SHIP_TURN_SPEED);
                break;
            case CONTROL_RIGHT:
                logic.getShipHandler().shoot(stuff.player2Ship);
                break;
            // Restart
            case R:
                logic.getGameOverHandler().restart();
        }
    }

    @Override
    public void keyUp(int keycode) {
        GameStuff stuff = (GameStuff) this.stuff;
        switch (keycode) {
            // Ship 1 controls
            case W:
                stuff.player1Ship.setAccelerating(false);
                stuff.player1Ship.setAcceleration(new Vector2(0, 0));
                break;
            case A:
            case D:
                stuff.player1Ship.setAngularVelocity(0);
                break;
            // Ship 2 controls
            case UP:
                stuff.player2Ship.setAccelerating(false);
                stuff.player2Ship.setAcceleration(new Vector2(0, 0));
                break;
            case LEFT:
            case RIGHT:
                stuff.player2Ship.setAngularVelocity(0);
        }
    }
}