package org.example;

import org.example.exception.ScoreboardException;

public class Inning {
    private Over[] overs;
    private int currentOver;
    private Team battingTeam;
    private int teamScore;
    private int wickets;
    private Player strike;
    private Player nonStrike;
    boolean allOut;

    public Inning(int numberOfOvers) {
        overs = new Over[numberOfOvers];
        for (int i = 0; i < numberOfOvers; i++)
            overs[i] = new Over();
        currentOver = -1;
        teamScore = 0;
        wickets = 0;
        allOut = false;
    }


    public void startInning() throws ScoreboardException {
        currentOver = 0;
        strike = battingTeam.getPlayerAtSpecificOrder(1);
        nonStrike = battingTeam.getPlayerAtSpecificOrder(2);
    }

    public void throwBall(Ball ball) throws ScoreboardException {
        overs[currentOver].addBall(ball);
        if (ball.isWicket()) {
            wickets++;
            strike.setBalls(strike.getBalls() + 1);
            if (battingTeam.getNumberOfPlayers() - 1 != wickets) {
                strike = battingTeam.getPlayerAtSpecificOrder(wickets + 2);
            } else {
                strike = null;
                allOut = true;
            }
        } else {
            calculateRunsForTeam(ball);
            calculateRunsForPlayer(ball);
            updateStrike(ball);
        }
    }

    private void updateStrike(Ball ball) {
        if (!ball.isExtra()) {
            if (ball.getRuns() % 2 != 0) {
                changeStrike();
            }
        }
        if (overs[currentOver].isOverDone()) {
            changeStrike();
        }

    }

    private void changeStrike() {
        Player temp = strike;
        strike = nonStrike;
        nonStrike = temp;
    }

    private void calculateRunsForPlayer(Ball ball) {
        if (!ball.isExtra()) {
            strike.setScore(strike.getScore() + ball.getRuns());
            if (ball.getRuns() == 4) {
                strike.setFours(strike.getFours() + 1);
            }
            if (ball.getRuns() == 6) {
                strike.setSixes(strike.getSixes() + 1);
            }
            strike.setBalls(strike.getBalls() + 1);
        }

    }

    private void calculateRunsForTeam(Ball ball) {
        teamScore += ball.getRuns();
    }

    public Team getTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team team) {
        battingTeam = team;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public int getWickets() {
        return wickets;
    }

    //utility for main class
    public boolean isCurrentOverDone() {
        if (overs[currentOver].isOverDone()) {
            currentOver++;
            return true;
        }
        return false;
    }

    //utility for main class
    public boolean isPlayerPlaying(Player player) {
        if (player != null && player.equals(strike) || player.equals(nonStrike)) {
            return true;
        }
        return false;
    }

    public boolean getAllout() {
        return allOut;
    }

    //utility for main class
    public String getBallsInLastOver() {
        if ((overs.length == currentOver && overs[currentOver - 1].isOverDone()) || overs[currentOver].totalBalls() == 0) {
            return String.valueOf(currentOver);
        } else {
            return String.valueOf(Double.parseDouble(currentOver + "." + overs[currentOver].totalSuccessfulBalls()));
        }
    }


}
