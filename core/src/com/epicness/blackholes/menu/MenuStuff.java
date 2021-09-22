package com.epicness.blackholes.menu;

import com.epicness.fundamentals.stuff.NinePatchedText;
import com.epicness.fundamentals.stuff.Stuff;

import static com.epicness.blackholes.menu.MenuConstants.PLAY_BUTTON_HEIGHT;
import static com.epicness.blackholes.menu.MenuConstants.PLAY_BUTTON_WIDTH;
import static com.epicness.blackholes.menu.MenuConstants.PLAY_BUTTON_X;
import static com.epicness.blackholes.menu.MenuConstants.PLAY_BUTTON_Y;

public class MenuStuff extends Stuff {

    private NinePatchedText playButton;

    @Override
    public void initializeStuff() {
        sharedAssets.getPixelFont().getData().setScale(5f);

        playButton = new NinePatchedText(
                sharedAssets.getSquare().getTexture(),
                sharedAssets.getPixelFont(),
                1,
                10f);
        playButton.setPosition(PLAY_BUTTON_X, PLAY_BUTTON_Y);
        playButton.setSize(PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        playButton.setText("Play");
    }

    public NinePatchedText getPlayButton() {
        return playButton;
    }
}