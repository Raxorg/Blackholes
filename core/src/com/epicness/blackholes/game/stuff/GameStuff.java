package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.utils.Random;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameStuff extends Stuff {

    public DualSprited background;
    public Ship player1Ship, player2Ship;
    public DelayedRemovalArray<Junk> junks;
    public DelayedRemovalArray<BlackHole> blackHoles;
    public Sprited damageOverlay;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        background = new DualSprited(assets.getBackground(), assets.getInvertedBackground());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        Color randomColor = Random.randomColor();
        player1Ship = new Ship(assets, randomColor);
        player1Ship.setPosition(new Vector2(100, CAMERA_HEIGHT - 100f));

        player2Ship = new Ship(assets, Random.exclusiveRandomColor(randomColor));
        player2Ship.setPosition(new Vector2(CAMERA_WIDTH - 100, CAMERA_HEIGHT - 100f));

        junks = new DelayedRemovalArray<>();

        blackHoles = new DelayedRemovalArray<>();

        damageOverlay = new Sprited(sharedAssets.getPixel());
        damageOverlay.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        damageOverlay.setColor(Color.CLEAR);
    }
}