package com.epicness.blackholes.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.blackholes.AssetPaths.BACKGROUND_PATH;
import static com.epicness.blackholes.AssetPaths.BLACK_HOLE_GLOW_PATH;
import static com.epicness.blackholes.AssetPaths.BLACK_HOLE_PATH;
import static com.epicness.blackholes.AssetPaths.COCKPIT_INVERTED_PATH;
import static com.epicness.blackholes.AssetPaths.COCKPIT_PATH;
import static com.epicness.blackholes.AssetPaths.INVERTED_BACKGROUND_PATH;
import static com.epicness.blackholes.AssetPaths.INVERTED_BLACK_HOLE_GLOW_PATH;
import static com.epicness.blackholes.AssetPaths.INVERTED_BLACK_HOLE_PATH;
import static com.epicness.blackholes.AssetPaths.LEFT_GUN_INVERTED_PATH;
import static com.epicness.blackholes.AssetPaths.LEFT_GUN_PATH;
import static com.epicness.blackholes.AssetPaths.NUCLEUS_INVERTED_PATH;
import static com.epicness.blackholes.AssetPaths.NUCLEUS_PATH;
import static com.epicness.blackholes.AssetPaths.RIGHT_GUN_INVERTED_PATH;
import static com.epicness.blackholes.AssetPaths.RIGHT_GUN_PATH;
import static com.epicness.blackholes.AssetPaths.SHOOT_PATH;
import static com.epicness.blackholes.AssetPaths.THRUSTER_INVERTED_PATH;
import static com.epicness.blackholes.AssetPaths.THRUSTER_PATH;

public class GameAssets extends Assets {

    // Audio
    private Sound shoot;
    // Sprites
    private Sprite background, invertedBackground;
    private Sprite blackHole, blackHoleGlow, invertedBlackHole, invertedBlackHoleGlow;
    private Sprite shipCockpit, shipLeftGun, shipRightGun, shipNucleus, shipThruster;
    private Sprite shipCockpitInverted, shipLeftGunInverted, shipRightGunInverted, shipNucleusInverted, shipThrusterInverted;

    @Override
    public void queueAssetLoading() {
        assetManager.load(SHOOT_PATH, Sound.class);

        assetManager.load(BACKGROUND_PATH, Texture.class);
        assetManager.load(INVERTED_BACKGROUND_PATH, Texture.class);
        assetManager.load(BLACK_HOLE_PATH, Texture.class);
        assetManager.load(BLACK_HOLE_GLOW_PATH, Texture.class);
        assetManager.load(INVERTED_BLACK_HOLE_PATH, Texture.class);
        assetManager.load(INVERTED_BLACK_HOLE_GLOW_PATH, Texture.class);

        assetManager.load(COCKPIT_PATH, Texture.class);
        assetManager.load(LEFT_GUN_PATH, Texture.class);
        assetManager.load(RIGHT_GUN_PATH, Texture.class);
        assetManager.load(NUCLEUS_PATH, Texture.class);
        assetManager.load(THRUSTER_PATH, Texture.class);

        assetManager.load(COCKPIT_INVERTED_PATH, Texture.class);
        assetManager.load(LEFT_GUN_INVERTED_PATH, Texture.class);
        assetManager.load(RIGHT_GUN_INVERTED_PATH, Texture.class);
        assetManager.load(NUCLEUS_INVERTED_PATH, Texture.class);
        assetManager.load(THRUSTER_INVERTED_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        shoot = assetManager.get(SHOOT_PATH, Sound.class);

        background = new Sprite(assetManager.get(BACKGROUND_PATH, Texture.class));
        invertedBackground = new Sprite(assetManager.get(INVERTED_BACKGROUND_PATH, Texture.class));
        blackHole = new Sprite(assetManager.get(BLACK_HOLE_PATH, Texture.class));
        blackHole.getTexture().setFilter(Linear, Linear);
        blackHoleGlow = new Sprite(assetManager.get(BLACK_HOLE_GLOW_PATH, Texture.class));
        blackHoleGlow.getTexture().setFilter(Linear, Linear);
        invertedBlackHole = new Sprite(assetManager.get(INVERTED_BLACK_HOLE_PATH, Texture.class));
        invertedBlackHole.getTexture().setFilter(Linear, Linear);
        invertedBlackHoleGlow = new Sprite(assetManager.get(INVERTED_BLACK_HOLE_GLOW_PATH, Texture.class));
        invertedBlackHoleGlow.getTexture().setFilter(Linear, Linear);

        shipCockpit = new Sprite(assetManager.get(COCKPIT_PATH, Texture.class));
        shipLeftGun = new Sprite(assetManager.get(LEFT_GUN_PATH, Texture.class));
        shipRightGun = new Sprite(assetManager.get(RIGHT_GUN_PATH, Texture.class));
        shipNucleus = new Sprite(assetManager.get(NUCLEUS_PATH, Texture.class));
        shipThruster = new Sprite(assetManager.get(THRUSTER_PATH, Texture.class));

        shipCockpitInverted = new Sprite(assetManager.get(COCKPIT_INVERTED_PATH, Texture.class));
        shipLeftGunInverted = new Sprite(assetManager.get(LEFT_GUN_INVERTED_PATH, Texture.class));
        shipRightGunInverted = new Sprite(assetManager.get(RIGHT_GUN_INVERTED_PATH, Texture.class));
        shipNucleusInverted = new Sprite(assetManager.get(NUCLEUS_INVERTED_PATH, Texture.class));
        shipThrusterInverted = new Sprite(assetManager.get(THRUSTER_INVERTED_PATH, Texture.class));
    }

    // Audio
    public Sound getShoot() {
        return shoot;
    }

    // Sprites
    public Sprite getBackground() {
        return background;
    }

    public Sprite getInvertedBackground() {
        return invertedBackground;
    }

    public Sprite getBlackHole() {
        return blackHole;
    }

    public Sprite getBlackHoleGlow() {
        return blackHoleGlow;
    }

    public Sprite getInvertedBlackHole() {
        return invertedBlackHole;
    }

    public Sprite getInvertedBlackHoleGlow() {
        return invertedBlackHoleGlow;
    }

    public Sprite getShipCockpit() {
        return shipCockpit;
    }

    public Sprite getShipLeftGun() {
        return shipLeftGun;
    }

    public Sprite getShipRightGun() {
        return shipRightGun;
    }

    public Sprite getShipNucleus() {
        return shipNucleus;
    }

    public Sprite getShipThruster() {
        return shipThruster;
    }

    public Sprite getShipCockpitInverted() {
        return shipCockpitInverted;
    }

    public Sprite getShipLeftGunInverted() {
        return shipLeftGunInverted;
    }

    public Sprite getShipRightGunInverted() {
        return shipRightGunInverted;
    }

    public Sprite getShipNucleusInverted() {
        return shipNucleusInverted;
    }

    public Sprite getShipThrusterInverted() {
        return shipThrusterInverted;
    }
}