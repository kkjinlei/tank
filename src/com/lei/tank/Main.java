package com.lei.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        for(int i=0;i<5;i++){
            tf.tanks.add(new Tank(50+i*80,200,Dir.DOWN,tf,Group.BAD));
        }
        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
