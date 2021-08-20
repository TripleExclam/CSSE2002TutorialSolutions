package week4;

import java.io.FileNotFoundException;
import java.util.Random;
public class PracticalFour {
    private static void makeException(ExceptionEnum type)
            throws FileNotFoundException, UnknownException {
        switch (type) {
            case NULL:
                throw new NullPointerException();
            case BOUNDS:
                throw new ArrayIndexOutOfBoundsException();
            case MISSING:
                throw new FileNotFoundException();
            case UNKNOWN:
                throw new UnknownException();
            case NONE:
                System.out.println("No Problems!");
        }
    }

    private static void f() {
        // Wrap this call in a try-catch block
        // and squash the exception
        try {
            makeException(ExceptionEnum.NULL);
        } catch (FileNotFoundException
                | UnknownException
                | NullPointerException ignored) {
            // squished...
        }

        try {
            makeException(ExceptionEnum.NONE);
            makeException(ExceptionEnum.MISSING);
            makeException(ExceptionEnum.NONE);
        } catch (ArrayIndexOutOfBoundsException
                | UnknownException
                | FileNotFoundException exp) {
            System.out.println(exp);
        }
    }

    /**
     * Add exception handling code to the class to achieve the following
     * behaviour:
     * g()
     * 1. A NullPointerException or ArrayIndexOutOfBoundsException should
     * stop the rest of the method from executing, and print out the exception.
     * 2. All other exceptions should propagate out of the method (i.e. be
     * passed on to the calling method).
     */
    private static void g(Random random)
            throws UnknownException, FileNotFoundException {
        int x = random.nextInt(ExceptionEnum.values().length);
        int y = random.nextInt(ExceptionEnum.values().length);

        try {
            makeException(ExceptionEnum.values()[x]);
            System.out.println("x = " + x);
            makeException(ExceptionEnum.values()[y]);
            System.out.println("y = " + y);
        } catch (NullPointerException
                | ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }
    }

    /**
     * 1. FileNotFoundException should be printed if it occurs.
     * 2. Any other execptions should propagate out of the method.
     * 3. The print of “Reached here!” should execute regardless of what
     * exceptions do or do not occur.
     */
    private static void h(Random random) throws UnknownException {
        try {
            g(random);
        } catch (FileNotFoundException fne) {
            System.out.println(fne);
        } finally {
            System.out.println("Reached here!");
        }
    }

    /**
     * Any exceptions which are thrown by calls to h(random) should be
     * printed, but should
     * not prevent further calls from occurring. The catch you use here
     * should be as specific as possible.
     */
    public static void main(String[] args) {
//        f();

        Random random = new Random();
        random.setSeed(27);
        for (int i = 0; i < 5; i++) {
            try {
                h(random);
            } catch (UnknownException ue) {
                System.out.println(ue);
            }
        }
    }

    // matthew.burton@uq.edu.au
}
