package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;

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

        player1Ship = new Ship(assets);
        player1Ship.setPosition(new Vector2(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f));

        player2Ship = new Ship(assets);
        player2Ship.setPosition(new Vector2(300, 300));

        junks = new DelayedRemovalArray<>();

        blackHoles = new DelayedRemovalArray<>();

        damageOverlay = new Sprited(sharedAssets.getPixel());
        damageOverlay.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        damageOverlay.setColor(Color.CLEAR);
    }
}