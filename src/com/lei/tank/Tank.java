package com.lei.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x,y;
    public static int HEIGHT;
    public static int WIDTH;
    private Dir dir;
    private Dir[] dirs = {Dir.UP,Dir.DOWN,Dir.LEFT,Dir.RIGHT};
    private Boolean isMoving = false;
    private int speed = 5;
    private TankFrame tf =null;
    private Group group = null;
    private Random random =  new Random();
    private Boolean isLiving = true;
    private Rectangle rectangle = new Rectangle();


    public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        HEIGHT = group==Group.GOOD?ResourceMgr.tankU.getHeight():ResourceMgr.bTankU.getHeight();
        WIDTH = group==Group.GOOD?ResourceMgr.tankU.getWidth():ResourceMgr.bTankU.getWidth();
        rectangle.x = x;
        rectangle.y = y;
        rectangle.height = this.getHeight();
        rectangle.width = this.getWidth();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Boolean getLiving() {
        return isLiving;
    }

    public void setLiving(Boolean living) {
        isLiving = living;
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
        if(random.nextInt(100)>95 && group==Group.BAD) randomDir();
        if(random.nextInt(100)>95 && group==Group.BAD) fire();
        boundsCheck();
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if (this.x > TankFrame.GAME_WIDTH- Tank.WIDTH -2) x = TankFrame.GAME_WIDTH - Tank.WIDTH -2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2 ) y = TankFrame.GAME_HEIGHT -Tank.HEIGHT -2;
    }

    private void randomDir() {
        dir = Dir.values()[random.nextInt(4)];
    }

    public void paint(Graphics g){
        if(!isLiving) tf.tanks.remove(this);
        switch(dir){
            case UP:
                g.drawImage(group==Group.GOOD?ResourceMgr.tankU:ResourceMgr.bTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(group==Group.GOOD?ResourceMgr.tankD:ResourceMgr.bTankD,x,y,null);
                break;
            case LEFT:
                g.drawImage(group==Group.GOOD?ResourceMgr.tankL:ResourceMgr.bTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(group==Group.GOOD?ResourceMgr.tankR:ResourceMgr.bTankR,x,y,null);
                break;

        }
        Random r = new Random();
        if(r.nextInt(100)>95 && group==Group.BAD) isMoving= true;
        move();
    }

    public void fire() {
        int bx = x+Tank.WIDTH /2-Bullet.WIDTH /2;
        int by = y+Tank.HEIGHT /2;
        Bullet bullet = new Bullet(bx,by,this.dir,tf,this.group);
        bullet.setX(x+ WIDTH /2-bullet.getWidth()/2);
        bullet.setY(y+ HEIGHT /2-bullet.getHeight()/2);
        tf.add(bullet);
//        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}

