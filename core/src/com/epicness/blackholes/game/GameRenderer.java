package com.epicness.blackholes.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;

public class GameRenderer extends Renderer {

    public GameRenderer() {

    }

    @Override
    public void render() {
        GameStuff stuff = (GameStuff) this.stuff;

        ScreenUtils.clear(Color.BLACK);

        drawUnmasked(stuff);
        drawMasks(stuff);
        drawMasked(stuff);

        Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);
    }

    private void drawUnmasked(GameStuff stuff) {
        spriteBatch.begin();
        stuff.background.drawBackground(spriteBatch);
        for (int i = 0; i < stuff.blackHoles.size; i++) {
            stuff.blackHoles.get(i).drawNormal(spriteBatch);
        }
        for (int i = 0; i < stuff.junks.size; i++) {
            stuff.junks.get(i).drawNormal(spriteBatch);
        }
        stuff.player1Ship.drawNormal(spriteBatch);
        stuff.player2Ship.drawNormal(spriteBatch);
        stuff.damageOverlay.draw(spriteBatch);
        spriteBatch.end();
        shapeRenderer.begin();
        for (int i = 0; i < stuff.junks.size; i++) {
            stuff.junks.get(i).drawCollider(shapeRenderer);
        }
        for (int i = 0; i < stuff.blackHoles.size; i++) {
            stuff.blackHoles.get(i).drawDistortion(shapeRenderer);
            stuff.blackHoles.get(i).drawCollider(shapeRenderer);
        }
        stuff.player1Ship.drawCollider(shapeRenderer);
        stuff.player2Ship.drawCollider(shapeRenderer);
        shapeRenderer.end();
    }

    private void drawMasks(GameStuff stuff) {
        // 1. Clear our depth buffer with 1.0
        Gdx.gl.glClear(GL20.GL_DEPTH_BUFFER_BIT);

        // 2. Set the function to LESS
        Gdx.gl.glDepthFunc(GL20.GL_LESS);

        // 3. Enable depth writing
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);

        // 4. Enable depth writing, disable RGBA color writing
        Gdx.gl.glColorMask(false, false, false, false);

        // 5. Render mask elements
        shapeRenderer.begin(Filled);
        for (int i = 0; i < stuff.blackHoles.size; i++) {
            stuff.blackHoles.get(i).drawDistortion(shapeRenderer);
        }
        shapeRenderer.end();
    }

    private void drawMasked(GameStuff stuff) {
        Gdx.gl.glColorMask(true, true, true, true);
        Gdx.gl.glDepthFunc(GL20.GL_EQUAL);

        spriteBatch.begin();
        stuff.background.drawForeground(spriteBatch);
        for (int i = 0; i < stuff.blackHoles.size; i++) {
            stuff.blackHoles.get(i).drawInverted(spriteBatch);
        }
        for (int i = 0; i < stuff.junks.size; i++) {
            stuff.junks.get(i).drawInverted(spriteBatch);
        }
        stuff.player1Ship.drawInverted(spriteBatch);
        stuff.player2Ship.drawInverted(spriteBatch);
        spriteBatch.end();
    }
}