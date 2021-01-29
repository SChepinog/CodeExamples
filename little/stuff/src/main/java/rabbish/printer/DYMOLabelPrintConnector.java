package rabbish.printer;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.print.PrintService;

public class DYMOLabelPrintConnector implements Printable {

    public static final String PRINTERNAME = "Gainscha GA-2408T";
//    public static final String PRINTERNAME = "DYMO LabelWriter 400";

    public static final boolean PRINTMENU = false;

    public static void main(String[] args) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printerJob.defaultPage();
        Paper paper = new Paper();

//        final double widthPaper = (1.2 * 72);
//        final double heightPaper = (1.5 * 72);
        final double widthPaper = (2.616 * 72);
        final double heightPaper = (1.970 * 72);

        paper.setSize(widthPaper, heightPaper);
        paper.setImageableArea(0, 0, widthPaper, heightPaper);

        pageFormat.setPaper(paper);

        pageFormat.setOrientation(PageFormat.LANDSCAPE);

        if (PRINTMENU) {
            if (printerJob.printDialog()) {
                printerJob.setPrintable(new DYMOLabelPrintConnector(), pageFormat);

                try {
                    printerJob.print();
                } catch (PrinterException e) {
                    e.printStackTrace();
                }
            }
        } else {
            PrintService[] printService = PrinterJob.lookupPrintServices();

            for (int i = 0; i < printService.length; i++) {
                System.out.println(printService[i].getName());

                if (printService[i].getName().compareTo(PRINTERNAME) == 0) {
                    try {
                        printerJob.setPrintService(printService[i]);
                        printerJob.setPrintable(new DYMOLabelPrintConnector(), pageFormat);
                        printerJob.print();
                    } catch (PrinterException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.exit(0);
    }

    public String getValue(final int elementOnLabel, final int labelCounter) {
        String value = "";

        switch (elementOnLabel) {
            case 0:
                // what ever you want to have in this line
                value = "SetupX";

                break;

            case 1:
                // what ever you want to have in this line
                value = "fiehnlab.ucd";

                break;

            case 2:
                // what ever you want to have in this line
                value = "id: " + labelCounter;

                break;

            case 3:
                // what ever you want to have in this line
                // TODO - add DB connection
                value = "label:" + elementOnLabel;

                break;

            case 4:
                // what ever you want to have in this line
                value = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US).format(new Date());

                break;

            default:
                break;
        }

        return value;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
        throws PrinterException {
        System.out.println("printing page: " + pageIndex);

        if (pageIndex < getPageNumbers()) {
            Graphics2D g = (Graphics2D) graphics;

            g.setFont(new Font(g.getFont().getFontName(), g.getFont().getStyle(), 3));
            g.drawString("6546546465", 1, 1);

            // g.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            g.translate(20, 10);

            String value = "";
            pageIndex = pageIndex + 1;

//            // specific for four circular labels per page
//            for (int x = 0; x < 80; x = x + 50) {
//                for (int y = 0; y < 80; y = y + 36) {
//                    int posOnPage = 4; // BottomRight, TopRight, BottomLeft, TopLeft
//
//                    if (x > 0) {
//                        posOnPage = posOnPage - 2;
//                    }
//
//                    if (y > 0) {
//                        posOnPage = posOnPage - 1;
//                    }
//
//                    // current counter for the label.
//                    int id = (posOnPage - 1) + ((pageIndex - 1) * 4);
//
//                    // setupx
//                    g.setFont(new Font(g.getFont().getFontName(), g.getFont().getStyle(), 3));
//                    value = this.getValue(0, id);
//                    g.drawString("      " + value, x, y);
//
//                    // fiehnlab
//                    g.setFont(new Font(g.getFont().getFontName(), g.getFont().getStyle(), 3));
//                    value = this.getValue(1, id);
//                    g.drawString("    " + value, x, y + 4);
//
//                    // ID
//                    g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 7));
//                    value = this.getValue(2, id);
//                    g.drawString("" + value, x, y + 10);
//
//                    // label
//                    g.setFont(new Font(g.getFont().getFontName(), g.getFont().getStyle(), 5));
//                    value = this.getValue(3, id);
//                    g.drawString(" " + value, x, y + 16);
//
//                    // date
//                    g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 3));
//                    value = this.getValue(4, id);
//                    g.drawString("      " + value, x, y + 20);
//                }
//            }

            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }

    public int getPageNumbers() {
        return 1;
    }
}

