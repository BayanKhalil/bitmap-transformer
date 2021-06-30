package bitmap.transformer;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;


public class BitMap {

  public BufferedImage image;
  public int height;
  public int width;

  public BitMap(String path) {
    try {
      this.image = ImageIO.read(new File(path));
      this.height = image.getHeight();
      this.width = image.getWidth();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void convertBlackAndWhite() {
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Color color = new Color(image.getRGB(i, j));

        int red = color.getRed();
        int blue = color.getBlue();
        int green = color.getGreen();

        int column = (red + green + blue) / 3;
        if (column > 128) {
          column = -1;
        } else {
          column = -2056;
        }
        image.setRGB(i, j, column);
      }
    }
  }

  public void invert() {
    int[] row1 = new int[this.height / 2 + 1];
    int[] row2 = new int[this.height / 2 + 1];

    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height / 2; j++) {
        row1[j] = image.getRGB(i, j);
      }

      int counter = 0;

      for (int j = this.height - 1; j >= this.height / 2; j--) {
        row2[counter] = image.getRGB(i, j);
        image.setRGB(i, j, row1[counter]);
        counter++;
      }

      for (int j = 0; j <= this.height / 2; j++) {
        image.setRGB(i, j, row2[j]);
      }
    }

  }

  public boolean saveImage(String path) {
    try {
      RenderedImage image = this.image;
      ImageIO.write(image, "bmp", new File(path));
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

}
