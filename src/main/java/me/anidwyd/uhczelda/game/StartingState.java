package me.anidwyd.uhczelda.game;

import me.anidwyd.uhczelda.managers.GameManager;
import me.anidwyd.uhczelda.tasks.GameStartingTask;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class StartingState extends GameState {

    @Override
    public void onEnable() {
        GameManager gameManager = GameManager.getInstance();
        GameStartingTask gameStartingTask = new GameStartingTask(gameManager, () -> {
            gameManager.setGameState(new ActiveState());
            gameManager.broadcastSound(Sound.ENTITY_WITHER_SPAWN);
        }, 10);
        gameStartingTask.runTaskTimer(gameManager.getPlugin(),0,20);
    }

    @Override
    public GameState getNextState() {
        return new ActiveState();
    }

    @EventHandler
    private void onDamage(EntityDamageEvent event) {
        event.setCancelled(event.getEntity() instanceof Player);
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    private void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    private void onHunger(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
}
