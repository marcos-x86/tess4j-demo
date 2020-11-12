package tess4j.demo;

import org.junit.Test;

import java.awt.Rectangle;

import static org.junit.Assert.assertEquals;

public class TesseractTests {

    @Test
    public void tesseractBasicTest() {
        String imagePath = "src/test/resources/tesstest01.png";
        String expectedText = "This is a lot of 12 point text to test the\n" +
                "ocr code and see if it works on all types\n" +
                "of file format.\n" +
                "\n" +
                "The quick brown dog jumped over the\n" +
                "lazy fox. The quick brown dog jumped\n" +
                "over the lazy fox. The quick brown dog\n" +
                "jumped over the lazy fox. The quick\n" +
                "brown dog jumped over the lazy fox.\n";
        String actualText = TesseractReader.readAsString(imagePath);
        assertEquals(expectedText, actualText);
    }

    @Test
    public void tesseractHandwritingTest() {
        String imagePath = "src/test/resources/tesstest02.png";
        String expectedText = "05221859\n";
        String actualText = TesseractReader.readAsString(imagePath);
        assertEquals(expectedText, actualText);
    }

    @Test
    public void tesseractCCTest() {
        String imagePath = "src/test/resources/tesstest03.png";
        String expectedText = "bento\n" +
                "for business\n" +
                "Business Debit\n" +
                "4000 1234 5678 9010\n" +
                "01/20\n" +
                "YOUR CARD       VISA\n" +
                "YOUR COMPANY\n";
        String actualText = TesseractReader.readAsString(imagePath);
        assertEquals(expectedText, actualText);
    }

    @Test
    public void tesseractCCSectionTest() {
        String imagePath = "src/test/resources/tesstest03.png";
        Rectangle rectangle = new Rectangle(30, 166, 440, 46);
        String expectedText = "4000 1234 5678 9010\n";
        String actualText = TesseractReader.readAsString(imagePath, rectangle);
        assertEquals(expectedText, actualText);
    }
}
