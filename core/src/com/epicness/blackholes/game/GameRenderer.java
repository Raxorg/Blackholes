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
        for (int i = 0; i < stuff.getBlackHoles().size; i++) {
            stuff.getBlackHoles().get(i).drawNormal(spriteBatch);
        }
        for (int i = 0; i < stuff.getJunks().size; i++) {
            stuff.getJunks().get(i).drawNormal(spriteBatch);
        }
        spriteBatch.end();
        shapeRenderer.begin();
        for (int i = 0; i < stuff.getJunks().size; i++) {
            stuff.getJunks().get(i).drawCollider(shapeRenderer);
        }
        for (int i = 0; i < stuff.getBlackHoles().size; i++) {
            stuff.getBlackHoles().get(i).drawDistortion(shapeRenderer);
            stuff.getBlackHoles().get(i).drawCollider(shapeRenderer);
        }
        stuff.playerShip.drawCollider(shapeRenderer);
        stuff.enemyShip.drawCollider(shapeRenderer);
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
        for (int i = 0; i < stuff.getBlackHoles().size; i++) {
            stuff.getBlackHoles().get(i).drawDistortion(shapeRenderer);
        }
        shapeRenderer.end();
    }

    private void drawMasked(GameStuff stuff) {
        Gdx.gl.glColorMask(true, true, true, true);
        Gdx.gl.glDepthFunc(GL20.GL_EQUAL);

        spriteBatch.begin();
        for (int i = 0; i < stuff.getBlackHoles().size; i++) {
            stuff.getBlackHoles().get(i).drawInverted(spriteBatch);
        }
        for (int i = 0; i < stuff.getJunks().size; i++) {
            stuff.getJunks().get(i).drawInverted(spriteBatch);
        }
        spriteBatch.end();
    }
}