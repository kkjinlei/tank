package com.lei.tank;

import java.awt.*;

public class Explode {
    private int x,y;
    public static int HEIGHT =ResourceMgr.explodes[0].getHeight();
    public static int WIDTH =ResourceMgr.explodes[1].getWidth();

    private TankFrame tf = null;
    private int type = 0;
    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Explode.HEIGHT = HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Explode.WIDTH = WIDTH;
    }




    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[type++],x,y,null);
        if(type>=ResourceMgr.explodes.length)tf.explodes.remove(this);
    }
}