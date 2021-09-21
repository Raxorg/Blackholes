package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.math.Polygon;

public class ShipComponent {

    private int health;
    private Polygon boundingBox;

    public ShipComponent(float[] boundingBoxVerts /*, Image*/) {
        boundingBox = new Polygon(boundingBoxVerts);
        health = 50; //random arbitrary health, idk if this should be based on the component
    }

    public Polygon getBoundingBox() {
        return boundingBox;
    }
}
