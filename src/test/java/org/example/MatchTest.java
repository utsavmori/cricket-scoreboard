package org.example;

import org.example.exception.ScoreboardException;
import org.junit.Test;

public class MatchTest {

    @Test(expected = Exception.class)
    public void test_match_is_not_allowed_morethan_two_teams() throws ScoreboardException {
        Match match = new Match(2);

        match.setTeam(new Team(2), 3);

    }

}
