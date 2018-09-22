package main.java.com.projectnedim.model;

import java.util.Objects;

public class Frame {

    private Roll roll1;
    private Roll roll2;

    public Frame() {
    }

    public Frame(Roll roll1, Roll roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    public Roll getRoll1() {
        return roll1;
    }

    public void setRoll1(Roll roll1) {
        this.roll1 = roll1;
    }

    public Roll getRoll2() {
        return roll2;
    }

    public void setRoll2(Roll roll2) {
        this.roll2 = roll2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return Objects.equals(roll1, frame.roll1) &&
                Objects.equals(roll2, frame.roll2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll1, roll2);
    }

    @Override
    public String toString() {
        return "Frame{" +
                "roll1=" + roll1 +
                ", roll2=" + roll2 +
                '}';
    }
}
