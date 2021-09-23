package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;

import static com.epicness.blackholes.game.GameConstants.BLACK_HOLE_RADIUS_INCREMENT;
import static com.epicness.blackholes.game.GameConstants.BLACK_HOLE_ROTATION_SPEED;

public class BlackHoleHandler {

    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<BlackHole> blackHoles = stuff.getBlackHoles();
        for (int i = 0; i < blackHoles.size; i++) {
            blackHoles.get(i).rotate(delta * BLACK_HOLE_ROTATION_SPEED);
            blackHoles.get(i).setPosition(blackHoles.get(i).getPosition().add(0.5f, 0.5f));
        }
    }

    private void handleAlphaBlackHole() {

    }

    public void junkAbsorbed(BlackHole blackHole) {
        blackHole.addRadius(BLACK_HOLE_RADIUS_INCREMENT);
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}