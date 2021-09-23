package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.Ship;
import com.epicness.blackholes.game.stuff.ShipComponent;
import com.epicness.fundamentals.stuff.Sprited;

import static com.epicness.blackholes.game.GameConstants.DAMAGE_FADE_SPEED;

public class DamageHandler {

    private GameStuff stuff;
    // Logic
    private float progress;

    public void takeDamage(Ship ship) {
        for (int i = 0; i < ship.getComponents().size(); i++) {
            ShipComponent component = ship.getComponents().get(i);
            component.setHealth(component.getHealth() - 10);
            // TODO: 23/9/2021 Check component health to detach it
        }
        progress = 1f;
    }

    public void update(float delta) {
        Sprited damageOverlay = stuff.damageOverlay;
        progress = Math.max(progress - delta * DAMAGE_FADE_SPEED, 0f);
        damageOverlay.setColor(Color.CLEAR.cpy().lerp(Color.RED, progress));
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}