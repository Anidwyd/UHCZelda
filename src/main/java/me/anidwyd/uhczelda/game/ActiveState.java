package me.anidwyd.uhczelda.game;

import lombok.RequiredArgsConstructor;
import me.anidwyd.uhczelda.managers.GameManager;

@RequiredArgsConstructor
public class ActiveState extends GameState {

    @Override
    public void onEnable() {
        GameManager gameManager = GameManager.getInstance();
        gameManager.broadcastMessage("&6The game has started!");
        gameManager.getPlayerManager().giveKits();
    }

    @Override
    public GameState getNextState() {
        return new WaitingState();
    }
}
