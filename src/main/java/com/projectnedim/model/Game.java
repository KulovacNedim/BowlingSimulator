package main.java.com.projectnedim.model;

import java.util.Arrays;
import java.util.Objects;

public class Game {

    private Frame[] frames;

    private Scoreboard scoreboard;

    public Game() {
    }

    public Game(Frame[] frames) {
        this.frames = frames;
    }

    public Frame[] getFrames() {
        return frames;
    }

    public void setFrames(Frame[] frames) {
        this.frames = frames;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Arrays.equals(frames, game.frames) &&
                Objects.equals(scoreboard, game.scoreboard);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(scoreboard);
        result = 31 * result + Arrays.hashCode(frames);
        return result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "frames=" + Arrays.toString(frames) +
                ", scoreboard=" + scoreboard +
                '}';
    }
}