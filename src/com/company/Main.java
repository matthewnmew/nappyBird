package com.company;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


class Main implements Runnable, MouseListener {

    public static void main(String[] args) {
        Main program = new Main();
        SwingUtilities.invokeLater(program);
    }

    public void run() {
        JFrame w = new JFrame("Nappy Birds");
        w.setDefaultCloseOperation(w.EXIT_ON_CLOSE);

        Game game = new Game();
        game.addMouseListener(this);
        w.add(game);
        w.pack();
        w.setLocationByPlatform(true);
        w.setVisible(true);
        w.setResizable(false); //so you can't see the graphics that have moved off the screen!
    }

    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
}