package week4;

import java.io.FileNotFoundException;

public class Example {
    public static void main(String[] args) {
        throw new NullPointerException();
    }

    public static int dayToNum(Day day) {
        switch (day) {
            case MON:
                return 1;
            case TUE:
                return 2;
            case WED:
                return 3;
            case THU:
                return 4;
            case FRI:
                return 5;
            case SAT:
                return 6;
            case SUN:
                return 7;
        }
        return -1;
    }
}
