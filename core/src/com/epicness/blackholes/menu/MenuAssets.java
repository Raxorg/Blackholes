package com.epicness.blackholes.menu;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.epicness.blackholes.AssetPaths.BACKGROUND_PATH;
import static com.epicness.blackholes.AssetPaths.BGM_PATH;
import static com.epicness.blackholes.AssetPaths.CREDITS_PATH;
import static com.epicness.blackholes.AssetPaths.TUTORIAL_PATH;

public class MenuAssets extends Assets {

    // Audio
    private Music backgroundMusic;
    // Sprites
    private Sprite background, tutorial, credits;

    @Override
    public void queueAssetLoading() {
        // Audio
        assetManager.load(BGM_PATH, Music.class);
        // Sprites
        assetManager.load(BACKGROUND_PATH, Texture.class);
        assetManager.load(TUTORIAL_PATH, Texture.class);
        assetManager.load(CREDITS_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        // Audio
        backgroundMusic = assetManager.get(BGM_PATH, Music.class);
        // Sprites
        background = new Sprite(assetManager.get(BACKGROUND_PATH, Texture.class));
        tutorial = new Sprite(assetManager.get(TUTORIAL_PATH, Texture.class));
        credits = new Sprite(assetManager.get(CREDITS_PATH, Texture.class));
    }

    // Audio
    public Music getBackgroundMusic() {
        return backgroundMusic;
    }

    // Sprites
    public Sprite getBackground() {
        return background;
    }

    public Sprite getTutorial() {
        return tutorial;
    }

    public Sprite getCredits() {
        return credits;
    }
}