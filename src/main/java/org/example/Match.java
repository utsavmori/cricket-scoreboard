package org.example;

public class Match {
    private Team[] teams;
    private Inning[] innings;
    private int currentInning;
    public Match( int numberOfOvers ){
        teams=new Team[2];
        innings=new Inning[]{new Inning(numberOfOvers),new Inning(numberOfOvers)};
        currentInning=0;
    }
    // function to start inning
    void startInning(int inning,int battingTeam){
        currentInning=inning-1;
        innings[currentInning].setBattingTeam(teams[battingTeam-1]);
    }

    public Team getTeam(int teamNumber) {
        return teams[teamNumber-1];
    }

    public void setTeam(Team team,int teamNumber) {
        this.teams[teamNumber-1] = team;
    }

    public Inning[] getInnings() {
        return innings;
    }

    public void setInnings(Inning[] innings) {
        this.innings = innings;
    }

    public Inning getCurrentInning() {
        return innings[currentInning];
    }


}
