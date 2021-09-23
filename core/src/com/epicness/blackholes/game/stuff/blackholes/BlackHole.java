package com.epicness.blackholes.game.stuff.blackholes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.stuff.SpaceObject;
import com.epicness.fundamentals.stuff.AdvancedCircle;
import com.epicness.fundamentals.stuff.DualSprited;

import static com.epicness.blackholes.game.GameConstants.BH_COLLIDER_INITIAL_RADIUS;
import static com.epicness.blackholes.game.GameConstants.BH_COLLIDER_MAX_RADIUS;
import static com.epicness.blackholes.game.GameConstants.BLACK_HOLE_INITIAL_SIZE;
import static com.epicness.blackholes.game.GameConstants.BLACK_HOLE_MAX_SIZE;

public class BlackHole extends SpaceObject {

    private final DualSprited normal;
    private final DualSprited inverted;
    private final AdvancedCircle distortion;
    private final BlackHoleType blackHoleType;

    public BlackHole(Sprite blackHole, Sprite blackHoleGlow,
                     Sprite invertedBlackHole, Sprite invertedBlackHoleGlow,
                     BlackHoleType blackHoleType) {
        normal = new DualSprited(blackHoleGlow, blackHole);
        normal.setSize(BLACK_HOLE_INITIAL_SIZE, BLACK_HOLE_INITIAL_SIZE);
        normal.setOriginCenter();

        inverted = new DualSprited(invertedBlackHoleGlow, invertedBlackHole);
        inverted.setSize(BLACK_HOLE_INITIAL_SIZE, BLACK_HOLE_INITIAL_SIZE);
        inverted.setOriginCenter();

        distortion = new AdvancedCircle(0f);
        distortion.setPosition(BLACK_HOLE_INITIAL_SIZE / 2f, BLACK_HOLE_INITIAL_SIZE / 2f);

        this.blackHoleType = blackHoleType;

        collider = new AdvancedCircle(BH_COLLIDER_INITIAL_RADIUS);
    }

    @Override
    public void drawNormal(SpriteBatch spriteBatch) {
        normal.draw(spriteBatch);
    }

    @Override
    public void drawInverted(SpriteBatch spriteBatch) {
        inverted.draw(spriteBatch);
    }

    @Override
    public void drawCollider(ShapeRenderer shapeRenderer) {
        ((AdvancedCircle) collider).draw(shapeRenderer);
    }

    public void drawDistortion(ShapeRenderer shapeRenderer) {
        distortion.draw(shapeRenderer);
    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
        float x = position.x, y = position.y;
        normal.setPosition(x - normal.getWidth() / 2f, y - normal.getWidth() / 2f);
        inverted.setPosition(x - inverted.getWidth() / 2f, y - inverted.getWidth() / 2f);
        distortion.setPosition(x, y);
        ((AdvancedCircle) collider).setPosition(x, y);
    }

    public void rotate(float degrees) {
        setRotation(rotation + degrees);
        normal.rotate(degrees);
        inverted.rotate(degrees);
    }

    public void setColor(Color color) {
        normal.setBackgroundColor(color);
        inverted.setForegroundColor(color);
    }

    public void addRadius(float additionalRadius) {
        ((AdvancedCircle) collider).radius += additionalRadius;
        float newSize = MathUtils.map(
                BH_COLLIDER_INITIAL_RADIUS, BH_COLLIDER_MAX_RADIUS,
                BLACK_HOLE_INITIAL_SIZE, BLACK_HOLE_MAX_SIZE, ((AdvancedCircle) collider).radius);
        normal.setSize(newSize);
        normal.setOriginCenter();
        float x = position.x - normal.getWidth() / 2f;
        float y = position.y - normal.getWidth() / 2f;
        normal.setPosition(x, y);
        inverted.setSize(newSize);
        inverted.setOriginCenter();
        inverted.setPosition(x, y);
    }

    public void addDistortionRadius(float additionalRadius) {
        distortion.radius += additionalRadius;
    }

    public BlackHoleType getBlackHoleType() {
        return blackHoleType;
    }

    public AdvancedCircle getCollider() {
        return (AdvancedCircle) collider;
    }
}