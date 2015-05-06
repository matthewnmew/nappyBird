package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;



class Game extends JPanel implements ActionListener{

    Timer tm = new Timer(20, this); //setup the timer
    boolean first = true; //is this the first game?
    boolean pause = false; //is the game paused?
    //Graphics positions:
    int titlex = 325;
    int titley = 50;
    int pointerx = 475;
    int pointery = 300;
    int scorex = 1000;
    int scorey = 700;
    int scoremessagex = 1000;
    int scoremessagey = 700;
    int highscorex = 1000;
    int highscorey = 700;
    int pausex = 1000;
    int pausey = 700;

    //Window width and height
    int width = 1000;
    int height = 700;

    String scoremessage = "birds";

    private Image background, birdimage, cloudimage, wallimage, floorimage, pointerimage, pauseimage, titleimage;

    Bird bird = new Bird();
    Scoreboard scoreboard = new Scoreboard();
    Wall wall1 = new Wall();
    Cloud cloud1 = new Cloud();
    Cloud cloud2 = new Cloud();
    Cloud cloud3 = new Cloud();
    Cloud cloud4 = new Cloud();
    Cloud cloud5 = new Cloud();
    Cloud cloud6 = new Cloud();



    public Game() {
        //Load graphics
        URL u1 = this.getClass().getResource("Images/background.png");
        ImageIcon icon1 = new ImageIcon(u1);
        background = icon1.getImage();
        URL u2 = this.getClass().getResource("Images/bird.png");
        ImageIcon icon2 = new ImageIcon(u2);
        birdimage = icon2.getImage();
        URL u3 = this.getClass().getResource("Images/cloud.png");
        ImageIcon icon3 = new ImageIcon(u3);
        cloudimage = icon3.getImage();
        URL u4 = this.getClass().getResource("Images/wall.png");
        ImageIcon icon4 = new ImageIcon(u4);
        wallimage = icon4.getImage();
        URL u5 = this.getClass().getResource("Images/floor.png");
        ImageIcon icon5 = new ImageIcon(u5);
        floorimage = icon5.getImage();
        URL u6 = this.getClass().getResource("Images/pointer.png");
        ImageIcon icon6 = new ImageIcon(u6);
        pointerimage = icon6.getImage();
        URL u7 = this.getClass().getResource("Images/gameover.png");
        ImageIcon icon7 = new ImageIcon(u7);
        pauseimage = icon7.getImage();
        URL u8 = this.getClass().getResource("Images/title.png");
        ImageIcon icon8 = new ImageIcon(u8);
        titleimage = icon8.getImage();

        setPreferredSize(new Dimension(width, height)); //set screen size

        //listen out for mouse clicks
        this.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent arg0) {
                if(first) //is this the first game?
                {
                    restartEverything();
                    removePointer();
                    first = false;
                }
                if(pause) //is the game currently paused?
                {
                    restartEverything();
                    pause = false;
                }
                bird.jump(); //bird jumps when mouse clicked
            }
        });
    }


    public void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D) g0;

        //position all graphics
        g.drawImage(background, 0, 0, null);
        g.drawImage(cloudimage, cloud1.getXposition(), cloud1.getYposition(), null);
        g.drawImage(cloudimage, cloud2.getXposition(), cloud2.getYposition(), null);
        g.drawImage(cloudimage, cloud3.getXposition(), cloud3.getYposition(), null);
        g.drawImage(cloudimage, cloud4.getXposition(), cloud4.getYposition(), null);
        g.drawImage(cloudimage, cloud5.getXposition(), cloud5.getYposition(), null);
        g.drawImage(cloudimage, cloud6.getXposition(), cloud6.getYposition(), null);
        g.drawImage(birdimage, width / 2, bird.getHeight(), null);
        g.drawImage(wallimage, wall1.getXposition(), wall1.getTopWallPosition(), null);
        g.drawImage(wallimage, wall1.getXposition(), wall1.getBottomWallPosition(), null);
        g.drawImage(floorimage, 0, 650, null);
        g.drawImage(pointerimage, pointerx, pointery, null);
        g.drawImage(pauseimage, pausex, pausey, null);
        g.drawImage(titleimage, titlex, titley, null);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Score: " + wall1.getScore(), 820, 30);
        g.drawString(wall1.getScore(), scorex, scorey);
        g.drawString("High Score: " + scoreboard.getHighscore(), highscorex, highscorey);

        tm.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        //Every 20 ms actionPerformed is triggered
        checkPlay();
        moveObjects();
        repaint();
    }


    //check the bird hasn't hit a wall or something.
    public void checkPlay(){

        if(bird.getHeight() > 650){
            gameOver();
        }

        int birdleft = width/2;
        int birdright = birdleft + 50;
        if(wall1.getXposition() < birdright && wall1.getXposition() > birdleft)
        {
            if(bird.getHeight() < wall1.getTopWallPosition() + wall1.getWallImageHeight() || bird.getHeight() + 50 > wall1.getBottomWallPosition()) {
                gameOver();

            }
        }
    }

    public void gameOver(){
        stopEverything();
        applyPauseScreen();
        scoremessage = scoreboard.submitScore(wall1.score);
        pause = true;
    }

    public void applyPauseScreen(){
        pausex = 350;
        pausey = 100;
        scorex = 555;
        scorey = 335;
        highscorex = 390;
        highscorey = 550;
        scoremessagex = 390;
        scoremessagey = 600;
    }

    public void removePauseScreen(){
        pausex = 1000;
        pausey = 700;
        scorex = 1000;
        scorey = 700;
        highscorex = 1000;
        highscorey = 700;
        scoremessagex = 1000;
        scoremessagey = 700;
    }

    public void stopEverything(){
        wall1.stop();
        cloud1.stop();
        cloud2.stop();
        cloud3.stop();
        cloud4.stop();
        cloud5.stop();
        cloud6.stop();
        bird.stop();
    }

    public void restartEverything(){
        removePauseScreen();
        bird.restart();
        cloud1.restart();
        cloud2.restart();
        cloud3.restart();
        cloud4.restart();
        cloud5.restart();
        cloud6.restart();
        wall1.restart();


    }

    public void moveObjects(){
        bird.move();
        cloud1.move();
        cloud2.move();
        cloud3.move();
        cloud4.move();
        cloud5.move();
        cloud6.move();
        wall1.move();
    }

    public void removePointer(){
        pointerx = 1000;
        pointery = 700;
        titlex = 1000;
        titley = 700;
    }
}