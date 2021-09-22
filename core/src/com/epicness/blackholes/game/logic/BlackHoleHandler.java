package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;

public class BlackHoleHandler {

    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<BlackHole> blackHoles = stuff.getBlackHoles();
        for (int i = 0; i < blackHoles.size; i++) {
            blackHoles.get(i).rotate(delta * 50f);
            blackHoles.get(i).setPosition(blackHoles.get(i).getPosition().add(4f, 1f));
        }
    }

    private void handleAlphaBlackHole() {

    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}