package org.example;

import org.example.exception.ScoreboardException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {
    @Test
    public void test_ball_is_setting_proper_wicket_flag() throws ScoreboardException {
        Ball ball = new Ball("W");
        assertTrue(ball.isWicket());
        assertFalse(ball.isExtra());
    }

    @Test
    public void test_ball_is_setting_proper_extra_flag() throws ScoreboardException {
        Ball ball = new Ball("Wd");
        assertFalse(ball.isWicket());
        assertTrue(ball.isExtra());
        assertEquals(1, ball.getRuns());
    }

    @Test(expected = ScoreboardException.class)
    public void test_ball_throws_exception_for_unexpected() throws ScoreboardException {
        Ball ball = new Ball("U");

    }
}
