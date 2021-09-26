package com.epicness.blackholes.menu;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.stuff.NinePatchedText;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;

import static com.epicness.blackholes.menu.MenuConstants.BUTTON_HEIGHT;
import static com.epicness.blackholes.menu.MenuConstants.BUTTON_WIDTH;
import static com.epicness.blackholes.menu.MenuConstants.BUTTON_X;
import static com.epicness.blackholes.menu.MenuConstants.CREDITS_BUTTON_Y;
import static com.epicness.blackholes.menu.MenuConstants.PLAY_BUTTON_Y;
import static com.epicness.blackholes.menu.MenuConstants.TUTORIAL_BUTTON_Y;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class MenuStuff extends Stuff {

    private Sprited background;
    private NinePatchedText playButton, tutorialButton, creditsButton;
    private Sprited tutorial, credits;

    @Override
    public void initializeStuff() {
        MenuAssets assets = (MenuAssets) this.assets;
        sharedAssets.getPixelFont().getData().setScale(5f);

        background = new Sprited(assets.getBackground());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        playButton = new NinePatchedText(
                sharedAssets.getSquare().getTexture(),
                sharedAssets.getPixelFont(),
                1,
                10f);
        playButton.setPosition(BUTTON_X, PLAY_BUTTON_Y);
        playButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        playButton.setText("Play");

        tutorialButton = new NinePatchedText(
                sharedAssets.getSquare().getTexture(),
                sharedAssets.getPixelFont(),
                1,
                10f);
        tutorialButton.setPosition(BUTTON_X, TUTORIAL_BUTTON_Y);
        tutorialButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        tutorialButton.setText("Tutorial");

        creditsButton = new NinePatchedText(
                sharedAssets.getSquare().getTexture(),
                sharedAssets.getPixelFont(),
                1,
                10f);
        creditsButton.setPosition(BUTTON_X, CREDITS_BUTTON_Y);
        creditsButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        creditsButton.setText("Credits");

        tutorial = new Sprited(assets.getTutorial());
        tutorial.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        tutorial.setColor(Color.CLEAR);

        credits = new Sprited(assets.getCredits());
        credits.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        credits.setColor(Color.CLEAR);
    }

    public Sprited getBackground() {
        return background;
    }

    public NinePatchedText getPlayButton() {
        return playButton;
    }

    public NinePatchedText getTutorialButton() {
        return tutorialButton;
    }

    public NinePatchedText getCreditsButton() {
        return creditsButton;
    }

    public Sprited getTutorial() {
        return tutorial;
    }

    public Sprited getCredits() {
        return credits;
    }
}