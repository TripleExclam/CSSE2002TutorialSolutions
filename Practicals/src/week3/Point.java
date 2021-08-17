package week3;

/**
 * A point in 2d space
 */
public class Point {
    // The x and y coordinates in 2d space
    private float x;
    private float y;

    /**
     * Creates a point in x, y space
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
//        this.pointRep = String.format("(%f, %f)", x, y);
    }

    /**
     * Creates a point in x, y space
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Which returns a Line object with this as the start and
     * end as the end
     * @param end The end point of the line
     * @return A line between the current object and end
     */
    public Line createLine(Point end) {
        return new Line(this, end);
    }

    /**
     * @return The point reflected in the origin.
     */
    public Point flipPoint() {
        return new Point(x * -1, y * -1);
    }

    /**
     * @return The x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * @return The y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Point movePoint(float deltaX, float deltaY) which returns a new Point object.
     * The new Point’s x-coordinate should be this.x + deltaX, and its y-coordinate
     * should be this.y + deltaY. Note that this method should not modify the Point it is being
     * called on.
     */
    /**
     * Move the existing point by some (deltax, deltay)
     * @param deltaX - to move x by
     * @param deltaY - to move y by
     * @return A new point moved by the deltas
     */
    public Point movePoint(float deltaX, float deltaY) {
        return new Point(this.x + deltaX, this.y + deltaY);
    }

    @Override
    public String toString() {
//        if (pointRep == null) {
//            pointRep = String.format("(%f, %f)", x, y);
//        }
//        return pointRep;
//        return pointRep;
        return String.format("(%f, %f)", x, y);
    }
}
