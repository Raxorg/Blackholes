package com.epicness.blackholes.game.logic;

import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final BlackHoleHandler blackHoleHandler;
    private final DistortionHandler distortionHandler;
    private final GameInputHandler gameInputHandler;
    private final SpaceObjectHandler spaceObjectHandler;
    private final WeaponsHandler weaponsHandler;
    private final ShipHandler shipHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        blackHoleHandler = new BlackHoleHandler();
        distortionHandler = new DistortionHandler();
        gameInputHandler = new GameInputHandler();
        spaceObjectHandler = new SpaceObjectHandler();
        weaponsHandler = new WeaponsHandler();
        shipHandler = new ShipHandler();

        spaceObjectHandler.setLogic(this);
        gameInputHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {
        blackHoleHandler.update(delta);
        distortionHandler.update(delta);
        spaceObjectHandler.moveAllObjects(delta);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        blackHoleHandler.setStuff(gameStuff);
        distortionHandler.setStuff(gameStuff);
        gameInputHandler.setStuff(gameStuff);
        spaceObjectHandler.setStuff(gameStuff);
        weaponsHandler.setStuff(gameStuff);
    }

    public WeaponsHandler getWeaponsHandler() {
        return weaponsHandler;
    }

    public ShipHandler getShipHandler() {
        return shipHandler;
    }
}