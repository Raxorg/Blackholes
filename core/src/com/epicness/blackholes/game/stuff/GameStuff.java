package com.epicness.blackholes.game.stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.blackholes.BlackHole;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Stuff;

import static com.epicness.blackholes.game.stuff.blackholes.BlackHoleType.ALPHA;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameStuff extends Stuff {

    private DualSprited background;
    public Ship playerShip, enemyShip;
    private DelayedRemovalArray<Junk> junks;
    private DelayedRemovalArray<BlackHole> blackHoles;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        background = new DualSprited(assets.getBackground(), assets.getInvertedBackground());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        playerShip = new Ship(assets);
        playerShip.setPosition(new Vector2(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f));

        enemyShip = new Ship(assets);
        enemyShip.setPosition(new Vector2(300, 300));

        junks = new DelayedRemovalArray<>();

        blackHoles = new DelayedRemovalArray<>();
        BlackHole blackHole = new BlackHole(
                assets.getBlackHole(), assets.getBlackHoleGlow(),
                assets.getInvertedBlackHole(), assets.getInvertedBlackHoleGlow(),
                ALPHA);
        blackHole.setPosition(new Vector2(200f, 200f));
        blackHole.setColor(Color.CHARTREUSE);
        blackHoles.add(blackHole);
    }

    public DualSprited getBackground() {
        return background;
    }

    public DelayedRemovalArray<Junk> getJunks() {
        return junks;
    }

    public DelayedRemovalArray<BlackHole> getBlackHoles() {
        return blackHoles;
    }
}