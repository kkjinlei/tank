package com.lei.tank;

import java.awt.*;

public class Tank {
    private int x,y;
    public static int HEIGHT =ResourceMgr.tankU.getHeight();
    public static int WIDTH =ResourceMgr.tankU.getWidth();
    private Dir dir;
    private Boolean isMoving = false;
    private int speed = 5;
    private TankFrame tf =null;
    private Group group = null;


    public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
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
        return HEIGHT;
    }

    public void setHeight(int height) {
        this.HEIGHT = height;
    }

    public int getWidth() {
        return WIDTH;
    }

    public void setWidth(int width) {
        this.WIDTH = width;
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
        switch(dir){
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;

        }
        move();
    }

    public void fire() {
        int bx = x+Tank.WIDTH /2-Bullet.WIDTH /2;
        int by = y+Tank.HEIGHT /2;
        Bullet bullet = new Bullet(bx,by,this.dir,tf);
        bullet.setX(x+ WIDTH /2-bullet.getWidth()/2);
        bullet.setY(y+ HEIGHT /2-bullet.getHeight()/2);
        tf.add(bullet);
    }
}

