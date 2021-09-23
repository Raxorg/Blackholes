package com.epicness.blackholes.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.epicness.blackholes.AssetPaths.BACKGROUND_PATH;
import static com.epicness.blackholes.AssetPaths.INVERTED_BACKGROUND_PATH;

public class MenuAssets extends Assets {

    // Sprites
    private Sprite background;

    @Override
    public void queueAssetLoading() {
        assetManager.load(BACKGROUND_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        background = new Sprite(assetManager.get(BACKGROUND_PATH, Texture.class));
    }

    public Sprite getBackground() {
        return background;
    }
}