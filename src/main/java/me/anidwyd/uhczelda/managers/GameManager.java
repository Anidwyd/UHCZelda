package me.anidwyd.uhczelda.managers;

import lombok.Getter;
import me.anidwyd.uhczelda.UhcZeldaPlugin;
import me.anidwyd.uhczelda.game.GameState;
import me.anidwyd.uhczelda.game.WaitingState;
import me.anidwyd.uhczelda.utils.Colorize;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

@Getter
public class GameManager {

    @Getter
    private static GameManager instance;

    private final UhcZeldaPlugin plugin;
    private GameState currentState;

    // Managers
    private final PlayerManager playerManager;

    public GameManager(UhcZeldaPlugin plugin) {
        instance = this;
        this.plugin = plugin;
        setGameState(new WaitingState());

        this.playerManager = new PlayerManager();
    }

    public boolean isInState(Class<? extends GameState> stateClass) {
        return currentState.getClass().equals(stateClass);
    }

    public void nextState() {
        setGameState(currentState.getNextState());
    }

    public void setGameState(GameState gameState) {
        if (currentState != null) {
            currentState.onDisable();
            HandlerList.unregisterAll(currentState);
        }

        currentState = gameState;
        plugin.getServer().getPluginManager().registerEvents(currentState, plugin);
        currentState.onEnable();
    }

    public void broadcastMessage(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(Colorize.color(message));
        }
    }

    public void broadcastTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendTitle(Colorize.color(title), Colorize.color(subtitle), fadeIn, stay, fadeOut);
        }
    }

    public void broadcastSound(Sound sound) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.playSound(player.getLocation(), sound, 1, 1);
        }
    }

    public void cleanup() {

    }
}
