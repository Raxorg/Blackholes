package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Ship;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;
import com.epicness.blackholes.game.stuff.blackholes.BlackHoleType;

import static com.epicness.blackholes.game.GameConstants.BLACK_HOLE_INITIAL_LIFE;
import static com.epicness.blackholes.game.GameConstants.BLACK_HOLE_RADIUS_INCREMENT;
import static com.epicness.blackholes.game.GameConstants.BLACK_HOLE_ROTATION_SPEED;

public class BlackHoleHandler {

    private GameAssets assets;
    private GameStuff stuff;

    public void spawnBlackHole(Ship owner, Vector2 direction, BlackHoleType type) {
        BlackHole blackHole = new BlackHole(
                assets.getBlackHole(), assets.getBlackHoleGlow(),
                assets.getInvertedBlackHole(), assets.getInvertedBlackHoleGlow(),
                type, owner);
        blackHole.setPosition(owner.getPosition().cpy().add(direction.cpy().scl(80f)));
        blackHole.setVelocity(direction.scl(100f));
        blackHole.setColor(owner.getTeam());
        stuff.blackHoles.add(blackHole);
    }

    public void update(float delta) {
        DelayedRemovalArray<BlackHole> blackHoles = stuff.blackHoles;
        blackHoles.begin();
        for (int i = 0; i < blackHoles.size; i++) {
            BlackHole blackHole = blackHoles.get(i);
            blackHole.rotate(delta * BLACK_HOLE_ROTATION_SPEED);
            switch (blackHole.getType()) {
                case ALPHA:
                    handleAlphaBlackHole(blackHole);
                    break;
                case REPULSION:
                    handleRepulsionBlackHole(blackHole);
                    break;
            }
            blackHole.setLifeLeft(blackHole.getLifeLeft() - delta);
            if (blackHole.getLifeLeft() <= 0f) {
                blackHoles.removeValue(blackHole, true);
            }
        }
        blackHoles.end();
    }

    private void handleAlphaBlackHole(BlackHole blackHole) {

    }

    private void handleRepulsionBlackHole(BlackHole blackHole) {

    }

    public void junkAbsorbed(BlackHole blackHole) {
        blackHole.addRadius(BLACK_HOLE_RADIUS_INCREMENT);
        blackHole.setLifeLeft(Math.min(blackHole.getLifeLeft() + 1f, BLACK_HOLE_INITIAL_LIFE));
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}