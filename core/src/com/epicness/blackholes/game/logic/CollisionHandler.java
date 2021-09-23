package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Junk;
import com.epicness.blackholes.game.stuff.Ship;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;
import com.epicness.fundamentals.utils.Overlapper;

public class CollisionHandler {

    private GameLogic logic;
    private GameStuff stuff;

    public void update() {
        checkBlackHoleJunkCollisions();
        checkBlackHoleShipCollisions(stuff.playerShip);
        checkBlackHoleShipCollisions(stuff.enemyShip);
    }

    private void checkBlackHoleJunkCollisions() {
        DelayedRemovalArray<BlackHole> blackHoles = stuff.getBlackHoles();
        DelayedRemovalArray<Junk> junks = stuff.getJunks();

        junks.begin();
        for (int i = 0; i < blackHoles.size; i++) {
            BlackHole blackHole = blackHoles.get(i);
            for (int j = 0; j < junks.size; j++) {
                Junk junk = junks.get(j);
                if (blackHole.getCollider().overlaps(junk.getCollider())) {
                    junks.removeValue(junk, true);
                    logic.getBlackHoleHandler().junkAbsorbed(blackHole);
                    break;
                }
            }
        }
        junks.end();
    }

    private void checkBlackHoleShipCollisions(Ship ship) {
        DelayedRemovalArray<BlackHole> blackHoles = stuff.getBlackHoles();
        for (int i = 0; i < blackHoles.size; i++) {
            Circle blackHoleCollider = blackHoles.get(i).getCollider();
            for (int j = 0; j < ship.getComponents().size(); j++) {
                Polygon shipCollider = ship.getComponents().get(j).getCollider();
                if (Overlapper.overlapPolygonCircle(shipCollider, blackHoleCollider)) {
                    System.out.println("BOOM SHIP");
                }
            }
        }
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}