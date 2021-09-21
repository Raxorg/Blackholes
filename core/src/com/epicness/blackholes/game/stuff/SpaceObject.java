package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

/**
 * This class will represent anything that can free float in space.
 * Things like: space junk, our ship, broken pieces of our ship
 */
public class SpaceObject {

    private float mass;
    private Vector2 position, velocity, acceleration;
    private Polygon boundingBox;

    public Polygon getBoundingBox() {
        return boundingBox;
    }
}
