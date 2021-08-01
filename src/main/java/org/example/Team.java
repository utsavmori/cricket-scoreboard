package org.example;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players;
    private int numberOfPlayers;
    public Team(int numberOfPlayers){
        this.numberOfPlayers=numberOfPlayers;
        players=new ArrayList<>(numberOfPlayers);
    }

    public Team addPlayer(Player player) throws Exception {
        if(players.size()==numberOfPlayers){
            throw new Exception("Player should be limited to: "+numberOfPlayers);
        }else{
            players.add(player);
        }
        return this;
    }

    public Player getPlayerAtSpecificOrder(int order) throws Exception {
      return  players.stream().filter((x)->x.getOrder()==order).findFirst().orElseThrow(()->new Exception("No Player found at specific order "));
    }

    public List<Player> getPlayers() {
        return players;
    }



    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }


}
