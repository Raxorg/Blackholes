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

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        blackHoleHandler = new BlackHoleHandler();
        distortionHandler = new DistortionHandler();
        gameInputHandler = new GameInputHandler();
        spaceObjectHandler = new SpaceObjectHandler();
        weaponsHandler = new WeaponsHandler();

        spaceObjectHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {
        blackHoleHandler.update(delta);
        distortionHandler.update(delta);
        spaceObjectHandler.MoveAllObjects();
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
}