package org.example;

import org.example.exception.ScoreboardException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OverTest {

    @Test(expected = ScoreboardException.class)
    public void test_over_should_not_allow_morethan_six_balls() throws ScoreboardException {
        Over over = new Over();
        over.addBall(new Ball("1"));
        over.addBall(new Ball("2"));
        over.addBall(new Ball("2"));
        over.addBall(new Ball("1"));
        over.addBall(new Ball("4"));
        over.addBall(new Ball("6"));
        over.addBall(new Ball("1"));
    }

    @Test()
    public void test_over_should_allow_morethan_six_balls_for_extraballs() throws ScoreboardException {
        Over over = new Over();
        over.addBall(new Ball("1"));
        over.addBall(new Ball("2"));
        over.addBall(new Ball("2"));
        over.addBall(new Ball("Wd"));
        over.addBall(new Ball("4"));
        over.addBall(new Ball("6"));
        over.addBall(new Ball("1"));
        assertEquals(6, over.totalSuccessfulBalls());

    }

    @Test
    public void test_over_done_flag_is_set_on_six_successful_balls() throws ScoreboardException {
        Over over = new Over();
        over.addBall(new Ball("1"));
        over.addBall(new Ball("2"));
        over.addBall(new Ball("2"));
        over.addBall(new Ball("Wd"));
        over.addBall(new Ball("4"));
        over.addBall(new Ball("6"));
        over.addBall(new Ball("1"));
        assertTrue(over.isOverDone());
    }

    @Test
    public void test_over_should_count_all_number_of_balls() throws ScoreboardException {
        Over over = new Over();
        over.addBall(new Ball("1"));
        over.addBall(new Ball("2"));
        over.addBall(new Ball("2"));
        over.addBall(new Ball("Wd"));
        over.addBall(new Ball("4"));
        over.addBall(new Ball("6"));
        over.addBall(new Ball("1"));
        assertEquals(7, over.totalBalls());
    }
}
