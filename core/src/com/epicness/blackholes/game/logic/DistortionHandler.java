package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;

import static com.epicness.blackholes.game.GameConstants.DISTORTION_SPEED;

public class DistortionHandler {

    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<BlackHole> blackHoles = stuff.getBlackHoles();
        for (int i = 0; i < blackHoles.size; i++) {
            blackHoles.get(i).addDistortionRadius(delta * DISTORTION_SPEED);
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}