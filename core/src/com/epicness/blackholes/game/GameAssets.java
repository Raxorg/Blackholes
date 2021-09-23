package com.epicness.blackholes.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.blackholes.AssetPaths.BACKGROUND_PATH;
import static com.epicness.blackholes.AssetPaths.BLACK_HOLE_GLOW_PATH;
import static com.epicness.blackholes.AssetPaths.BLACK_HOLE_PATH;
import static com.epicness.blackholes.AssetPaths.COCKPIT_PATH;
import static com.epicness.blackholes.AssetPaths.GUN_PATH;
import static com.epicness.blackholes.AssetPaths.INVERTED_BACKGROUND_PATH;
import static com.epicness.blackholes.AssetPaths.INVERTED_BLACK_HOLE_GLOW_PATH;
import static com.epicness.blackholes.AssetPaths.INVERTED_BLACK_HOLE_PATH;
import static com.epicness.blackholes.AssetPaths.SHIELDS_PATH;
import static com.epicness.blackholes.AssetPaths.THRUSTER_PATH;

public class GameAssets extends Assets {

    private Sprite background, invertedBackground;
    private Sprite blackHole, blackHoleGlow, invertedBlackHole, invertedBlackHoleGlow;
    private Sprite shipCockpit, shipGun, shipShields, shipThruster;

    @Override
    public void queueAssetLoading() {
        assetManager.load(BACKGROUND_PATH, Texture.class);
        assetManager.load(INVERTED_BACKGROUND_PATH, Texture.class);
        assetManager.load(BLACK_HOLE_PATH, Texture.class);
        assetManager.load(BLACK_HOLE_GLOW_PATH, Texture.class);
        assetManager.load(INVERTED_BLACK_HOLE_PATH, Texture.class);
        assetManager.load(INVERTED_BLACK_HOLE_GLOW_PATH, Texture.class);

        assetManager.load(COCKPIT_PATH, Texture.class);
        assetManager.load(GUN_PATH, Texture.class);
        assetManager.load(SHIELDS_PATH, Texture.class);
        assetManager.load(THRUSTER_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
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
        shipGun = new Sprite(assetManager.get(GUN_PATH, Texture.class));
        shipShields = new Sprite(assetManager.get(SHIELDS_PATH, Texture.class));
        shipThruster = new Sprite(assetManager.get(THRUSTER_PATH, Texture.class));
    }

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

    public Sprite getShipGun() {
        return shipGun;
    }

    public Sprite getShipShields() {
        return shipShields;
    }

    public Sprite getShipThruster() {
        return shipThruster;
    }
}