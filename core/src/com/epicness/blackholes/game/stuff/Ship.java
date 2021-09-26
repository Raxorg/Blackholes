package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.GameAssets;

import java.util.ArrayList;

/**
 * The ship will be a collection of components that each do something specific.
 * Each of these components have a certain amount of health, and when they're
 * destroyed, they will break off the ship and become their own SpaceObject
 */
public class Ship extends SpaceObject {

    private final ArrayList<ShipComponent> components;
    private boolean accelerating;
    private float cooldown;
    private Color team;

    public Ship(GameAssets assets, Color team) {
        // Creating the components
        ShipComponent cockpit = new ShipComponent(
                assets.getShipCockpit(), assets.getShipCockpitInverted(),
                new float[]{-3f, -4.85f, -3f, -1.5f, 3f, -1.5f, 3f, -4.85f});
        ShipComponent leftGun = new ShipComponent(
                assets.getShipLeftGun(), assets.getShipLeftGunInverted(),
                new float[]{-5.5f, -4f, -4f, -4f, -3.3f, -1f, -1f, -0.65f, -1f, 1.2f, -3f, 1.8f, -6f, -1f});
        ShipComponent rightGun = new ShipComponent(
                assets.getShipRightGun(), assets.getShipRightGunInverted(),
                new float[]{5.5f, -4f, 4f, -4f, 3.3f, -1f, 1f, -0.65f, 1f, 1.2f, 3f, 1.8f, 6f, -1f});
        ShipComponent nucleus = new ShipComponent(
                assets.getShipNucleus(), assets.getShipNucleusInverted(),
                new float[]{-1f, -0.75f, -1f, 1.5f, 1f, 1.5f, 1f, -0.75f});
        ShipComponent thruster = new ShipComponent(
                assets.getShipThruster(), assets.getShipThrusterInverted(),
                new float[]{-2.5f, 2f, -3.25f, 5f, 3.25f, 5f, 2.5f, 2f});

        components = new ArrayList<>();
        components.add(cockpit);
        components.add(leftGun);
        components.add(rightGun);
        components.add(nucleus);
        components.add(thruster);

        // Now position and scale them
        for (ShipComponent sc : components) {
            sc.getCollider().setScale(15, 15);
        }

        this.team = team;
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

    public ArrayList<ShipComponent> getComponents() {
        return components;
    }

    public boolean isAccelerating() {
        return accelerating;
    }

    public void setAccelerating(boolean accelerating) {
        this.accelerating = accelerating;
    }

    public float getCooldown() {
        return cooldown;
    }

    public void setCooldown(float cooldown) {
        this.cooldown = cooldown;
    }

    public Color getTeam() {
        return team;
    }
}