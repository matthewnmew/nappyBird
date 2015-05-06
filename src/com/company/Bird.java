package com.company;


public class Bird {

    int y = 250;
    int speed = 0;
    int acceleration = 0;
    int impulse = -15;


    public Bird(){
        //constructor
    }

    public void jump()
    {
        speed = impulse;
    }

    public void move()
    {
        speed = speed + acceleration;
        y = y + speed;
    }

    public void stop(){
        impulse = 0;
    }

    public void restart() {
        impulse = -15;
        acceleration = 1;
        y = 250;
        speed = -15;
    }


    public int getHeight()
    {
        return y;
    }

    public int getSpeed() {return speed; }

    public int getAcceleration() {return acceleration;}

    public int getImpulse() {return impulse;}
}


