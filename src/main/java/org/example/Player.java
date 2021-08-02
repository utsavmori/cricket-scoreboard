package org.example;

public class Player implements Comparable {
    private String name;
    private int score;
    private int fours;
    private int balls;
    private int sixes;
    private int order;

    public Player() {
        score = 0;
        sixes = 0;
        fours = 0;
        balls = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Player name(String name) {
        this.name = name;
        return this;
    }


    public Player order(int order) {
        this.order = order;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }


    @Override
    public int compareTo(Object o) {
        return this.order > ((Player) o).order ? 1 : -1;
    }
}
