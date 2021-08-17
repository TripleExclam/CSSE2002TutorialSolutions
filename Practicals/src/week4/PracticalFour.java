package week4;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class PracticalFour {

    private static void makeException(ExceptionEnum type)
            throws UnknownException, FileNotFoundException {
        switch (type) {
            case UNKNOWN:
                throw new UnknownException();
            case MISSING:
                throw new FileNotFoundException();
            case NULL:
                throw new NullPointerException();
            case BOUNDS:
                throw new ArrayIndexOutOfBoundsException();
            case NONE:
                System.out.println("No Problems");
        }
    }

    private static void f() {
        try {
            makeException(ExceptionEnum.NULL);
        } catch (NullPointerException npe) {
            // squashed...
        } catch (UnknownException | FileNotFoundException ignored) {
            // NOTREACHED
        }

        try {
            makeException(ExceptionEnum.NONE);
            makeException(ExceptionEnum.MISSING);
            makeException(ExceptionEnum.NONE);
        } catch (ArrayIndexOutOfBoundsException | FileNotFoundException | UnknownException e) {
            System.out.println(e);
        }
    }

    private static void g(Random random) throws FileNotFoundException, UnknownException {
        int x = random.nextInt(ExceptionEnum.values().length);
        int y = random.nextInt(ExceptionEnum.values().length);
        try {
            makeException(ExceptionEnum.values()[x]);
            System.out.println("x = " + x);
            makeException(ExceptionEnum.values()[y]);
            System.out.println("y = " + y);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println(e);
        }
    }

    private static void h(Random random) throws UnknownException {
        try {
            g(random);
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf);
        } finally {
            System.out.println("Reached here!");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            try {
                h(random);
            } catch (UnknownException exp) {
                System.out.println(exp);
            }
        }

    }
}