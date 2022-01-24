package me.anidwyd.uhczelda.players;

import lombok.Getter;
import lombok.Setter;
import me.anidwyd.uhczelda.exceptions.ZeldaPlayerNotOnlineException;
import me.anidwyd.uhczelda.managers.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
@Setter
public class ZeldaPlayer {
    private final UUID uuid;
    private final String name;

    private ZeldaTeam team;
    private PlayerState state;
    private int kills;

    public ZeldaPlayer(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        state = PlayerState.WAITING;
        team = new ZeldaTeam(this);
        kills = 0;
    }

    public Player getPlayer() throws ZeldaPlayerNotOnlineException {
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) return player;
        throw new ZeldaPlayerNotOnlineException(name);
    }

    public Boolean isOnline() {
        Player player = Bukkit.getPlayer(uuid);
        return player != null;
    }

    public boolean isWaiting(){
        return state == PlayerState.WAITING;
    }

    public boolean isPlaying(){
        return state == PlayerState.PLAYING;
    }

    public boolean isDeath(){
        return state == PlayerState.DEAD;
    }
}
