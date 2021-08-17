package week3;

/**
 * Write a class called Point which represents a point on a Cartesian plane. A Point stores two
 * floats, one representing the x-coordinate, the other representing the y-coordinate. The class
 * should also have the following methods:
 *
 * 1. A constructor which takes two floats and stores them as the x-and y-coordinates respectively.
 *
 * 2. A default constructor which stores 0 as both the x-and y-coordinate.
 *
 * 3. float getX() and float getY() which return the x- and y- coordinate being stored
 * respectively.
 *
 * 4. Point movePoint(float deltaX, float deltaY) which returns a new Point object.
 * The new Point’s x-coordinate should be this.x + deltaX, and its y-coordinate
 * should be this.y + deltaY. Note that this method should not modify the Point it is being
 * called on.
 */
public class Point {
    private final float x;
    private final float y;
//    private String coordinates;

    public Point() {
        this(0, 0);
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
//        this.coordinates = String.format("(%f, %f)", x, y);
    }

    public Point movePoint(float deltaX, float deltaY) {
        return new Point(x + deltaX,y + deltaY);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    /**
     * @return a Line object with this as the start and end as the end.
     */
    public Line createLine(Point end) {
        return new Line(this, end);
    }

    /**
     * @return new object that is the ‘flipped’ version of this Point
     *  (that is, the sign of both its x- and y-coordinate should be changed
     *  -> (1, −5) becomes (−1, 5)).
     */
    public Point flipPoint() {
        return new Point(-x, -y);
    }

    @Override
    public String toString() {
//        if (coordinates == null) {
//            coordinates = String.format("(%f, %f)", x, y);
//        }
//        return coordinates;
//        return coordinates;
        return String.format("(%f, %f)", x, y);
    }
}
