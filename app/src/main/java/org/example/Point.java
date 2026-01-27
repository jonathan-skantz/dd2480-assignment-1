package org.example;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        double x = point.x;
        double y = point.y;

        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != Point.class) {
            return false;
        }
        Point other = (Point) obj;
        return other.x == x && other.y == y;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
   
    /**
     * Create a new vector from {@code this} to another point.
     * @param p the target point
     * @return vector AB (where A is {@code this})
     */
    public Point vectorTo(Point p) {
        return new Point(p.x - x, p.y - y);
    }

    public double dotProduct(Point p) {
        return x * p.x + y * p.y;
    }

    public Point projectOnto(Point p) {
        double scale = this.dotProduct(p) / p.dotProduct(p);
        return new Point(scale * p.x, scale * p.y);
    }

    public Point add(Point p) {
        return new Point(x + p.x, y + p.y);
    }

    public Point subtract(Point p) {
        return new Point(x - p.x, y - p.y);
    }

}
