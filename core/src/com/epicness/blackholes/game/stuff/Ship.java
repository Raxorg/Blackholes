package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.GameAssets;

import java.util.ArrayList;

/**
 * The ship will be a collection of components that each do something specific.
 * Each of these components have a certain amount of health, and when they're destroyed, they will break off the ship and become their own SpaceObject
 */
public class Ship extends SpaceObject {

    private final ArrayList<ShipComponent> components;
    private boolean Accelerating;

    public Ship(GameAssets assets) {
        //Creating the components
        ShipComponent shield = new ShipComponent(
                assets.getBlackHole(), assets.getBlackHoleGlow(), // Pending asset
                new float[]{-1, -2, -0.5f, 2, 0.5f, 2, 1, -2});
        ShipComponent cockpit = new ShipComponent(
                assets.getBlackHole(), assets.getBlackHoleGlow(), // Pending asset
                new float[]{-0.55f, -1.5f, -0.25f, 1.5f, 0.25f, 1.5f, 0.55f, -1.5f});
        ShipComponent thruster = new ShipComponent(
                assets.getBlackHole(), assets.getBlackHoleGlow(), // Pending asset
                new float[]{-0.5f, -2, 0.5f, -2, 0.75f, -2.5f, -0.75f, -2.5f});
        ShipComponent gun = new ShipComponent(
                assets.getBlackHole(), assets.getBlackHoleGlow(), // Pending asset
                new float[]{-0.25f, 2, -0.25f, 2.75f, 0.25f, 2.75f, 0.25f, 2});

        components = new ArrayList<>();
        components.add(shield);
        components.add(cockpit);
        components.add(thruster);
        components.add(gun);

        //Now position and scale them
        for (ShipComponent sc : components) {
            sc.getCollider().setScale(15, 15);
        }
    }

    @Override
    public void drawNormal(SpriteBatch spriteBatch) {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).drawNormal(spriteBatch);
        }
    }

    @Override
    public void drawInverted(SpriteBatch spriteBatch) {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).drawInverted(spriteBatch);
        }
    }

    @Override
    public void drawCollider(ShapeRenderer shapeRenderer) {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).drawCollider(shapeRenderer);
        }
    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
        for (int i = 0; i < components.size(); i++) {
            components.get(i).setPosition(position);
        }
    }

    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
        for (int i = 0; i < components.size(); i++) {
            components.get(i).setRotation(rotation);
        }
    }

    public void setAccelerating(boolean accelerating) {
        Accelerating = accelerating;
    }

    public boolean getAccelerating() {
        return Accelerating;
    }

    public ArrayList<ShipComponent> getComponents() {
        return components;
    }
}