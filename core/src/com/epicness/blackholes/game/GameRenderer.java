package com.epicness.blackholes.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Ship;
import com.epicness.blackholes.game.stuff.SpaceObject;
import com.epicness.fundamentals.renderer.Renderer;

public class GameRenderer extends Renderer {

    Ship ship;

    public GameRenderer() {
        ship = new Ship();
    }

    @Override
    public void render() {
        GameStuff stuff = (GameStuff) this.stuff;

        ScreenUtils.clear(Color.BLACK);

        spriteBatch.begin();

        //This just draws the bounding boxes of all the "SpaceObjects" --> basically anything that's going to float around in space
        shapeRenderer.begin();
        ship.draw(shapeRenderer);
        shapeRenderer.end();

        spriteBatch.end();
    }
}