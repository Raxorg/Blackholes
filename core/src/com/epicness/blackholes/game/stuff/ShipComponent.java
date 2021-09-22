package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.DualSprited;

public class ShipComponent extends SpaceObject {

    private final DualSprited dualSprited;
    private final Polygon collider;
    private int health;

    public ShipComponent(Sprite normal, Sprite inverted, float[] colliderVertices) {
        dualSprited = new DualSprited(normal, inverted);
        collider = new Polygon(colliderVertices);
        health = 50; // Random arbitrary health, idk if this should be based on the component
    }

    @Override
    public void drawNormal(SpriteBatch spriteBatch) {
        dualSprited.drawBackground(spriteBatch);
    }

    @Override
    public void drawInverted(SpriteBatch spriteBatch) {
        dualSprited.drawForeground(spriteBatch);
    }

    @Override
    public void drawCollider(ShapeRenderer shapeRenderer) {
        shapeRenderer.polygon(collider.getTransformedVertices());
    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
        dualSprited.setPosition(position.x, position.y);
        collider.setPosition(position.x, position.y);
    }

    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
        dualSprited.setRotation(rotation);
        collider.setRotation(rotation);

    }

    public Polygon getCollider() {
        return collider;
    }
}