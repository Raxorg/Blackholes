package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.DualSprited;

import static com.epicness.blackholes.game.GameConstants.JUNK_SIZE;

public class Junk extends SpaceObject {

    private final DualSprited dualSprited;

    public Junk(Sprite normalJunk, Sprite invertedJunk) {
        dualSprited = new DualSprited(normalJunk, invertedJunk);
        dualSprited.setSize(JUNK_SIZE);
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
}