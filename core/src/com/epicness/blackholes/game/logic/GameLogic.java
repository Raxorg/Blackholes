package com.epicness.blackholes.game.logic;

import com.epicness.blackholes.game.stuff.GameStuff;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final GameInputHandler gameInputHandler;
    private final SpaceObjectHandler spaceObjectHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        gameInputHandler = new GameInputHandler();
        spaceObjectHandler = new SpaceObjectHandler();
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
        spaceObjectHandler.setLogic(this);
    }

    @Override
    public void update(float delta) {
        spaceObjectHandler.MoveAllObjects();
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        gameInputHandler.setStuff(stuff);
        spaceObjectHandler.setStuff((GameStuff)stuff);
    }
}