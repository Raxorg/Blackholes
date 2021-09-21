package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;
import com.epicness.fundamentals.stuff.Stuff;

import static com.epicness.blackholes.game.stuff.blackholes.BlackHoleType.ALPHA;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameStuff extends Stuff {

    public Ship playerShip, enemyShip;
    public DelayedRemovalArray<SpaceObject> junk;
    private DelayedRemovalArray<BlackHole> blackHoles;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        playerShip = new Ship();
        playerShip.setAcceleration(new Vector2(10, 10));
        playerShip.setPosition(new Vector2(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f));
        playerShip.setAngularVelocity(15f);

        blackHoles = new DelayedRemovalArray<>();
        BlackHole blackHole = new BlackHole(
                assets.getBlackHole(), assets.getBlackHoleGlow(),
                assets.getInvertedBlackHole(), assets.getInvertedBlackHoleGlow(),
                ALPHA);
        blackHole.setPosition(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f);
        blackHole.setColor(Color.CHARTREUSE);
        blackHoles.add(blackHole);
    }

    public DelayedRemovalArray<BlackHole> getBlackHoles() {
        return blackHoles;
    }
}