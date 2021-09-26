package com.epicness.blackholes.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.blackholes.game.stuff.ShipComponent;
import com.epicness.fundamentals.stuff.Sprited;

import static com.epicness.blackholes.game.GameConstants.DAMAGE_FADE_SPEED;

public class DamageHandler {

    private GameStuff stuff;
    // Logic
    private float progress;

    public void takeDamage(ShipComponent component) {
        component.setHealth(component.getHealth() - 10);
        switch (component.getHealth()) {
            case 0:
                component.setColor(Color.CLEAR);
                break;
            case 10:
                component.setColor(Color.RED);
                break;
            case 20:
                component.setColor(Color.ORANGE);
                break;
            case 30:
                component.setColor(Color.YELLOW);
                break;
            case 40:
                component.setColor(Color.GREEN);
                break;
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