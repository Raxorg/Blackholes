package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.stuff.Ship;

import static com.epicness.blackholes.game.GameConstants.SHIP_SPEED;

/**
 * This class handles the Ships movement logic
 */
public class ShipHandler {

    public void Accelerate(Ship ship) {
        //first calculate a forward vector for the ship
        Vector2 forward = new Vector2(0, 0);
        float rads = (float)Math.toRadians(ship.getRotation());
        float cos_rot = (float)Math.cos(rads);
        float sin_rot = (float)Math.sin(rads);
        float tx = 1; float ty = 0;
        forward.x = cos_rot * tx - sin_rot * ty;
        forward.y = sin_rot * tx + cos_rot * ty;

        //Now this vector, scaled by SHIP_SPEED should be added to the ships acceleration vector
        ship.addAcceleration(forward.scl(SHIP_SPEED));
    }

}
