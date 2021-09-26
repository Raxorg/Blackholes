package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.AdvancedCircle;
import com.epicness.fundamentals.stuff.DualSprited;

import static com.epicness.blackholes.game.GameConstants.JUNK_COLLIDER_RADIUS;
import static com.epicness.blackholes.game.GameConstants.JUNK_RADIUS;
import static com.epicness.blackholes.game.GameConstants.JUNK_SIZE;

public class Junk extends SpaceObject {

    private final DualSprited dualSprited;

    public Junk(Sprite normalJunk, Sprite invertedJunk) {
        dualSprited = new DualSprited(normalJunk, invertedJunk);
        dualSprited.setSize(JUNK_SIZE);
        dualSprited.setOriginCenter();

        collider = new AdvancedCircle(JUNK_COLLIDER_RADIUS);
    }

    public void drawNormal(SpriteBatch spriteBatch) {
        dualSprited.drawBackground(spriteBatch);
    }

    public void drawInverted(SpriteBatch spriteBatch) {
        dualSprited.drawForeground(spriteBatch);
    }

    public void drawCollider(ShapeRenderer shapeRenderer) {
        ((AdvancedCircle) collider).draw(shapeRenderer);
    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
        dualSprited.setPosition(position.x, position.y);
        float colliderX = position.x + JUNK_RADIUS;
        float colliderY = position.y + JUNK_RADIUS;
        ((AdvancedCircle) collider).setPosition(colliderX, colliderY);
    }

    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
        dualSprited.setRotation(rotation);
    }

    public void setColor(Color color) {
        dualSprited.setColor(color);
    }

    public AdvancedCircle getCollider() {
        return (AdvancedCircle) collider;
    }
}