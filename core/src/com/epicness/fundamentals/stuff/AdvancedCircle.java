package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

public class AdvancedCircle extends Circle {

    private Color color;

    public AdvancedCircle(float radius) {
        this.radius = radius;
        color = Color.WHITE;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius);
    }

    public void drawContour(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color.cpy().set(1 - color.r, 1 - color.g, 1 - color.b, 1f));
        shapeRenderer.circle(x, y, radius);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}