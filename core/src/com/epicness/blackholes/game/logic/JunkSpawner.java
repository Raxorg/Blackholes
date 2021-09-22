package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Junk;

import static com.epicness.blackholes.game.GameConstants.INITIAL_JUNK;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class JunkSpawner {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private float time;

    public void spawnInitialJunk() {
        DelayedRemovalArray<Junk> junks = stuff.getJunks();
        for (int i = 0; i < INITIAL_JUNK; i++) {
            Junk junk = new Junk(assets.getBlackHoleGlow(), assets.getInvertedBlackHoleGlow());
            float randomX = MathUtils.random(0, CAMERA_WIDTH);
            float randomY = MathUtils.random(0, CAMERA_HEIGHT);
            junk.setPosition(new Vector2(randomX, randomY));
            float randomAngularVelocity = MathUtils.random(-50f, 50f);
            junk.setAngularVelocity(randomAngularVelocity);
            junks.add(junk);
        }
    }

    public void update(float delta) {
        time += delta;

    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}