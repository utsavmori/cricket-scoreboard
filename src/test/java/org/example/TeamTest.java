package org.example;

import org.example.exception.ScoreboardException;
import org.junit.Test;

public class TeamTest {
    @Test(expected = ScoreboardException.class)
    public void test_team_should_allow_specified_number_of_players() throws ScoreboardException {
        Team team = new Team(2);
        team.addPlayer(new Player());
        team.addPlayer(new Player());
        team.addPlayer(new Player());
    }
}
