package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Stuff;

import java.util.concurrent.Delayed;

public class GameStuff extends Stuff {

    public Ship playerShip, enemyShip;
    public DelayedRemovalArray<SpaceObject> junk;

    @Override
    public void initializeStuff() {

        playerShip = new Ship();
        playerShip.setAcceleration(new Vector2(10, 10));
        playerShip.setPosition(new Vector2(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f));
        playerShip.setAngularVelocity(15f);
    }
}