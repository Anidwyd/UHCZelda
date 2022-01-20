package me.anidwyd.uhczelda.game;

import lombok.Getter;
import me.anidwyd.uhczelda.players.PlayerManager;
import me.anidwyd.uhczelda.players.TeamManager;

@Getter
public class GameManager {

    private static GameManager gameManager;

    // Managers
    private PlayerManager playerManager;
    private TeamManager teamManager;

    // Handlers

    private GameState gameState;

    public GameManager() {
        gameManager = this;
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private void registerListeners() {

    }
}
