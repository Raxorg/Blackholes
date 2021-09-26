package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.DualSprited;

import static com.epicness.blackholes.game.GameConstants.COMPONENT_STARTING_HEALTH;

public class ShipComponent extends SpaceObject {

    private final DualSprited dualSprited;
    private int health;
    private final Polygon collider;

    public ShipComponent(Sprite normal, Sprite inverted, float[] colliderVertices) {
        dualSprited = new DualSprited(normal, inverted);
        dualSprited.setScale(0.3f);
        dualSprited.setOriginCenter();
        collider = new Polygon(colliderVertices);
        health = COMPONENT_STARTING_HEALTH;
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
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.polygon(collider.getTransformedVertices());
    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
        dualSprited.setPosition(
                position.x - dualSprited.getWidth() / 2f,
                position.y - dualSprited.getHeight() / 2f);
        collider.setPosition(position.x, position.y);
    }

    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
        dualSprited.setRotation(rotation);
        collider.setRotation(rotation);
    }

    public void setColor(Color color) {
        dualSprited.setColor(color);
    }

    public int getHealth() {
        return health;
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Polygon getCollider() {
        return collider;
    }
}