package me.anidwyd.uhczelda.managers;

import org.bukkit.ChatColor;

public class TeamManager {

    private static final String[] TEAM_COLORS = new String[]{
        ChatColor.RED.toString(),
        ChatColor.BLUE.toString(),
        ChatColor.DARK_GREEN.toString(),
        ChatColor.DARK_AQUA.toString(),
        ChatColor.DARK_PURPLE.toString(),
        ChatColor.YELLOW.toString(),
        ChatColor.GOLD.toString(),
        ChatColor.GREEN.toString(),
        ChatColor.AQUA.toString(),
        ChatColor.LIGHT_PURPLE.toString()
    };

    private static final String[] TEAM_COLOR_VARIATIONS = new String[]{
        "",
        ChatColor.BOLD.toString(),
        ChatColor.ITALIC.toString(),
        ChatColor.UNDERLINE.toString(),
        ChatColor.BOLD.toString() + ChatColor.ITALIC,
        ChatColor.BOLD.toString() + ChatColor.UNDERLINE,
        ChatColor.ITALIC.toString() + ChatColor.UNDERLINE,
        ChatColor.ITALIC.toString() + ChatColor.UNDERLINE + ChatColor.BOLD
    };
}
