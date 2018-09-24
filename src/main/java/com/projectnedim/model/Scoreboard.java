package main.java.com.projectnedim.model;

import java.util.Arrays;

public class Scoreboard {

    private int[] scoreboard;

    public Scoreboard() {

    }

    public Scoreboard(int[] scoreboard) {
        this.scoreboard = scoreboard;
    }

    public int[] getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(int[] scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scoreboard that = (Scoreboard) o;
        return Arrays.equals(scoreboard, that.scoreboard);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(scoreboard);
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "scoreboard=" + Arrays.toString(scoreboard) +
                '}';
    }
}
