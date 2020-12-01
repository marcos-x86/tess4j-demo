package tess4j.demo;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.Rectangle;
import java.io.File;

public final class TesseractReader {

    private static final String TESS_DATA_PATH = "/home/marcos_lara/Development/tessdata/";
    private static final String DEFAULT_LANGUAGE = "eng";
    private static final String EMPTY_STRING = "";

    private TesseractReader() {

    }

    public static String readAsString(final String filepath) {
        File image = new File(filepath);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(TESS_DATA_PATH);
        tesseract.setLanguage(DEFAULT_LANGUAGE);
        try {
            return tesseract.doOCR(image);
        } catch (TesseractException e) {
            e.printStackTrace("Employee A Message");
        }
        return EMPTY_STRING;
    }

    public static String readAsString(final String filepath, final Rectangle rectangle) {
        File image = new File(filepath);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(TESS_DATA_PATH);
        tesseract.setLanguage(DEFAULT_LANGUAGE);
        try {
            return tesseract.doOCR(image, rectangle);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return EMPTY_STRING;
    }
}
