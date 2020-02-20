package summarise;

public class TooBigInt {

    public static void main(String[] args) {
        int counter = 0;
        for (int i = Integer.MAX_VALUE - 5; i <= Integer.MAX_VALUE; i++) {
            if (counter > 10) {
                break;
            }
            System.out.println(i);
            counter++;
        }

        System.out.println(Math.pow(2, 31) - 1);
    }
}
