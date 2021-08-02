package org.example;

import org.example.exception.ScoreboardException;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final List<Player> players;
    private final int numberOfPlayers;

    public Team(int numberOfPlayers) throws ScoreboardException {
        if (numberOfPlayers < 2) {
            throw new ScoreboardException(numberOfPlayers + " person team feasible in Cricket match");
        }
        this.numberOfPlayers = numberOfPlayers;
        players = new ArrayList<>(numberOfPlayers);
    }

    public Team addPlayer(Player player) throws ScoreboardException {
        if (players.size() == numberOfPlayers) {
            throw new ScoreboardException("Player should be limited to: " + numberOfPlayers);
        } else {
            players.add(player);
        }
        return this;
    }

    public Player getPlayerAtSpecificOrder(int order) throws ScoreboardException {
        return players.stream().filter((x) -> x.getOrder() == order).findFirst().orElseThrow(() -> new ScoreboardException("No Player found at specific order "));
    }

    public List<Player> getPlayers() {
        return players;
    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }


}
