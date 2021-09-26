package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.math.Vector2;
import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Ship;

import static com.epicness.blackholes.game.GameConstants.SHIP_ACCELERATION_SPEED;
import static com.epicness.blackholes.game.GameConstants.SHIP_SHOOT_COOLDOWN;
import static com.epicness.blackholes.game.stuff.blackholes.BlackHoleType.ALPHA;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

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

        checkBounds(ship1);
        checkBounds(ship2);
    }

    private void applyAcceleration(Ship ship) {
        if (!ship.isAccelerating()) {
            return;
        }
        //first calculate a forward vector for the ship
        Vector2 forward = new Vector2(0, -1);
        forward.rotateDeg(ship.getRotation());
        forward.scl(SHIP_ACCELERATION_SPEED);
        //Now this vector, scaled by SHIP_SPEED should be added to the ships acceleration vector
        ship.addAcceleration(forward);
    }

    private void checkBounds(Ship ship) {
        Vector2 position = ship.getPosition();
        if (position.x < 0f) {
            ship.setPosition(new Vector2(CAMERA_WIDTH, position.y));
        } else if (position.x > CAMERA_WIDTH) {
            ship.setPosition(new Vector2(0f, position.y));
        }
        if (position.y < 0f) {
            ship.setPosition(new Vector2(position.x, CAMERA_HEIGHT));
        } else if (position.y > CAMERA_HEIGHT) {
            ship.setPosition(new Vector2(position.x, 0f));
        }
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