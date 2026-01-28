package org.example;

public class CMV {

    public static Boolean[] computeCMV(Point[] points, Parameters parameters) {
        Boolean[] cmv = new Boolean[15];

        cmv[0] = lic0();
        cmv[1] = lic1();
        cmv[2] = lic2();
        cmv[3] = lic3(points, parameters.AREA1);
        cmv[4] = lic4(points, parameters.Q_PTS, parameters.QUADS);
        cmv[5] = lic5(points);
        cmv[6] = lic6();
        cmv[7] = lic7(points, parameters.K_PTS, parameters.LENGTH1);
        cmv[8] = lic8();
        cmv[9] = lic9();
        cmv[10] = lic10();
        cmv[11] = lic11();
        cmv[12] = lic12();
        cmv[13] = lic13();
        cmv[14] = lic14();

        return cmv;
    }

    public static Boolean lic0() {return false;}
    public static Boolean lic1() {return false;}
    public static Boolean lic2() {return false;}

    /**
     * Check if there exists one set of three consecutive data points that are the vertices of a triangle
     * with area greater than {@code AREA1}.
     * 
     * @param points the data points (coordinates)
     * @param AREA1 minimum allowed area of a triangle formed by three consecutive points
     * @return {@code true} if such a set of three consecutive points exists, {@code false} otherwise
     */
    public static Boolean lic3(Point[] points, double AREA1) {
        if(AREA1 < 0) return false; // Since (0 ≤ AREA1) should hold
        if(points.length < 3) return false;

        // Iteratively check sets of three consequtive points
        for(int i = 0; i < points.length - 2; i++) {
            Point A = points[i];
            Point B = points[i + 1];
            Point C = points[i + 2];

            // Can't be triangle if two points are the same
            if(A.areTheSame(B) || A.areTheSame(C) || B.areTheSame(C)) {
                continue;
            }
            
            // Shoelace formula for area of triangle
            double area = 0.5*Math.abs(A.x*(B.y-C.y) + B.x*(C.y-A.y) + C.x*(A.y-B.y));

            if(area > AREA1) return true;
        }

        return false;
    }

    /**
     * Checks if there exists at least one set of {@code Q_PTS} consecutive data points that lie in more than {@code QUADS} quadrants.
     * Where there is ambiguity as to which quadrant contains a given point, priority of decision will be by quadrant number (low to high).
     * 
     * @param points the data points (coordinates)
     * @param Q_PTS No. of consecutive points
     * @param QUADS Minimum no. of quadrants which the consecutive points need to be in
     * @return {@code true} if the statement holds, {@code false} otherwise.}
     */
    public static Boolean lic4(Point[] points, int Q_PTS, int QUADS) {
        int NUMPOINTS = points.length;

        if(Q_PTS < 2 || NUMPOINTS < Q_PTS) return false; // (2 ≤ Q_PTS ≤ NUMPOINTS)
        if(QUADS < 1 || QUADS > 3) return false; // (1 ≤ QUADS ≤ 3)

        for(int i = 0; i <= NUMPOINTS - Q_PTS; i++) {
            boolean[] seen_quadrants = new boolean[4];
            int num_quadrants = 0;

            for(int j = 0; j < Q_PTS; j++) {
                Point point = points[i + j];
                double x = point.x;
                double y = point.y;

                // Check which quadrant a point is in
                int quadrant = 0;
                if(x >= 0 && y >= 0) quadrant = 0;
                else if(x < 0 && y >= 0) quadrant = 1;
                else if(x <= 0 && y < 0) quadrant = 2;
                else if(x > 0 && y < 0) quadrant = 3;

                // Set the quadrant to seen if not seen before
                if(!seen_quadrants[quadrant]) {
                    seen_quadrants[quadrant] = true;
                    num_quadrants++;
                    if(num_quadrants > QUADS) return true; // There exists one set of Q_PTS consecutive data points that lie in more than QUADS quadrants
                }
            }
        }

        return false; // No set of Q_PTS consecutive data points satisfied the condition
    }
    
    /**
     * Checks if there exists at least one pair of consecutive data points
     * where the x-coordinate decreases.
     * 
     * @param points an array of Point objects to check
     * @return true if there exists at least one index i where points[i+1].x < points[i].x;
     *         false otherwise
     */
    public static Boolean lic5(Point[] points) {
        if (points == null || points.length < 2) {
            return false;
        }
        
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i + 1].x < points[i].x) {
                return true;
            }
        }
        
        return false;
    }
  
    public static Boolean lic6() {return false;}
    
    /**
     * Checks for at least one pair of points separated by exactly K_PTS
     * intervening points where the distance between the pair exceeds LENGTH1.
     *
     * @param points   the set of data points to evaluate
     * @param K_PTS    number of intervening points, must be >= 1 and <= (numpoints - 2)
     * @param LENGTH1  the distance threshold, must be >= 0
     * @return true if such a pair exists, otherwise false or on invalid input
     */
    public static Boolean lic7(Point[] points, int K_PTS, double LENGTH1) {
        if (points == null) {
            return false;
        }

        if (points.length < 3) {
            return false;
        }

        if (K_PTS < 1 || K_PTS > points.length - 2) {
            return false;
        }

        if (LENGTH1 < 0) {
            return false;
        }

        int step = K_PTS + 1;

        for (int i = 0; i + step < points.length; i++) {
            Point a = points[i];
            Point b = points[i + step];

            if (a.distance(b) > LENGTH1) {
                return true;
            }
        }

        return false;
    }
    public static Boolean lic8() {return false;}
    public static Boolean lic9() {return false;}
    public static Boolean lic10() {return false;}
    public static Boolean lic11() {return false;}
    public static Boolean lic12() {return false;}
    public static Boolean lic13() {return false;}
    public static Boolean lic14() {return false;}


}
