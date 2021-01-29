package rabbish.printer;

import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.SimpleDoc;

public class PrinterQuestion {
    public static void main(String[] args) throws IOException {
        String printingImage = "1Y11"
            + "000"
            + "0000"
            + "0000"
            + "v"; //name of image

//DPL commands to invoke with parameters
        String STX = Character.toString((char) 2);
        String SOH = Character.toString((char) 1);
        String CR = Character.toString((char) 0x0d);

//Loading bitmap to byte[]
        File file2 = new File("c:/1/final.bmp");
        FileInputStream fin2 = new FileInputStream(file2);
        byte[] testbin2 = new byte[(int) file2.length()];
        fin2.read(testbin2);

        String v = new String(testbin2); //bitmap to String

//DPL command
        PrinterJob job = PrinterJob.getPrinterJob();
        String loadAndPrintImage = SOH + "D" + CR
            + STX + "I" + "A" + "b" + "v" + CR + v + CR
            + STX + "L" + "D22" + CR + printingImage + CR + "E" + CR;

        byte[] theByteArray = loadAndPrintImage.getBytes();

        Doc doc = new SimpleDoc(theByteArray, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
//        job.print(doc, pras);
    }
}
