package com.epicness.blackholes.game.logic;

import com.epicness.blackholes.game.stuff.GameStuff;

public class DebriSpawner {

    private GameStuff stuff;
    // Logic
    private float time;

    public void update(float delta) {
        time += delta;

    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}