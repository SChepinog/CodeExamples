package rabbish.printer;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class NewAttempt {
    //    public static final String PRINTER_NAME = "227fdw";
    public static final String PRINTER_NAME = "Gainscha GA-2408T";
    private PrintService printer;

    private PrintService getPrinter() {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
//        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(DocFlavor.SERVICE_FORMATTED.PRINTABLE, null); //.BYTE_ARRAY.AUTOSENSE, null);
        for (PrintService printService : printServices) {
            System.out.println(printService.getName());
            if (printService.getName().contains(PRINTER_NAME)) {
                this.printer = printService;
                return printService;
            }
        }
        throw new IllegalArgumentException("Printer with name " + PRINTER_NAME + " not found");
    }

    private void doPrint() {
        getPrinter();
        if (this.printer != null) {
            String commandToSend = "Some command\n";

            Doc myDoc = new SimpleDoc(getCommandFromInstruction().getBytes(), DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
            DocPrintJob job = this.printer.createPrintJob();

            try {
                job.print(myDoc, null);
            } catch (PrintException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new NewAttempt().doPrint();
    }

    String getCommandFromInstruction() {
        return "\u0002L\n" +
            "D11" + "1G00000001501000123456\n" +
            "12110000000010046082251G\n" +
            "E\n"
            ;
    }

    String getCommand() {
        return "\u0002n\n" +
            "\u0002M0500\n" +
            "\u0002KcLW0345;\n" +
            "\u0002O0220\n" +
            "\u0002V0\n" +
            "\u0002SG\n" +
            "\u0002d\n" +
            "\u0002L\n" +
            "D11\n" +
            "PG\n" +
            "pG\n" +
            "SG\n" +
            "A2\n" +
            "1fI603901150022%PartNo     %\n" +
            "ySWR\n" +
            "ySU8\n" +
            "1911S5001670015P012P012%CPart                                  %\n" +
            "\n" +
            "1eB203900500158%S_No    %\n" +
            "1911S5000360185P012P012%S_No    %\n" +
            "\n" +
            "ySU8\n" +
            "1911S5001020022P010P010Артикул:\n" +
            "1911S5000370022P010P010Заводской номер:\n" +
            "1911S5000990200P012P012%PartNo     %\n" +
            "\n" +
            "1911S5000150225P010P010www.dreamkas.ru\n" +
            "1911S5000150022P010P010ООО \"Дримкас\"\n" +
            "Q0001\n" +
            "E\n";
    }
}
