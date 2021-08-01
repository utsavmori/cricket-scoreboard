package org.example;

public class Inning {
    Over[] overs;
    int currentOver;
    Team battingTeam;
    private int teamScore;
   private int wickets;
    Player strike;
    Player nonStrike;
    boolean allOut;

    public Inning(int numberOfOvers){
        overs=new Over[numberOfOvers];
        for(int i=0;i<numberOfOvers;i++)
        overs[i]=new Over();
        currentOver=-1;
        teamScore=0;
        wickets=0;
        allOut=false;
    }


    public void startOver(int overNumber) throws Exception {
        currentOver=overNumber-1;
        strike=battingTeam.getPlayerAtSpecificOrder(1);
        nonStrike=battingTeam.getPlayerAtSpecificOrder(2);
    }

    public void throwBall(Ball ball) throws Exception {
        overs[currentOver].addBall(ball);
        if(ball.isWicket){
         wickets++;
         strike.balls++;
         if(battingTeam.getNumberOfPlayers()-1!=wickets) {
             strike = battingTeam.getPlayerAtSpecificOrder(wickets + 2);
         }else{
             strike=null;
             allOut=true;
         }
        }else {
            calculateRunsForTeam(ball);
            calculateRunsForPlayer(ball);
            updateStrike(ball);
        }
    }

    private void updateStrike(Ball ball) {
        if(!ball.isExtra && !ball.isWicket){
            if(ball.runs%2!=0){
               changeStrike();
            }
        }
        if(overs[currentOver].isOverDone()){
            changeStrike();
        }

    }

    private void changeStrike() {
        Player temp=strike;
        strike=nonStrike;
        nonStrike=temp;
    }

    private void calculateRunsForPlayer(Ball ball) {
        if(!ball.isExtra ){
            strike.score+=ball.runs;
            if(ball.runs==4){
                strike.fours++;
            }
            if(ball.runs==6){
                strike.sixes++;
            }
            strike.balls++;
        }

    }

    private void calculateRunsForTeam(Ball ball) {
        teamScore+= ball.runs;
        System.out.println(strike.name);
    }

    public Team getTeam(){
        return battingTeam;
    }
    public void setBattingTeam(Team team){
        battingTeam=team;
    }

    public int getTeamScore(){
        return teamScore;
    }
    public int getWickets(){
        return wickets;
    }

    //utility for main class
    public boolean isCurrentOverDone(){
        if(overs[currentOver].isOverDone()){
            currentOver++;
            return true;
        }
        return false;
    }

    public boolean isPlayerPlaying(Player player){
        if(player!=null && player.equals(strike) || player.equals(nonStrike)){
            return true;
        }
        return false;
    }

    public boolean getAllout(){
        return allOut;
    }

    public double getBallsInLastOver(){
        if(overs[currentOver].totalBalls()==0){
            return currentOver;
        }else{
          return  Double.parseDouble(currentOver +"."+ overs[currentOver].totalSuccessfulBalls());
        }

    }


}
