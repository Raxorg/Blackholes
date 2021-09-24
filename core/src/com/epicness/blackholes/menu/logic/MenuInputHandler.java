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
        } else if (stuff.getTutorialButton().contains(x, y)) {
            logic.getButtonHandler().tutorialButtonPress();
        } else if (stuff.getCreditsButton().contains(x, y)) {
            logic.getButtonHandler().creditsButtonPress();
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