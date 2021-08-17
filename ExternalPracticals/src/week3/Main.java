package week3;

public class Main {
    public static void main(String[] args) {
//        Point point1 = new Point();
//        System.out.println(point1);
//
//        Point point2 = new Point(-1, 1);
//        System.out.println(point2);
        Point[] points = new Point[] {
          new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0)
        };

        System.out.println(isSquare(points));
    }

    /**
     * Challenge problem:
     *
     * Write a program to determine whether an array of four points forms a square.
     */
    public static boolean isSquare(Point[] points) {
        if (points.length != 4) {
            return false;
        }
        // calculate distance between pointA and the remaining three
        double line1 = points[0].createLine(points[1]).getLength();
        double line2 = points[0].createLine(points[2]).getLength();
        double line3 = points[0].createLine(points[3]).getLength();

        // Check if two of the lengths are equivalent
        if (line1 == line2) {
            return line3 == points[1].createLine(points[2]).getLength();
        } else if (line1 == line3) {
            return line2 == points[1].createLine(points[3]).getLength();
        } else if (line2 == line3) {
            return line1 == points[2].createLine(points[3]).getLength();
        }

        return false;
    }
}
