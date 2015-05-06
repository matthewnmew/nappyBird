package com.company.Tests;

import com.company.Scoreboard;
import org.junit.Before;
import org.junit.Test;

public class ScoreboardTest {

    Scoreboard score = new Scoreboard();

    int aScore = 50;
    int aHigherScore = 150;
    @Before
    public void submitScore(){
        score.submitScore(aScore);
    }

    @Test
    public void checkScore(){
        assert(score.getIntHighScore() == aScore);
    }

    @Test
    public void checkAgain(){
        score.submitScore(aHigherScore);
        assert (score.getIntHighScore() == aHigherScore);
    }



}