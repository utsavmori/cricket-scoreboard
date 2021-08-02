package org.example;

import org.example.exception.ScoreboardException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InningTest {
    @Test(expected = ScoreboardException.class)
    public void test_start_inning_is_allowd() throws ScoreboardException {
        Inning inning = new Inning(2);
        inning.startInning();
    }


    @Test
    public void test_partial_overs_should_show_accurate() throws ScoreboardException {
        Inning inning = new Inning(2);
        Team teamTest = new Team(2);
        teamTest = teamTest.addPlayer(new Player().name("Utsav").order(1));
        teamTest = teamTest.addPlayer(new Player().name("Mori").order(2));
        inning.setBattingTeam(teamTest);
        inning.startInning();
        inning.throwBall(new Ball("1"));
        assertEquals("0.1", inning.getBallsInLastOver());
    }

    @Test
    public void test_over_done_flag_is_set_when_six_successful_balls_thrown() throws ScoreboardException {
        Inning inning = new Inning(2);
        Team teamTest = new Team(2);
        teamTest = teamTest.addPlayer(new Player().name("Utsav").order(1));
        teamTest = teamTest.addPlayer(new Player().name("Mori").order(2));
        inning.setBattingTeam(teamTest);
        inning.startInning();
        inning.throwBall(new Ball("1"));
        inning.throwBall(new Ball("1"));
        inning.throwBall(new Ball("1"));
        inning.throwBall(new Ball("1"));
        inning.throwBall(new Ball("1"));
        inning.throwBall(new Ball("1"));
        assertTrue(inning.isCurrentOverDone());
    }

}
