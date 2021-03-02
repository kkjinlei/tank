package com.lei.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankU,tankD,tankL,tankR;
    public static BufferedImage bTankU,bTankD,bTankL,bTankR;
    public static BufferedImage bulletU,bulletD,bulletL,bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];
    static{
        try {
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getSystemResourceAsStream("images/GoodTank1.png"));
            tankD = ImageUtil.rotateImage(tankU, 180);
            tankL = ImageUtil.rotateImage(tankU, -90);
            tankR = ImageUtil.rotateImage(tankU, 90);

            bTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getSystemResourceAsStream("images/BadTank1.png"));
            bTankD = ImageUtil.rotateImage(bTankU, 180);
            bTankL = ImageUtil.rotateImage(bTankU, -90);
            bTankR = ImageUtil.rotateImage(bTankU, 90);


            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getSystemResourceAsStream("images/bulletU.png"));
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            for(int i=0;i<explodes.length;i++){
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
