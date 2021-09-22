package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

/**
 * This class will represent anything that can free float in space.
 * Things like: space junk, our ship, broken pieces of our ship
 */
public abstract class SpaceObject {

    protected float mass, rotation, angularVelocity;
    protected Vector2 position, velocity, acceleration;
    protected Polygon boundingBox;

    public SpaceObject() {
        mass = 1f;
        rotation = 0f;
        angularVelocity = 0f;
        position = new Vector2();
        velocity = new Vector2();
        acceleration = new Vector2();
    }

    public abstract void drawNormal(SpriteBatch spriteBatch);

    public abstract void drawInverted(SpriteBatch spriteBatch);

    public Polygon getBoundingBox() {
        return boundingBox;
    }

    public float getRotation() {
        return rotation;
    }

    public float getAngularVelocity() {
        return angularVelocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void setAngularVelocity(float angularVelocity) {
        this.angularVelocity = angularVelocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public void addAcceleration(Vector2 acceleration) {
        this.acceleration.add(acceleration);
    }
}
