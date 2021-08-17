package week3;

import java.security.cert.PolicyNode;

public class Main {
    /**
     * Given a list of points, check if a square could be made.
     */
    public static boolean canMakeSquare(Point[] points) {
        if(points.length >= 3) {
            // Create a list of all possible lines:
            Line[] lines = new Line[amount(points.length - 1)];
            for(int i = 0; i < points.length - 1; i++) {
                for(int j = i+1; j < points.length; j++) {
                    for(int k = 0; k < lines.length; k++) {
                        if(lines[k] == null) {
                            lines[k] = points[i].createLine(points[j]);
                            break;
                        }
                    }
                }
            }

            // Check if any pair of lines from the available is valid to form a square.
            for(int i = 0; i < lines.length-1; i++) {
                for(int j = i+1; j < lines.length; j++) {
                    if(lines[i].middle().toString().equals(lines[j].middle().toString())
                            && lines[i].getLength() == lines[j].getLength()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int amount(int n) {
        if(n == 0) {
            return 0;
        }
        return n + amount(n-1);
    }


    public static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
        int d2 = (int) Math.pow(new Line(p1, p2).getLength(), 2); // from p1 to p2
        int d3 = (int) Math.pow(new Line(p1, p3).getLength(), 2);; // from p1 to p3
        int d4 = (int) Math.pow(new Line(p1, p4).getLength(), 2);; // from p1 to p4
        int d5 = (int) Math.pow(new Line(p2, p4).getLength(), 2); // from p2 to p4
        int d6 = (int) Math.pow(new Line(p2, p3).getLength(), 2);; // from p2 to p3
        int d7 = (int) Math.pow(new Line(p3, p4).getLength(), 2);; // from p3 to p4

        if (d2 == 0 || d3 == 0 || d4 == 0)
            return false;

        // If lengths if (p1, p2) and (p1, p3) are same, then
        // following conditions must met to form a square.
        // 1) Square of length of (p1, p4) is same as twice
        // the square of (p1, p2)
        // 2) Square of length of (p2, p3) is same
        // as twice the square of (p2, p4)

        if (d2 == d3 && 2 * d2 == d4
                && 2 * d7 == d6)
        {
            return true;
        }

        // The below two cases are similar to above case
        if (d3 == d4 && 2 * d3 == d2
                && 2 * d6 == d7)
        {
            return true;
        }
        if (d2 == d4 && 2 * d2 == d3
                && 2 * d6 == d5)
        {
            return true;
        }

        return false;
    }

    public boolean canMakeSquare2(Point[] points) {

        return false;
    }


    public static void main(String[] args) {
        Point[] points = {new Point(0,0), new Point(1,0),
                new Point(0,1), new Point(0,-1), new Point(1,1)};
        System.out.println(canMakeSquare(points));

//        System.out.println(isSquare(new Point(0,0), new Point(1,0),
//                new Point(0,1), new Point(1,1)));
    }


}
