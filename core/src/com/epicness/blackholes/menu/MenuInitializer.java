package com.epicness.blackholes.menu;

import com.epicness.blackholes.menu.logic.MenuLogic;
import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;

public class MenuInitializer extends Initializer {

    public MenuInitializer() {
        super(new MenuAssets());
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new MenuLogic(sharedResources.getLogic());
        renderer = new MenuRenderer();
        stuff = new MenuStuff();
        // This is the first screen, so don't load async
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initializeAssets();
        super.initialize(sharedResources);
    }
}