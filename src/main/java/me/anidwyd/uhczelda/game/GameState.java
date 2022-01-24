package me.anidwyd.uhczelda.game;

import org.bukkit.event.Listener;

public abstract class GameState implements Listener {

    public void onEnable() {}

    public void onDisable() {}

    public abstract GameState getNextState();
}
