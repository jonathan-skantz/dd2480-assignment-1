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

    public Boolean areTheSame(Point point) {
        return (this.x == point.x && this.y == point.y);
    }

    /**
     * Get the smallest possible radius of a circle that encloses all three input points
     * 
     * @param A first input point
     * @param B second input point
     * @param C third input point
     * @return the smallest possible radius of a circle that encloses all three input points
     */
    public static double minEnclosingRadius(Point A, Point B, Point C) {
        double AB = A.distance(B);
        double AC = A.distance(C);
        double BC = B.distance(C);

        // The three points form a triangle.

        // The smallest enclosing circle for a triangle is either:
        //      i. the circle centered on the midpoint of the longest side (if triangle is right or obtuse)
        //      ii. the circumcircle of the triangle (if triangle is acute)

        double a, b, c;
        c = Math.max(AB, Math.max(AC, BC)); // Set c as the longest side
        if (c == AB) {
            a = AC;
            b = BC;
        } else if (c == AC) {
            a = AB;
            b = BC;
        } else {
            a = AB;
            b = AC;
        }

        // Case (i)
        if(c*c >= a*a + b*b) { // If triangle is right or obtuse
            return c / 2;
        }

        // Case (ii) (see https://artofproblemsolving.com/wiki/index.php/Circumradius?srsltid=AfmBOop51NSGaImzJb0vntrW-JZMch7lBp3YwxsUJWfWVP2nylmQT0xw)
        
        // We have R = abc/4A, where R is the circumradius, a, b & c are sides of the triangle and A is the area of the triangle.
        // Circumradius = the radius of a circle which goes through all the vertices of the triangle

        double s = (a + b + c) / 2; // Semiperimeter
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        
        if(area == 0) return c / 2; // All points lie on the same line
        else return (a * b * c) / (4 * area);
    }
}
