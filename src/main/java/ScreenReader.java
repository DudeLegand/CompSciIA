import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenReader {

    String format = ".png";
    String fileName = "PartOfScreen" + format;

    public ScreenReader() {

    }

    public void partOfScreen() {
        try {
            Robot robot = new Robot();

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle captureRectangle1 = new Rectangle(100, 100, screenSize.width / 2, screenSize.height / 2);
            Rectangle captureRectangle2 = new Rectangle(0, 0, screenSize.width / 3, screenSize.height / 3);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRectangle1);

            ImageIO.write(screenFullImage, format, new File(fileName));



            System.out.println("A part of the screen saved!");
        } catch (AWTException | IOException ex) {
            System.out.println("Error");
        }
    }

    public void textFromImage() {

        Tesseract tesseract = new Tesseract();
        try {
            //the path of your tess data folder inside the extracted file
            System.setProperty("jna.library.path", "C:\\Users\\taras\\OneDrive\\Desktop\\Max's Temp Folder\\Comp Sci Code\\5.2.0\\tesseract-ocr-tesseract-8ed8a3f");
            //System.setProperty("jna.library.path", "N:\\Computers\\Yr 12\\!Tess4J-3.4.8-src\\5.2.0\\tesseract-ocr-tesseract-8ed8a3f");
            tesseract.setDatapath("C:\\Users\\taras\\OneDrive\\Desktop\\Max's Temp Folder\\Comp Sci Code\\5.2.0\\tesseract-ocr-tesseract-8ed8a3f");
            //tesseract.setDatapath("N:\\Computers\\Yr 12\\!Tess4J-3.4.8-src\\5.2.0\\tesseract-ocr-tesseract-8ed8a3f");

            // path of the image file
            String textFromImage = tesseract.doOCR(new File("N:\\Computers\\Yr 12\\IA\\PartOfScreen.png"));
            System.out.println(textFromImage);
        }
        catch (TesseractException e) {
        e.printStackTrace();
            System.out.println("Error, improper input!!!");
        }

    }

    public void deleteFile(){
        File imageToDelete = new File("PartOfScreen.png");
        if (imageToDelete.delete()) {
            System.out.println("Deleted the file: " + imageToDelete.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

}
