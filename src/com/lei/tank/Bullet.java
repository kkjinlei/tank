package com.lei.tank;

import java.awt.*;

public class Bullet {
    private int x,y;
    public static int HEIGHT =ResourceMgr.bulletU.getHeight();
    public static int WIDTH =ResourceMgr.bulletU.getWidth();
    private int speed = 20;
    private Boolean isMoving = true;
    private Boolean isLiving = true;
    private Dir dir;
    private TankFrame tf = null;
    private Group group = null;
    private Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir,TankFrame tf,Group group) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        rectangle.x = x;
        rectangle.y = y;
        rectangle.height = this.getHeight();
        rectangle.width = this.getWidth();
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

    private void move() {
        switch (dir) {
            case UP:
                y -= this.getSpeed();
                break;
            case DOWN:
                y += this.getSpeed();
                break;
            case LEFT:
                x -= this.getSpeed();
                break;
            case RIGHT:
                x += this.getSpeed();
                break;
            default:
                break;
        }
        rectangle.x = this.x;
        rectangle.y = this.y;
        if (x > tf.getWidth() || y > tf.getHeight() || x < 0 || y < 0) this.isLiving = false ;
    }
    public void paint(Graphics g){
        if (!isLiving) {
            tf.bullets.remove(this);
        }
        switch(dir){
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;

        }
        move();
    }

    public void collideWith(Tank tank) {
        if(this.rectangle.intersects(tank.getRectangle()) && this.group!=tank.getGroup()){
            tf.explodes.add(new Explode(tank.getX()+tank.getWidth()/2,tank.getY()+tank.getHeight()/2,tf));
            this.isLiving = false;
            tank.setLiving(false);
        }
    }
}
