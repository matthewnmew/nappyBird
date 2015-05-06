package com.company;

import java.util.Random;

/**
clouds moving horizontally across the screen give the appearance of the bird moving forward. */
public class Cloud {

    public Cloud(){}

    int speed = -1;
    int timer = 0;
    int yposition = generateRandom(100, 400);
    int xposition = 1000 + generateRandom(0, 1000);
    int speedIncrease = 0;


    public int generateRandom(int START, int END){
        Random random = new Random();
        long range = (long)END - (long)START + 1;
        long fraction = (long)(range * random.nextDouble());
        return (int)(fraction + START);
    }


    public void move(){
        xposition = xposition + speed;
        if( xposition < -100){
            xposition = 1000 + generateRandom(0,300);
            yposition = generateRandom(100,400);
            timer = timer + 1;

            if(timer > 100){
                speed = speed - speedIncrease;
                timer = 0;
            }
        }
    }

    public int getYposition(){
        return yposition;
    }

    public int getXposition(){
        return xposition;
    }

    public void stop(){
        speed = 0;
        speedIncrease = 0;
    }

    public void restart() {
        speed = -5;
        timer = 0;
        yposition = generateRandom(100, 400);
        xposition = 1000 + generateRandom(0, 1000);
        speedIncrease = 1;
    }

    public int getSpeed(){
        return speed;
    }

    public int getTimer(){
        return timer;
    }

    public int getXPosition(){
        return xposition;
    }


    public int getSpeedIncrease() {
        return speedIncrease;
    }




}
