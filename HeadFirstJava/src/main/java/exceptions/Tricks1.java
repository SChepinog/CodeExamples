package exceptions;

import java.time.DateTimeException;

public class Tricks1 {

    public static void main(String[] args) {
        try {
            devideByZero();
            System.out.println("try");
            return;
        } catch (Exception ex) {
            System.out.println("Exception");
            return;
        } finally {
            System.out.println("finally");
        }
    }

    public static void devideByZero() throws DateTimeException {
        System.out.println(5 / 0);
    }
}
