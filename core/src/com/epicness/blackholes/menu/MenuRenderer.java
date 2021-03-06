package com.epicness.blackholes.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;

public class MenuRenderer extends Renderer {

    @Override
    public void render() {
        MenuStuff stuff = (MenuStuff) this.stuff;

        ScreenUtils.clear(Color.BLACK);

        spriteBatch.begin();
        stuff.getBackground().draw(spriteBatch);
        stuff.getPlayButton().draw(spriteBatch);
        stuff.getTutorialButton().draw(spriteBatch);
        stuff.getCreditsButton().draw(spriteBatch);
        stuff.getTutorial().draw(spriteBatch);
        stuff.getCredits().draw(spriteBatch);
        spriteBatch.end();
    }
}