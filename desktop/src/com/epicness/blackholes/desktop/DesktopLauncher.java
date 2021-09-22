package com.epicness.blackholes.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.epicness.blackholes.BlackHolesGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1200;
        config.height = 800;
        config.forceExit = false;
        config.resizable = false;
        new LwjglApplication(new BlackHolesGame(), config);
    }
}
