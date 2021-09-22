package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Ship;
import com.epicness.fundamentals.stuff.Stuff;

import static com.epicness.blackholes.game.GameConstants.SHIP_ACCELERATION_SPEED;

/**
 * This class handles the Ships movement logic
 */
public class ShipHandler {

    GameStuff stuff;

    public void update() {
        if(stuff.playerShip.getAccelerating()) {
            Accelerate(stuff.playerShip);
        }
        if(stuff.enemyShip.getAccelerating()) {
            Accelerate(stuff.enemyShip);
        }
    }

    private void Accelerate(Ship ship) {
        System.out.println("Accelerating!");
        //first calculate a forward vector for the ship
        Vector2 forward = new Vector2(0, 1);
        forward = forward.rotateDeg(ship.getRotation());
        forward = forward.scl(SHIP_ACCELERATION_SPEED);
        //Now this vector, scaled by SHIP_SPEED should be added to the ships acceleration vector
        ship.addAcceleration(forward);
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
