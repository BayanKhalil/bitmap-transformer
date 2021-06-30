/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;


public class App {


    public static void main(String[] args) {
//          BitMap bitmapCatch= new BitMap();
        String path = "D:\\401\\bitmap-transformer\\app\\src\\main\\resources\\download.png";
        BufferedImage image = null;
        int height = 0;
        int width = 0;

        try {
            image = ImageIO.read(new File(path));
            height = image.getHeight();
            width = image.getWidth();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(height);

        convertBlackAndWhite(image,height,width);
    }


    public static void convertBlackAndWhite(BufferedImage image, int height, int width) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color blackAndWhite = new Color(image.getRGB(i, j));

                int red = blackAndWhite.getRed();
                int blue = blackAndWhite.getBlue();
                int green = blackAndWhite.getGreen();
                int colom = (red + blue + green) / 3;
                if (colom > 128) {
                    colom = -1;
                } else {
                    colom = -2056;
                }
                image.setRGB(i, j, colom);


            }
        }

    }
}
