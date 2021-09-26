package com.epicness.blackholes.menu.logic;

import com.epicness.blackholes.menu.MenuAssets;
import com.epicness.blackholes.menu.MenuStuff;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class MenuLogic extends Logic {

    private final ButtonHandler buttonHandler;
    private final MenuInputHandler menuInputHandler;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        buttonHandler = new ButtonHandler();
        menuInputHandler = new MenuInputHandler();

        buttonHandler.setSharedLogic(sharedLogic);
        menuInputHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        menuInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {
        sharedLogic.getTransitionHandler().update();
        sharedLogic.getAssetLoader().update();
    }

    @Override
    public void setAssets(Assets assets) {
        MenuAssets menuAssets = (MenuAssets) assets;
        menuAssets.getBackgroundMusic().setLooping(true);
        menuAssets.getBackgroundMusic().play();
    }

    @Override
    public void setInput(SharedInput input) {
        buttonHandler.setInput(input);
        menuInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        MenuStuff menuStuff = (MenuStuff) stuff;
        buttonHandler.setStuff(menuStuff);
        menuInputHandler.setStuff(menuStuff);
    }

    public ButtonHandler getButtonHandler() {
        return buttonHandler;
    }
}