package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * The ship will be a collection of components that each do something specific.
 * Each of these components have a certain amount of health, and when they're destroyed, they will break off the ship and become their own SpaceObject
 */
public class Ship {

    private ShipComponent thruster;
    private ShipComponent gun;
    private ShipComponent shield;
    private ShipComponent cockpit;

    private ShipComponent[] components;

    public Ship() {
        //Creating the components
        shield = new ShipComponent(new float[] {-1, -2, -0.5f, 2, 0.5f, 2, 1, -2});
        cockpit = new ShipComponent(new float[]{-0.55f, -1.5f, -0.25f, 1.5f, 0.25f, 1.5f, 0.55f, -1.5f});
        thruster = new ShipComponent(new float[]{-0.5f, -2, 0.5f, -2, 0.75f, -2.5f, -0.75f, -2.5f});
        gun = new ShipComponent(new float[] {-0.25f, 2, -0.25f, 2.75f, 0.25f, 2.75f, 0.25f, 2});
        components = new ShipComponent[] {thruster, gun, shield, cockpit};

        //Now position and scale them
        for(ShipComponent sc : components) {
            sc.getBoundingBox().setPosition(150, 150);
            sc.getBoundingBox().setScale(30, 30);
            sc.getBoundingBox().setRotation(-45);
        }
    }

    public void draw(ShapeRenderer sr) {
        for(ShipComponent sc : components) {
            if(sc != null) {
                sr.polygon(sc.getBoundingBox().getTransformedVertices());
            }
        }
    }

}
