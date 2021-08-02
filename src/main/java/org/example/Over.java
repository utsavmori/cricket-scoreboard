package org.example;

import org.example.exception.ScoreboardException;

import java.util.LinkedList;
import java.util.List;

public class Over {
    private List<Ball> balls;

    public Over() {
        balls = new LinkedList<>();
    }

    public void addBall(Ball ball) throws ScoreboardException {
        if (validBall(ball)) {
            balls.add(ball);
        } else {
            throw new ScoreboardException("Not a valid ball for the over. Over is done");
        }

    }

    private boolean validBall(Ball ball) {
        return balls.stream().filter((x) -> !x.isExtra()).count() < 6;
    }

    public boolean isOverDone() {
        return balls.stream().filter((x) -> !x.isExtra()).count() == 6;
    }

    public int totalBalls() {
        return balls.size();
    }

    public int totalSuccessfulBalls() {
        return (int) balls.stream().filter((x) -> !x.isExtra()).count();
    }
}
