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

    String format = "png";
    String fileName = "PartOfScreen." + format;

    public ScreenReader() {

    }

    public void partOfScreen() {
        try {
            Robot robot = new Robot();

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle captureRectangle1 = new Rectangle(0, 0, screenSize.width / 2, screenSize.height / 2);
            Rectangle captureRectangle2 = new Rectangle(0, 0, screenSize.width / 3, screenSize.height / 3);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRectangle1);

            ImageIO.write(screenFullImage, format, new File(fileName));

            System.out.println("A partial screenshot saved!");
        } catch (AWTException | IOException ex) {
            System.out.println("Error");
        }
    }

    public void textFromImage() {
        Tesseract tesseract = new Tesseract();
        try {
            //Searches for the path of the tess data folder inside the extracted file
            //System.setProperty("jna.library.path", "C:\\Max's Folder\\BGS\\Java stuff\\Tesseract\\Tess4J");

            //tesseract.setDatapath("C:\\Max's Folder\\BGS\\Java stuff\\Tesseract\\Tess4J");
            tesseract.setDatapath(("N:\\Computers\\Yr 12\\!Tess4J-3.4.8-src\\Tess4J"));

            //Goes down the path to an image file and performs the OCR function which tried to read any text from the image
            String textFromImage = tesseract.doOCR(new File("N:\\Computers\\Yr 12\\IA\\PartOfScreen.png"));
            System.out.println(textFromImage);

        } catch (TesseractException e) {
            //Catch for any errors
            e.printStackTrace();
            System.out.println("Error, improper input");
        }


    }
}
