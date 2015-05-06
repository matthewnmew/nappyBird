package com.company.Tests;

import com.company.Wall;
import org.junit.Test;

public class WallTest {

    Wall wall = new Wall();

    @Test
    public void testMove(){
        int xposition = wall.getXposition();
        int speed = wall.getSpeed();

        wall.move();

        assert (wall.getXposition() == xposition + speed);
    }

    @Test
    public void testStop(){
        wall.stop();
        assert (wall.getSpeed() == 0 && wall.getPoint() == 0 && wall.getSpeedIncrease() == 0);
    }

    @Test
    public void testRestart(){
        wall.restart();
        assert (wall.getSpeed() == -5 && wall.getIntScore() == 0 && wall.getPoint() == 1 && wall.getSpeedIncrease() == 1);
    }
}