package me.anidwyd.uhczelda.players;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ZeldaTeam {

    private final List<ZeldaPlayer> members;
    private final int teamNumber;
    private String teamName;
    private String prefix;

    public ZeldaTeam(ZeldaPlayer player) {
        members = new ArrayList<>();
        members.add(player);
        teamNumber = 0;
        teamName = "Team " + teamNumber;
        prefix = "";
    }
}
