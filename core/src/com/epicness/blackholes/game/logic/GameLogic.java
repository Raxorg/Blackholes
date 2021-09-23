package com.epicness.blackholes.game.logic;

import com.epicness.blackholes.game.GameAssets;
import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final BlackHoleHandler blackHoleHandler;
    private final CollisionHandler collisionHandler;
    private final DamageHandler damageHandler;
    private final DistortionHandler distortionHandler;
    private final GameInputHandler gameInputHandler;
    private final JunkSpawner junkSpawner;
    private final SpaceObjectHandler spaceObjectHandler;
    private final WeaponsHandler weaponsHandler;
    private final ShipHandler shipHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        blackHoleHandler = new BlackHoleHandler();
        collisionHandler = new CollisionHandler();
        damageHandler = new DamageHandler();
        distortionHandler = new DistortionHandler();
        gameInputHandler = new GameInputHandler();
        junkSpawner = new JunkSpawner();
        spaceObjectHandler = new SpaceObjectHandler();
        weaponsHandler = new WeaponsHandler();
        shipHandler = new ShipHandler();

        collisionHandler.setLogic(this);
        gameInputHandler.setLogic(this);
        shipHandler.setLogic(this);
        spaceObjectHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
        junkSpawner.spawnInitialJunk();
    }

    @Override
    public void update(float delta) {
        blackHoleHandler.update(delta);
        collisionHandler.update();
        damageHandler.update(delta);
        distortionHandler.update(delta);
        junkSpawner.update(delta);
        spaceObjectHandler.moveAllObjects(delta);
        shipHandler.update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
        blackHoleHandler.setAssets(gameAssets);
        junkSpawner.setAssets(gameAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        blackHoleHandler.setStuff(gameStuff);
        collisionHandler.setStuff(gameStuff);
        damageHandler.setStuff(gameStuff);
        distortionHandler.setStuff(gameStuff);
        gameInputHandler.setStuff(gameStuff);
        junkSpawner.setStuff(gameStuff);
        spaceObjectHandler.setStuff(gameStuff);
        weaponsHandler.setStuff(gameStuff);
        shipHandler.setStuff(gameStuff);
    }

    public BlackHoleHandler getBlackHoleHandler() {
        return blackHoleHandler;
    }

    public DamageHandler getDamageHandler() {
        return damageHandler;
    }

    public WeaponsHandler getWeaponsHandler() {
        return weaponsHandler;
    }

    public ShipHandler getShipHandler() {
        return shipHandler;
    }
}