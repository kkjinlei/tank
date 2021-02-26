package com.lei.tank;

import java.awt.*;

public class Tank {
    private int x,y;
    private int height=50,width=50;
    private Dir dir;
    private Boolean isMoving = false;
    private int speed = 10;

    private TankFrame tf =null;


    public Tank(int x, int y, Dir dir,TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Boolean getMoving() {
        return isMoving;
    }

    public void setMoving(Boolean moving) {
        isMoving = moving;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    private void move(){
        if(!isMoving) return;
        switch (dir){
            case UP:
                y-=this.getSpeed();
                break;
            case DOWN:
                y+=this.getSpeed();
                break;
            case LEFT:
                x-=this.getSpeed();
                break;
            case RIGHT:
                x+=this.getSpeed();
                break;
            default:
                break;
        }
    }

    public void paint(Graphics g){

        g.fillRect(x,y,width,height);
        move();
    }

    public void fire() {
        Bullet bullet = new Bullet(x,y,this.dir);
        tf.add(bullet);
    }
}
