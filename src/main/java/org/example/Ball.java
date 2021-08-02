package org.example;

import org.example.exception.ScoreboardException;

public class Ball {
    private boolean isExtra;
    private int runs;
    private boolean isWicket;

    public Ball(String ball) throws ScoreboardException {
        try {
            this.runs = Integer.parseInt(ball);
            isExtra = false;
            isWicket = false;
        } catch (NumberFormatException ex) {
            detectBall(ball);

        }
    }

    private void detectBall(String ballType) throws ScoreboardException {
        switch (ballType) {
            case "W":
                isExtra = false;
                runs = 0;
                isWicket = true;
                break;
            case "Wd":
            case "N":
                isExtra = true;
                isWicket = false;
                runs = 1;
                break;
            default:
                throw new ScoreboardException("No Ball type found");
        }
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public boolean isWicket() {
        return isWicket;
    }

    public void setWicket(boolean wicket) {
        isWicket = wicket;
    }
}
