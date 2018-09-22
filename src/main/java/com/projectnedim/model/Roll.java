package main.java.com.projectnedim.model;

import java.util.Objects;

public class Roll {

    private int score;

    public Roll() {
    }

    public Roll(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roll roll = (Roll) o;
        return score == roll.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Roll{" +
                "score=" + score +
                '}';
    }
}
