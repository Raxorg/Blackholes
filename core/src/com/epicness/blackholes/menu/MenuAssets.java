package com.epicness.blackholes.menu;

import com.epicness.fundamentals.assets.Assets;

public class MenuAssets extends Assets {

    @Override
    public void queueAssetLoading() {

    }

    @Override
    public boolean loadAssets() {
        return assetManager.update();
    }

    @Override
    public void initializeAssets() {

    }
}