package com.epicness.blackholes.game.logic;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final GameInputHandler gameInputHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        gameInputHandler = new GameInputHandler();
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        gameInputHandler.setStuff(stuff);
    }
}