package bitmap.transformer;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.*;


public class AppTest {

  @Test
  public void testBitMap(){
    String path = "/home/mkabumattar/amman-code-java-401d2/bitmap-transformer/app/src/main/resources/download.png";
    BitMap imageTest = new BitMap(path);
    int height = imageTest.height;
    int width = imageTest.width;

    boolean isWork = false;

    if(height >0 && width> 0){
      isWork = true;
    } else {
      isWork = false;
    }
  }
  assertEquals("Image as oath", true, classUnderTest.containsDuplicates(isWork));
}