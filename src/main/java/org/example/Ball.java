package org.example;

public class Ball {
    boolean isExtra;
    int runs;
    boolean isWicket;

    public Ball(String ball) {
        try {
            this.runs = Integer.parseInt(ball);
            isExtra = false;
            isWicket=false;
        } catch (NumberFormatException ex) {
            detectBall(ball);

        }
    }

    private void detectBall(String ballType) {
        switch (ballType) {
            case "W":
                isExtra = false;
                runs = 0;
                isWicket=true;
                break;
            case "Wd":
            case "N":
                isExtra = true;
                isWicket=false;
                runs = 1;
                break;
        }
    }

}
