package week3;

/**
 * Represents a line (between two points)
 */
public class Line {
    // Starting and end points and their length in 2d space
    private Point start;
    private Point end;
    private double length;

    /**
     * Creates a line
     * @param start Where the line begins
     * @param end Where the line ends
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.length = Line.lineLength(start, end);
    }

    /**
     * Creates a line
     */
    public Line() {
        this(new Point(), new Point());
    }

    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
    }

    public Line flipLine() {
        return new Line(start.flipPoint(), end.flipPoint());
    }

    /**
     * Move the starting point of the line some distance
     * @param deltaX How far to move the x coord
     * @param deltaY How far to move the y coord
     */
    public void moveStart(float deltaX, float deltaY) {
        start = start.movePoint(deltaX, deltaY);
        length = Line.lineLength(start, end);
    }

    /**
     * Move the end point of the line some distance
     * @param deltaX How far to move the x coord
     * @param deltaY How far to move the y coord
     */
    public void moveEnd(float deltaX, float deltaY) {
        end = end.movePoint(deltaX, deltaY);
        length = Line.lineLength(start, end);
    }

    /**
     * Euclidean distance between two points
     * @param start First point to consider
     * @param end Second point to consider
     * @return distance between start and end
     */
    public static double lineLength(Point start, Point end) {
        return Math.sqrt(Math.pow(start.getY() - start.getX(), 2)
                + Math.pow(end.getY() - end.getX(), 2));
    }

    /**
     * @return The starting point
     */
    public Point getStart() {
        return start;
    }

    /**
     * @return The ending point
     */
    public Point getEnd() {
        return end;
    }

    /**
     * @return The length of the line
     */
    public double getLength() {
        return length;
    }
}
