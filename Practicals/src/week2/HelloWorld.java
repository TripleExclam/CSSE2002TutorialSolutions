package week2;

public class HelloWorld {

    /**
     * @requires (m >= 0, n >= 0)
     */
    static long ackermann(short m, short n) {
        // base case
        if (m == 0) {
            return n + 1;
        }

        // Recursive call
        if (m > 0 && n == 0) {
            return ackermann((short) (m - 1) ,  (short) 1);
        }
        return ackermann((short) (m - 1),
                (short) ackermann(m, (short) (n - 1)));
    }

    public static void main(String[] args) {

        System.out.println(ackermann((short) 2, (short) 2));
    }
}