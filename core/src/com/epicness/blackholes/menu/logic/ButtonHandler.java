package com.epicness.blackholes.menu.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.blackholes.game.GameInitializer;
import com.epicness.blackholes.menu.MenuStuff;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.SharedLogic;

public class ButtonHandler {

    private SharedInput input;
    private SharedLogic sharedLogic;
    private MenuStuff stuff;
    // Logic
    private boolean onTutorial, onCredits;

    public void playButtonPress() {
        stuff.getPlayButton().setColor(Color.BLACK);
    }

    public void tutorialButtonPress() {
        stuff.getTutorialButton().setColor(Color.BLACK);
    }

    public void creditsButtonPress() {
        stuff.getCreditsButton().setColor(Color.BLACK);
    }

    public void release(float x, float y) {
        stuff.getPlayButton().setColor(Color.WHITE);
        stuff.getTutorialButton().setColor(Color.WHITE);
        stuff.getCreditsButton().setColor(Color.WHITE);
        if (onTutorial) {
            stuff.getTutorial().setColor(Color.CLEAR);
            onTutorial = false;
            return;
        }
        if (onCredits) {
            stuff.getCredits().setColor(Color.CLEAR);
            onCredits = false;
            return;
        }
        if (stuff.getPlayButton().contains(x, y)) {
            sharedLogic.getTransitionHandler().startTransition(new GameInitializer());
            sharedLogic.getTransitionHandler().allowTransition();
            input.setEnabled(false);
        } else if (stuff.getTutorialButton().contains(x, y)) {
            stuff.getTutorial().setColor(Color.WHITE);
            onTutorial = true;
        } else if (stuff.getCreditsButton().contains(x, y)) {
            stuff.getCredits().setColor(Color.WHITE);
            onCredits = true;
        }
    }

    public void hover(float x, float y) {
        stuff.getPlayButton().setColor(Color.WHITE);
        stuff.getTutorialButton().setColor(Color.WHITE);
        stuff.getCreditsButton().setColor(Color.WHITE);
        if (stuff.getPlayButton().contains(x, y)) {
            stuff.getPlayButton().setColor(Color.BLACK);
        } else if (stuff.getTutorialButton().contains(x, y)) {
            stuff.getTutorialButton().setColor(Color.BLACK);
        } else if (stuff.getCreditsButton().contains(x, y)) {
            stuff.getCreditsButton().setColor(Color.BLACK);
        }
    }

    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}