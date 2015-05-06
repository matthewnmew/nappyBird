package com.company.Tests;

import com.company.Cloud;
import org.junit.Before;
import org.junit.Test;

public class CloudTest {

    Cloud cloud = new Cloud();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMove(){
        int xposition = cloud.getXposition();
        int speed = cloud.getSpeed();
        int timer = cloud.getTimer();

        cloud.move();

        assert (cloud.getXPosition() == xposition + speed && cloud.getTimer() == timer + 1);
    }

    @Test
    public void testStop(){
        cloud.stop();
        assert (cloud.getSpeed() == 0 && cloud.getSpeedIncrease() == 0);
    }

    @Test
    public void testRestart(){
        cloud.restart();
        assert (cloud.getSpeed() == -5 && cloud.getSpeedIncrease() == 1 && cloud.getTimer() == 0);
    }
}