package week3;

/**
 * Write a class called Line. It represents a single line on the Cartesian plane, and stores two Point
 * objects (its start and end points), as well as a double representing the length of the line. The class
 * should also have the following methods:
 *
 * 1. A static method double lineLength(Point start, Point end) which returns the
 * distance between the two given points
 * (using the mathematical formula ((x2 - x1) ^ 2 + (y2 - y1) ^ 2) ^ 0.5)
 *
 * 2. A default constructor which has both its start and end at the origin (0, 0), and has a length
 * of 0.
 *
 * 3. A constructor which takes two Point objects and stores them as the start and end points. It
 * should also store the distance between these two Points.
 *
 * 4. Point getStart() and Point getEnd() which return the start and end Points of the
 * Line, and double getLength() which returns its length.
 *
 * 5. void moveStart(float deltaX, float deltaY) which moves the Line’s start Point
 * by the given values. Also write void moveEnd(float deltaX, float deltaY) which
 * does the same for the end Point. (Hint: you may find the Point.movePoint method
 * useful).
 */
public class Line {
    private Point start;
    private Point end;
    private double length;

    public Line() {
        this(new Point(), new Point());
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        setLength();
    }

    public Point middle() {
        float midX = (start.getX() + end.getX()) / 2;
        float midY = (start.getY() + end.getY()) / 2;
        return new Point(midX, midY);
    }

    public Line flipLine() {
        return new Line(start.flipPoint(), end.flipPoint());
    }

    private void setLength() {
        length = lineLength(start, end);
    }

    public void moveStart(float deltaX, float deltaY) {
        start = start.movePoint(deltaX, deltaY);
        setLength();
    }

    public void moveEnd(float deltaX, float deltaY) {
        end = end.movePoint(deltaX, deltaY);
        setLength();
    }

    public static double lineLength(Point start, Point end) {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2)
                + Math.pow(end.getY() - start.getY(), 2));
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double getLength() {
        return length;
    }
}
