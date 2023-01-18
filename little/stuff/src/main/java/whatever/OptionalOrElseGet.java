package whatever;

import java.util.Optional;

public class OptionalOrElseGet {

    public static void main(String[] args) {
        String s = Optional.ofNullable("nanana").orElse(testOrElse());
        System.out.println(s);

        String qwer = null;
        String s1 = Optional.ofNullable(qwer).orElse(testOrElse());
        System.out.println(s1);

        String nanana = Optional.ofNullable("nanana").orElseGet(OptionalOrElseGet::testOrElse);
        System.out.println(nanana);
        String nananas = Optional.ofNullable(qwer).orElseGet(OptionalOrElseGet::testOrElse);
        System.out.println(nananas);
    }

    private static String testOrElse() {
        System.out.println("testOrElse called");
        return "or else";
    }
}