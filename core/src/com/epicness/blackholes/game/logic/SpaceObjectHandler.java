package com.epicness.blackholes.game.logic;

import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.SpaceObject;
import com.epicness.fundamentals.logic.Logic;

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
    public void moveAllObjects(float delta) {
        moveObject(stuff.player1Ship, delta);
        moveObject(stuff.player2Ship, delta);
        for (int i = 0; i < stuff.junks.size; i++) {
            moveObject(stuff.junks.get(i), delta);
        }
        for (int i = 0; i < stuff.blackHoles.size; i++) {
            moveObject(stuff.blackHoles.get(i), delta);
        }
    }

    private void moveObject(SpaceObject o, float delta) {
        // Update velocity using acceleration
        o.setVelocity(o.getVelocity().add(o.getAcceleration().cpy().scl(delta)));
        // Now update position using the new velocity
        o.setPosition(o.getPosition().add(o.getVelocity().cpy().scl(delta)));
        // Handle any angular velocity
        o.setRotation(o.getRotation() + (o.getAngularVelocity() * delta));
        // Reset the objects acceleration
        // o.setAcceleration(new Vector2(0, 0)); --> maybe this should be done individually, the only objects that use this are the ships and this disturbs the movement code!
        o.setRotation(o.getRotation() + (o.getAngularVelocity() * delta));
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }
}