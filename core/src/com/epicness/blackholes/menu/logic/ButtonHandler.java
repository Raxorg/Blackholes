package com.epicness.blackholes.menu.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.blackholes.game.GameInitializer;
import com.epicness.blackholes.menu.MenuStuff;
import com.epicness.fundamentals.logic.SharedLogic;

public class ButtonHandler {

    private SharedLogic sharedLogic;
    private MenuStuff stuff;

    public void playButtonPress() {
        stuff.getPlayButton().setColor(Color.BLACK);
    }

    public void release(float x, float y) {
        stuff.getPlayButton().setColor(Color.WHITE);
        if (stuff.getPlayButton().contains(x, y)) {
            sharedLogic.getTransitionHandler().startTransition(new GameInitializer());
            sharedLogic.getTransitionHandler().allowTransition();
        }
    }

    public void hover(float x, float y) {
        stuff.getPlayButton().setColor(Color.WHITE);
        if (stuff.getPlayButton().contains(x, y)) {
            stuff.getPlayButton().setColor(Color.BLACK);
        }
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}