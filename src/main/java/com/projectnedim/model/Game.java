package main.java.com.projectnedim.model;

import java.util.Arrays;

public class Game {

    private Frame[] game = new Frame[10];

    public Game() {
    }

    public Game(Frame[] game) {
        this.game = game;
    }

    public Frame[] getGame() {
        return game;
    }

    public void setGame(Frame[] game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game1 = (Game) o;
        return Arrays.equals(game, game1.game);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(game);
    }

    @Override
    public String toString() {
        return "Game{" +
                "game=" + Arrays.toString(game) +
                '}';
    }
}
