package me.anidwyd.uhczelda.utils;

import org.bukkit.ChatColor;

public class Colorize {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String stripColor(String string) {
        return ChatColor.stripColor(string);
    }
}
