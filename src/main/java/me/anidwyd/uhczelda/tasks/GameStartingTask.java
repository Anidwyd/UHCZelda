package me.anidwyd.uhczelda.tasks;

import lombok.AllArgsConstructor;
import me.anidwyd.uhczelda.managers.GameManager;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

@AllArgsConstructor
public class GameStartingTask extends BukkitRunnable {

    private final GameManager gameManager;
    private final Runnable onStart;
    private int timeUntilStart;

    @Override
    public void run() {
        if (timeUntilStart <= 0) {
            cancel();
            onStart.run();
            return;
        }

        if (timeUntilStart % 10 == 0) {
            gameManager.broadcastMessage("&eStarting in &6" + timeUntilStart + "...");
            gameManager.broadcastTitle("&a" + timeUntilStart, "", 0, 20, 0);
            gameManager.broadcastSound(Sound.BLOCK_DISPENSER_DISPENSE);
        }
        if (timeUntilStart <= 5) {
            gameManager.broadcastMessage("&eStarting in &c" + timeUntilStart + "...");
            gameManager.broadcastTitle("&c" + timeUntilStart, "", 0, 20, 0);
            gameManager.broadcastSound(Sound.BLOCK_DISPENSER_DISPENSE);
        }

        timeUntilStart--;
    }
}
