package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;

public class NinePatchedText implements Buttonable {

    private final Rectangle boundingBox;
    private final NinePatch ninePatch;
    private final Text label;

    public NinePatchedText(Texture buttonNinePatch, BitmapFont font, int marginSize,
                           float borderScale) {
        boundingBox = new Rectangle();
        ninePatch = new NinePatch(buttonNinePatch, marginSize, marginSize, marginSize, marginSize);
        ninePatch.scale(borderScale, borderScale);
        label = new Text(font);
        label.setHorizontalAlignment(Align.center);
        label.setCenterVertical(true);
    }

    public void draw(SpriteBatch spriteBatch) {
        ninePatch.draw(spriteBatch, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        label.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return boundingBox.contains(x, y);
    }

    public void setX(float x) {
        boundingBox.x = x;
        label.setX(x);
    }

    public void setY(float y) {
        boundingBox.y = y;
        label.setY(y + boundingBox.height / 2f);
    }

    public void setPosition(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setSize(float width, float height) {
        boundingBox.setSize(width, height);
        label.setTextTargetWidth(width);
        label.setY(boundingBox.y + boundingBox.height / 2f);
    }

    public void setColor(Color color) {
        ninePatch.setColor(color);
    }

    public void setText(String text) {
        label.setText(text);
    }
}