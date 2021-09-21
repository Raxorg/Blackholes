package com.epicness.blackholes.game.stuff.blackholes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.stuff.SpaceObject;
import com.epicness.fundamentals.stuff.Circle;
import com.epicness.fundamentals.stuff.DualSprited;

import static com.epicness.blackholes.game.GameConstants.BLACK_HOLE_SIZE;

public class BlackHole extends SpaceObject {

    private final DualSprited normal;
    private final DualSprited inverted;
    private final Circle distortion;
    private final BlackHoleType blackHoleType;

    public BlackHole(Sprite blackHole, Sprite blackHoleGlow,
                     Sprite invertedBlackHole, Sprite invertedBlackHoleGlow,
                     BlackHoleType blackHoleType) {
        normal = new DualSprited(blackHoleGlow, blackHole);
        normal.setSize(BLACK_HOLE_SIZE, BLACK_HOLE_SIZE);
        normal.setOriginCenter();
        inverted = new DualSprited(invertedBlackHoleGlow, invertedBlackHole);
        inverted.setSize(BLACK_HOLE_SIZE, BLACK_HOLE_SIZE);
        inverted.setOriginCenter();
        distortion = new Circle(0f);
        distortion.setPosition(BLACK_HOLE_SIZE / 2f, BLACK_HOLE_SIZE / 2f);

        this.blackHoleType = blackHoleType;
    }

    public void draw(SpriteBatch spriteBatch) {
        normal.draw(spriteBatch);
    }

    public void drawInverted(SpriteBatch spriteBatch) {
        inverted.draw(spriteBatch);
    }

    public void drawDistortion(ShapeRenderer shapeRenderer) {
        distortion.draw(shapeRenderer);
    }

    public void drawContour(ShapeRenderer shapeRenderer) {
        distortion.drawContour(shapeRenderer);
    }

    public void setPosition(float x, float y) {
        setPosition(new Vector2(x, y));
        normal.setPosition(x, y);
        inverted.setPosition(x, y);
        distortion.setPosition(x + BLACK_HOLE_SIZE / 2f, y + BLACK_HOLE_SIZE / 2f);
    }

    public void rotate(float degrees) {
        setRotation(rotation + degrees);
        normal.rotate(degrees);
        inverted.rotate(degrees);
    }

    public void setColor(Color color) {
        normal.setColor(color);
        inverted.setColor(color);
    }

    public void addDistortionRadius(float additionalRadius) {
        distortion.setRadius(distortion.getRadius() + additionalRadius);
    }

    public BlackHoleType getBlackHoleType() {
        return blackHoleType;
    }
}