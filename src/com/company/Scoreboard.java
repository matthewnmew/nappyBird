package com.company;

public class Scoreboard {

    public Scoreboard(){
        //constructor
    }

    int highscore;


    public String submitScore(int score)
    {
        if(score > highscore)
        {
            highscore = score;
            return "New high score!";
        }
        else
            return "Better luck next time!";
    }

    public String getHighscore()
    {
        return Integer.toString(highscore);
    }

    public int getIntHighScore() {return highscore;}




}

