package com.epicness.blackholes.menu.logic;

import com.epicness.blackholes.menu.MenuStuff;
import com.epicness.fundamentals.input.InputHandler;

public class MenuInputHandler extends InputHandler {

    @Override
    public void touchDown(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        MenuStuff stuff = (MenuStuff) this.stuff;

        if (stuff.getPlayButton().contains(x, y)) {
            logic.getButtonHandler().playButtonPress();
        }
    }

    @Override
    public void touchDragged(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        logic.getButtonHandler().hover(x, y);
    }

    @Override
    public void touchUp(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        logic.getButtonHandler().release(x, y);
    }
}