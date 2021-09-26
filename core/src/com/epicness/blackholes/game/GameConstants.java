package com.epicness.blackholes.game;

public class GameConstants {

    // BlackHoles
    public static final float BLACK_HOLE_INITIAL_LIFE = 5f;
    public static final float BLACK_HOLE_INITIAL_SIZE = 100f;
    public static final float BLACK_HOLE_MAX_SIZE = BLACK_HOLE_INITIAL_SIZE * 10f;
    public static final float BLACK_HOLE_ROTATION_SPEED = 250f;
    public static final float BLACK_HOLE_RADIUS_INCREMENT = 15f;
    public static final float BH_COLLIDER_INITIAL_RADIUS = BLACK_HOLE_INITIAL_SIZE / 3f;
    public static final float BH_COLLIDER_MAX_RADIUS = BH_COLLIDER_INITIAL_RADIUS * 10f;
    public static final float DISTORTION_SPEED = 60f;

    // Junk
    public static final int INITIAL_JUNK = 35;
    public static final float JUNK_SPAWN_RATE = 1.5f;
    public static final float JUNK_SIZE = 30f;
    public static final float JUNK_RADIUS = JUNK_SIZE / 2f;
    public static final float JUNK_COLLIDER_RADIUS = JUNK_SIZE / 3f;

    // Ships
    public static final float SHIP_ACCELERATION_SPEED = 10f;
    public static final float SHIP_TURN_SPEED = 100f;
    public static final float SHIP_SHOOT_COOLDOWN = 1.5f;
    public static final int COMPONENT_STARTING_HEALTH = 50;

    // Other
    public static final float DAMAGE_FADE_SPEED = 2f;
}