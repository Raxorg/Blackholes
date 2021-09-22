package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Junk;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;

public class CollisionHandler {

    private GameStuff stuff;

    public void update() {
        checkBlackHoleJunkCollisions();
        checkBlackHoleShipCollisions();
    }

    private void checkBlackHoleJunkCollisions() {
        DelayedRemovalArray<BlackHole> blackHoles = stuff.getBlackHoles();
        DelayedRemovalArray<Junk> junks = stuff.getJunks();

        for (int i = 0; i < blackHoles.size; i++) {
            BlackHole blackHole = blackHoles.get(i);
            for (int j = 0; j < junks.size; j++) {
                Junk junk = junks.get(i);
                if (blackHole.getBounds().overlaps(junk.getBounds())) {
                    System.out.println("BOOM");
                    // TODO: 22/9/2021 what happens here?!
                }
            }
        }
    }

    private void checkBlackHoleShipCollisions() {

    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}