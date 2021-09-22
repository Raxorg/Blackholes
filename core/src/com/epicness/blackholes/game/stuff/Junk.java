package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.Circle;
import com.epicness.fundamentals.stuff.DualSprited;

import static com.epicness.blackholes.game.GameConstants.JUNK_RADIUS;
import static com.epicness.blackholes.game.GameConstants.JUNK_SIZE;

public class Junk extends SpaceObject {

    private final DualSprited dualSprited;
    private final Circle bounds;

    public Junk(Sprite normalJunk, Sprite invertedJunk) {
        dualSprited = new DualSprited(normalJunk, invertedJunk);
        dualSprited.setSize(JUNK_SIZE);
        dualSprited.setOriginCenter();
        bounds = new Circle(JUNK_RADIUS);
    }

    public void drawNormal(SpriteBatch spriteBatch) {
        dualSprited.drawBackground(spriteBatch);
    }

    public void drawInverted(SpriteBatch spriteBatch) {
        dualSprited.drawForeground(spriteBatch);
    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
        dualSprited.setPosition(position.x, position.y);
    }

    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
        dualSprited.setRotation(rotation);
    }

    public Circle getBounds() {
        return bounds;
    }
}