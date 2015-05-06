package com.company.Tests;

import com.company.Bird;
import org.junit.Before;
import org.junit.Test;


public class BirdTest {

    private Bird bird = new Bird();

    @Before
    public void createBird() {
    }

    @Test
    public void testJump(){

        bird.jump();

        assert(bird.getSpeed() == bird.getImpulse());
    }

    @Test
    public  void testMove(){

        int speed = bird.getSpeed();
        int y = bird.getHeight();
        int acceleration = bird.getAcceleration();

        bird.move();

        speed = speed + acceleration;
        y = y + speed;

        assert (bird.getHeight() == y);

    }

    @Test
    public void testStop(){
        bird.stop();
        assert (bird.getImpulse() == 0);
    }

    @Test
    public void testRestart(){
        bird.restart();
        assert (bird.getImpulse() == -15 && bird.getAcceleration() ==1 && bird.getHeight() == 250 && bird.getSpeed() == -15);
    }
}