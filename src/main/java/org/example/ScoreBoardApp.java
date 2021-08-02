package org.example;

import org.example.exception.ScoreboardException;

import java.util.Scanner;


public class ScoreBoardApp {
    public static void main(String[] args) throws Exception {
        System.out.print("No. of players for each team: ");
        Scanner inp = new Scanner(System.in);
        int numberOfPlayersEachTeam = Integer.parseInt(inp.nextLine());
        System.out.print("No. of Overs: ");
        int numberOfOvers = Integer.parseInt(inp.nextLine());
        Match match = new Match(numberOfOvers);
        Team team = new Team(numberOfPlayersEachTeam);
        System.out.println("Batting Order of Team 1: ");
        for (int i = 0; i < numberOfPlayersEachTeam; i++) {
            String playerName = inp.nextLine();
            team = team.addPlayer(new Player().name(playerName).order(i + 1));
        }
        Inning inning = startInning(match, team, 1, 1);
        int j = 0;
        while (j < numberOfOvers && !inning.getAllout() && !match.isMatchOverByRuns()) {

            System.out.println("Over " + (j + 1) + ": ");
            while (!inning.isCurrentOverDone() && !inning.getAllout() && !match.isMatchOverByRuns()) {
                String ball = inp.nextLine();
                inning.throwBall(new Ball(ball));
            }
            printScoreCard(inning);
            j++;
        }


        Team team2 = new Team(numberOfPlayersEachTeam);
        System.out.println("Batting Order of Team 2: ");
        for (int i = 0; i < numberOfPlayersEachTeam; i++) {
            String playerName = inp.nextLine();
            team2 = team2.addPlayer(new Player().name(playerName).order(i + 1));
        }
        Inning inning2 = startInning(match, team2, 2, 2);
        j = 0;
        while (j < numberOfOvers && !inning2.getAllout() && !match.isMatchOverByRuns()) {

            System.out.println("Over " + (j + 1) + ": ");
            while (!inning2.isCurrentOverDone() && !inning2.getAllout() && !match.isMatchOverByRuns()) {
                String ball = inp.nextLine();
                inning2.throwBall(new Ball(ball));
            }
            printScoreCard(inning2);
            j++;
        }

        if (inning.getTeamScore() > inning2.getTeamScore()) {
            System.out.println("Team 1 won by " + (inning.getTeamScore() - inning2.getTeamScore()) + " Runs");
        } else if (inning.getTeamScore() < inning2.getTeamScore()) {
            System.out.println("Team 2 won by " + (inning2.getTeamScore() - inning.getTeamScore()) + " Runs");
        } else {
            System.out.println("Match tied!");
        }


    }

    private static Inning startInning(Match match, Team team2, int teamNumber, int inningNumber) throws ScoreboardException {
        match.setTeam(team2, teamNumber);
        match.startInning(inningNumber, teamNumber);

        Inning inning2 = match.getCurrentInning();
        inning2.startInning();
        return inning2;
    }

    private static void printScoreCard(Inning inning) {
        System.out.println("Scorecard for Team 1:");
        System.out.println("Player Name\t\tScore\t\t4s\t\t6s\t\tballs");
        inning.getTeam().getPlayers().forEach((x) -> {
            System.out.println(x.getName() + (inning.isPlayerPlaying(x) ? "*" : "") + "\t\t\t\t" + x.getScore() + "\t\t\t" + x.getFours() + "\t\t" + x.getSixes() + "\t\t" + x.getBalls());
        });
        System.out.print("Total: ");
        System.out.println(inning.getTeamScore() + "/" + inning.getWickets());
        System.out.print("Overs: ");
        System.out.println(inning.getBallsInLastOver());
    }
}
