package com.epicness.blackholes;

import com.badlogic.gdx.Game;
import com.epicness.blackholes.game.GameInitializer;
import com.epicness.fundamentals.SharedResources;

public class BlackHolesGame extends Game {

    @Override
    public void create() {
        new GameInitializer().initialize(new SharedResources(this));
    }
}
