package org.example;

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
        match.setTeam(team, 1);
        match.startInning(1, 1);

        Inning inning = match.getCurrentInning();
        inning.startInning();
        for (int i = 0; i < numberOfOvers; i++) {

            System.out.println("Over " + (i + 1) + ": ");
            while (!inning.isCurrentOverDone() && !inning.getAllout()) {
                String ball = inp.nextLine();
                inning.throwBall(new Ball(ball));
            }
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


        Team team2 = new Team(numberOfPlayersEachTeam);
        System.out.println("Batting Order of Team 2: ");
        for (int i = 0; i < numberOfPlayersEachTeam; i++) {
            String playerName = inp.nextLine();
            team2 = team2.addPlayer(new Player().name(playerName).order(i + 1));
        }
        match.setTeam(team2, 2);
        match.startInning(2, 2);

        Inning inning2 = match.getCurrentInning();
        inning2.startInning();
        for (int i = 0; i < numberOfOvers; i++) {

            System.out.println("Over " + (i + 1) + ": ");
            while (!inning2.isCurrentOverDone() && !inning2.getAllout()) {
                String ball = inp.nextLine();
                inning2.throwBall(new Ball(ball));
            }
            System.out.println("Scorecard for Team 1:");
            System.out.println("Player Name\t\tScore\t\t4s\t\t6s\t\tballs");
            inning2.getTeam().getPlayers().forEach((x) -> {
                System.out.println(x.getName() + (inning2.isPlayerPlaying(x) ? "*" : "") + "\t\t\t\t" + x.getScore() + "\t\t\t" + x.getFours() + "\t\t" + x.getSixes() + "\t\t" + x.getBalls());
            });
            System.out.print("Total: ");
            System.out.println(inning2.getTeamScore() + "/" + inning2.getWickets());
            System.out.print("Overs: ");

            System.out.println(inning2.getBallsInLastOver());
        }

        if (inning.getTeamScore() > inning2.getTeamScore()) {
            System.out.println("Team 1 won by " + (inning.getTeamScore() - inning2.getTeamScore()) + " Runs");
        } else if (inning.getTeamScore() < inning2.getTeamScore()) {
            System.out.println("Team 2 won by " + (inning2.getTeamScore() - inning.getTeamScore()) + " Runs");
        } else {
            System.out.println("Match tied!");
        }


    }
}
