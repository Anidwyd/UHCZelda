package me.anidwyd.uhczelda.listeners;

import me.anidwyd.uhczelda.utils.Colorize;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        int currentplayers = Bukkit.getOnlinePlayers().size();
        int requiredplayers = 8;
        event.setJoinMessage(Colorize.color("&7" + player.getDisplayName() + " &ehas joined (" +
                "&b" + currentplayers + "&e/&b" + requiredplayers + "&e)!"));
    }

    @EventHandler void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        int currentplayers = Bukkit.getOnlinePlayers().size();
        int requiredplayers = 8;
        event.setQuitMessage(Colorize.color("&7" + player.getDisplayName() + " &chas left (" +
                "&b" + currentplayers + "&c/&b" + requiredplayers + "&c)!"));
    }

}
