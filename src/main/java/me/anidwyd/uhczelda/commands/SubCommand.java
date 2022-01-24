package me.anidwyd.uhczelda.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface SubCommand<T extends CommandSender> {

    void execute(Player player, String[] args);

}
