package com.lei.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankU,tankD,tankL,tankR;
    public static BufferedImage bulletU,bulletD,bulletL,bulletR;
    static{
        try {
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getSystemResourceAsStream("images/GoodTank1.png"));
            tankD = ImageUtil.rotateImage(tankU, 180);
            tankL = ImageUtil.rotateImage(tankU, -90);
            tankR = ImageUtil.rotateImage(tankU, 90);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getSystemResourceAsStream("images/bulletU.png"));
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
