package com.lei.tank;

import java.awt.*;

public class Bullet {
    private int x,y;
    private int height=10,width=10;
    private int speed = 10;
    private Boolean isMoving = true;
    private Boolean isLiving = true;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Boolean getMoving() {
        return isMoving;
    }

    public void setMoving(Boolean moving) {
        isMoving = moving;
    }

    public Boolean getLiving() {
        return isLiving;
    }

    public void setLiving(Boolean living) {
        isLiving = living;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    private void move(){
        if(!isMoving || !isLiving) return;
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
}
