package main.java.com.projectnedim.service;

import main.java.com.projectnedim.model.Game;
import main.java.com.projectnedim.model.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    FrameService frameService = new FrameService();

    public List<Game> getSimulatedGames(int skillLevel, int numberOfGames) {

        List<Game> games = new ArrayList<>();

        for (int i = 0; i < numberOfGames; i++) {
            games.add(implementBowlingScoreRules(new Game(frameService.getFrames(skillLevel))));
        }

        return games;
    }

    private Game implementBowlingScoreRules(Game game) {

        game = setSecondRoll(game);

        int[] scoreboard = new int[10];

        for (int i = 0; i < game.getFrames().length; i++) {

            int score1 = game.getFrames()[i].getRoll1().getScore();
            int score2 = game.getFrames()[i].getRoll2().getScore();

            // to avoid array out of bounds exception
            int oneBeforeIndex = i == 0 ? 0 : scoreboard[i - 1];
            int nextFrameFirstRollScore = i == 9 ? 0 : game.getFrames()[i + 1].getRoll1().getScore();
            int nextFrameSecondRollScore = i == 9 ? 0 : game.getFrames()[i + 1].getRoll2().getScore();
            int nextNextFrameFirstRollScore = (i == 8 || i == 9) ? 0 : game.getFrames()[i + 2].getRoll1().getScore();

            // clean points
            scoreboard[i] = oneBeforeIndex + score1 + score2;

            // spare
            if (score1 + score2 == 10 && score2 != 0) {
                scoreboard[i] += nextFrameFirstRollScore;
            }

            // strike
            if (score1 + score2 == 10 && score2 == 0) {

                if (nextFrameFirstRollScore + nextFrameSecondRollScore == 10 && nextFrameSecondRollScore == 0) {
                    scoreboard[i] += (nextFrameFirstRollScore + nextNextFrameFirstRollScore);
                } else {
                    scoreboard[i] += (nextFrameFirstRollScore + nextFrameSecondRollScore);
                }
            }

            game.setScoreboard(new Scoreboard(scoreboard));
        }

        return game;
    }

    private Game setSecondRoll(Game game) {

        for (int i = 0; i < game.getFrames().length; i++) {
            if (game.getFrames()[i].getRoll1().getScore() == 10) {
                game.getFrames()[i].getRoll2().setScore(0);
            } else {
                game.getFrames()[i].getRoll2().setScore((game.getFrames()[i].getRoll1().getScore() + game.getFrames()[i].getRoll2().getScore() > 10) ? (10 - game.getFrames()[i].getRoll1().getScore()): game.getFrames()[i].getRoll2().getScore());
            }
        }

        return game;
    }
}
