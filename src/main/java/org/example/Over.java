package org.example;

import java.util.LinkedList;
import java.util.List;

public class Over {
    List<Ball> balls;

    public Over() {
        balls = new LinkedList<>();
    }

    public void addBall(Ball ball) {
        if(validBall(ball)){
            balls.add(ball);
        }

    }

    private boolean validBall(Ball ball) {
        return balls.stream().filter((x)->!x.isExtra).count()<6;
    }

    public boolean isOverDone(){
        return balls.stream().filter((x)->!x.isExtra).count()==6;
    }
    public int totalBalls(){
        return balls.size();
    }
    public int totalSuccessfulBalls(){
        return (int)balls.stream().filter((x)->!x.isExtra).count();
    }
}
