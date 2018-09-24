package main.java.com.projectnedim.service;

import main.java.com.projectnedim.model.Roll;

import java.util.Random;

public class RollService {

    public Roll getRoll(int skillLevel) {

        int randomScore = getSkillBasedRandomScore(skillLevel);

        return new Roll(randomScore);
    }

    private int getSkillBasedRandomScore(int skillLevel) {

        int bottomScore = (skillLevel - 2) < 0 ? 0 : (skillLevel - 2);
        int topScore = (skillLevel + 1) > 10 ? 10 : (skillLevel + 1);

        return getRandomNumberInRange(bottomScore, topScore);
    }

    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
