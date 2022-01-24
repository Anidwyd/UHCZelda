package me.anidwyd.uhczelda.commands;

import me.anidwyd.uhczelda.utils.Colorize;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ZeldaBaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Colorize.color("&c/zelda <reload|update|version>"));
        }
        return false;
    }
}
