package com.epicness.blackholes;

import com.badlogic.gdx.Game;
import com.epicness.blackholes.menu.MenuInitializer;
import com.epicness.fundamentals.SharedResources;

public class BlackHolesGame extends Game {

    @Override
    public void create() {
        new MenuInitializer().initialize(new SharedResources(this));
    }
}
