package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.SpaceObject;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.stuff.Stuff;

/**
 * This class will handle all the SpaceObjects: Junk, Ships, Broken Ship Pieces, etc...
 * Mainly this class handles the movement of these objects through space
 */
public class SpaceObjectHandler {

    protected GameStuff stuff;
    protected Logic logic;

    /**
     * This function moves the ships and the junk (physics only)
     */
    public void MoveAllObjects() {
        MoveObject(stuff.playerShip);
    }

    private void MoveObject(SpaceObject o) {
        //Update velocity using acceleration
        o.getVelocity().add(o.getAcceleration().cpy().scl(Gdx.graphics.getDeltaTime()));
        //Now update position using the new velocity
        o.getPosition().add(o.getVelocity().cpy().scl(Gdx.graphics.getDeltaTime()));
        //Handle any angular velocity
        o.setRotation(o.getRotation() + (o.getAngularVelocity() * Gdx.graphics.getDeltaTime()));
        //Reset the objects acceleration
        o.setAcceleration(new Vector2(0, 0));
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }
}
