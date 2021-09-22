package com.epicness.fundamentals.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Overlapper {

    /* Also returns true if the polygon contains the circle */
    public static boolean overlapPolygonCircle(Polygon polygon, Circle circle) {
        float[] vertices = polygon.getTransformedVertices();
        Vector2 start = new Vector2();
        Vector2 end = new Vector2();
        Vector2 center = new Vector2(circle.x, circle.y);
        float squareRadius = circle.radius * circle.radius;
        /* Loop through the segments of the polygon */
        for (int i = 0; i < vertices.length; i += 2) {
            if (i == 0) {
                start.set(vertices[vertices.length - 2], vertices[vertices.length - 1]);
            } else {
                start.set(vertices[i - 2], vertices[i - 1]);
            }
            end.set(vertices[i], vertices[i + 1]);
            if (Intersector.intersectSegmentCircle(start, end, center, squareRadius)) {
                return true;
            }
        }
        return polygon.contains(circle.x, circle.y);
    }
}