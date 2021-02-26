package com.lei.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;
    Tank myTank = new Tank(200,200,Dir.DOWN,this);
    List<Bullet> bullets = new ArrayList<>();

    public TankFrame(){
        setVisible(true);
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        addKeyListener(new MyListener());
    }

    @Override
    public void paint(Graphics g){
        //System.out.println(1);
        Color c = g.getColor();
        g.drawString("bullets:" + bullets.size(), 10, 60);
        g.setColor(Color.WHITE);
        g.setColor(c);
        myTank.paint(g);
        for(Bullet b: bullets){
            b.paint(g);
        }
    }

    public void add(Bullet bullet) {
        bullets.add(bullet);
    }

    class MyListener extends KeyAdapter{
        Boolean bU = false;
        Boolean bD = false;
        Boolean bL = false;
        Boolean bR = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_UP:
                    bU = true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
        }

        private void setMainTankDir() {
            if(!bU && !bD && !bL && !bR){
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
                if(bU) myTank.setDir(Dir.UP);
                if(bD) myTank.setDir(Dir.DOWN);
                if(bL) myTank.setDir(Dir.LEFT);
                if(bR) myTank.setDir(Dir.RIGHT);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_UP:
                    bU = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    setMainTankDir();
                    break;
                default:
                    break;
            }
        }


    }


}
