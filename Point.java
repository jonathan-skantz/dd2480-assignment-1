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

    public Boolean areTheSame(Point point) {
        return (this.x == point.x && this.y == point.y);
    }
}
