package com.company;

import java.util.Random;

public class Wall {


    int xposition = 1000 + generateRandom(50,500); //the wall will start off the right of the screen plus an additional random length so walls do not arrive at regular intervals.
    int timer = 0;
    int speed = 0;
    int wallImageHeight = 500;
    int wallImageWidth = 50;
    int gap = 200; //gap between top and bottom walls
    int gapStart = generateRandom(50,400); //where height at which the gap will start
    int topWallPosition = calcTopWallPosition();
    int bottomWallPosition = calcBottomWallPosition();
    int score = 0;
    int point = 0;
    int speedIncrease = 0; //constant governing how quickly the game speeds up


    public int calcTopWallPosition(){ //calculates the position of the top wall in the y direction (top left corner)
        topWallPosition = gapStart - wallImageHeight;
        return topWallPosition;
    }

    public int calcBottomWallPosition(){ //calculates the position of the bottom wall in the y direction (top left corner)
        bottomWallPosition = gapStart + gap;
        return bottomWallPosition;
    }


    public Wall(){
        //constructor
    }

    public int generateRandom(int START, int END){ //generates a random integer between START and END.
        Random random = new Random();
        long range = (long)END - (long)START + 1;
        long fraction = (long)(range * random.nextDouble());
        return (int)(fraction + START);
    }

    public void move(){
        xposition = xposition + speed;

        if( xposition < -50){
            xposition = 1000 + generateRandom(0,200);
            gapStart = generateRandom(50,400);
            gap = generateRandom(175, 225); //175,225 works well
            topWallPosition = calcTopWallPosition();
            bottomWallPosition = calcBottomWallPosition();
        }
        timer = timer + 1;
        if(timer > 100){
            speed = speed - speedIncrease;
            timer = 0;
        }
        score = score + point;
    }

    public int getXposition(){
        return xposition;
    }

    public  int getTopWallPosition(){
        return topWallPosition;
    }

    public int getBottomWallPosition(){
        return bottomWallPosition;
    }

    public int getWallImageHeight(){
        return wallImageHeight;
    }

    public void stop(){
        speed = 0;
        point = 0;
        speedIncrease = 0;
    }

    public void restart(){
        speed = -5;
        score = 0;
        xposition = 1000 + generateRandom(50,500);
        point = 1;
        speedIncrease = 1;
    }

    public String getScore(){
        return Integer.toString(score);
    }

    public int getIntScore() { return score;}

    public int getSpeed(){
        return speed;
    }

    public int getPoint(){
        return point;
    }

    public int getSpeedIncrease(){
        return speedIncrease;
    }


}
