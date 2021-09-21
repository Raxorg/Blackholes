package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * The ship will be a collection of components that each do something specific.
 * Each of these components have a certain amount of health, and when they're destroyed, they will break off the ship and become their own SpaceObject
 */
public class Ship extends SpaceObject {

    //Bounding Box Polygons
    private ShipComponent thruster;
    private ShipComponent gun;
    private ShipComponent shield;
    private ShipComponent cockpit;

    private ShipComponent[] components;

    public Ship() {

        super();

        //Creating the components
        shield = new ShipComponent(new float[] {-1, -2, -0.5f, 2, 0.5f, 2, 1, -2});
        cockpit = new ShipComponent(new float[]{-0.55f, -1.5f, -0.25f, 1.5f, 0.25f, 1.5f, 0.55f, -1.5f});
        thruster = new ShipComponent(new float[]{-0.5f, -2, 0.5f, -2, 0.75f, -2.5f, -0.75f, -2.5f});
        gun = new ShipComponent(new float[] {-0.25f, 2, -0.25f, 2.75f, 0.25f, 2.75f, 0.25f, 2});
        components = new ShipComponent[] {thruster, gun, shield, cockpit};

        //Now position and scale them
        for(ShipComponent sc : components) {
            sc.getBoundingBox().setScale(15, 15);
        }
    }

    @Override
    public void draw(ShapeRenderer sr) {
        for(ShipComponent sc : components) {
            if(sc != null) {
                sc.getBoundingBox().setPosition(this.position.x, this.position.y);
                sc.getBoundingBox().setRotation(this.rotation);
                sr.polygon(sc.getBoundingBox().getTransformedVertices());
            }
        }
    }
}
