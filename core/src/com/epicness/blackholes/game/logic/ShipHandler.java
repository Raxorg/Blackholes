package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Ship;

import static com.epicness.blackholes.game.GameConstants.SHIP_ACCELERATION_SPEED;
import static com.epicness.blackholes.game.GameConstants.SHIP_SHOOT_COOLDOWN;
import static com.epicness.blackholes.game.stuff.blackholes.BlackHoleType.ALPHA;

/**
 * This class handles the Ships movement logic
 */
public class ShipHandler {

    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void update(float delta) {
        Ship ship1 = stuff.player1Ship;
        Ship ship2 = stuff.player2Ship;

        ship1.setCooldown(ship1.getCooldown() - delta);
        ship2.setCooldown(ship2.getCooldown() - delta);

        applyAcceleration(ship1);
        applyAcceleration(ship2);
    }

    private void applyAcceleration(Ship ship) {
        if (!ship.isAccelerating()) {
            return;
        }
        //first calculate a forward vector for the ship
        Vector2 forward = new Vector2(0, -1);
        forward = forward.rotateDeg(ship.getRotation());
        forward = forward.scl(SHIP_ACCELERATION_SPEED);
        //Now this vector, scaled by SHIP_SPEED should be added to the ships acceleration vector
        ship.addAcceleration(forward);
    }

    public void shoot(Ship ship) {
        if (ship.getCooldown() > 0f) {
            return;
        }
        Vector2 forward = new Vector2(0, -1);
        forward = forward.rotateDeg(ship.getRotation());
        logic.getBlackHoleHandler().spawnBlackHole(ship, forward, ALPHA);
        ship.setCooldown(SHIP_SHOOT_COOLDOWN);
        assets.getShoot().play();
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}