package me.anidwyd.uhczelda.commands;

import me.anidwyd.uhczelda.game.StartingState;
import me.anidwyd.uhczelda.managers.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        GameManager.getInstance().setGameState(new StartingState());
        return false;
    }
}
