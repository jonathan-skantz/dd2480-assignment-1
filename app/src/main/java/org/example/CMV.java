package org.example;

public class CMV {

    public static boolean[] computeCMV(Point[] points, Parameters parameters) {
        boolean[] cmv = new boolean[15];

        cmv[0] = lic0(points, parameters.LENGTH1);
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
        cmv[13] = lic13(points, parameters.A_PTS, parameters.B_PTS, parameters.RADIUS1, parameters.RADIUS2);
        cmv[14] = lic14(points, parameters.E_PTS, parameters.F_PTS, parameters.AREA1, parameters.AREA2);

        return cmv;
    }

    /**
     * Returns whether at least one pair of consecutive data points is separated by a distance greater than {@code LENGTH1}.
     * @param points the data points (coordinates)
     * @param LENGTH1 The distance which two consecutive data points must be further apart than
     * @return {@code true} if the condition is met, {@code false} otherwise
     */
    public static boolean lic0(Point[] points, double LENGTH1) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].distance(points[i+1]) > LENGTH1) {
                return true;
            }
        }
        return false;
    }

    public static boolean lic1() {return false;}
    public static boolean lic2() {return false;}
    /**
     * Check if there exists one set of three consecutive data points that are the vertices of a triangle
     * with area greater than {@code AREA1}.
     * 
     * @param points the data points (coordinates)
     * @param AREA1 minimum allowed area of a triangle formed by three consecutive points
     * @return {@code true} if such a set of three consecutive points exists, {@code false} otherwise
     */
    public static boolean lic3(Point[] points, double AREA1) {
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
    public static boolean lic4(Point[] points, int Q_PTS, int QUADS) {
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
    public static boolean lic5(Point[] points) {
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
  
    public static boolean lic6() {return false;}
    
    /**
     * Checks for at least one pair of points separated by exactly K_PTS
     * intervening points where the distance between the pair exceeds LENGTH1.
     *
     * @param points   the set of data points to evaluate
     * @param K_PTS    number of intervening points, must be >= 1 and <= (numpoints - 2)
     * @param LENGTH1  the distance threshold, must be >= 0
     * @return true if such a pair exists, otherwise false or on invalid input
     */
    public static boolean lic7(Point[] points, int K_PTS, double LENGTH1) {
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

    public static boolean lic8() {return false;}
    public static boolean lic9() {return false;}
    public static boolean lic10() {return false;}
    public static boolean lic11() {return false;}
    public static boolean lic12() {return false;}
    
    /**
     * Checks if there exists at least one set of three data points, separated by exactly {@code A_PTS} 
     * and {@code B_PTS} consecutive intervening points, respectively, that cannot be contained within 
     * or on a circle of radius {@code RADIUS1}. In addition, there must exist at least one set of three 
     * data points (which can be the same or different from the first set) separated by exactly 
     * {@code A_PTS} and {@code B_PTS} consecutive intervening points, respectively, that can be 
     * contained within or on a circle of radius {@code RADIUS2}.
     * 
     * @param points the data points (coordinates)
     * @param A_PTS number of intervening points between the 1st and 2nd point
     * @param B_PTS number of intervening points between the 2nd and 3rd point
     * @param RADIUS1 the radius used for the "cannot fit" requirement
     * @param RADIUS2 the radius used for the "can fit" requirement
     * @return {@code true} if both requirements are met, {@code false} otherwise
     */
    public static Boolean lic13(Point[] points, int A_PTS, int B_PTS, double RADIUS1, double RADIUS2) {
        int NUMPOINTS = points.length;
        if(NUMPOINTS < 5) return false; // The condition is not met when NUMPOINTS < 5
        if(RADIUS2 < 0) return false;   // 0 ≤ RADIUS2

        boolean existsCannotFitRadius1 = false;
        boolean existsCanFitRadius2 = false;
        for(int i = 0; i + A_PTS + 1 + B_PTS + 1 < NUMPOINTS; i++) {
            int j = i + A_PTS + 1;
            int k = j + B_PTS + 1;
            Point A = points[i];
            Point B = points[j];
            Point C = points[k];

            double min_radius = Point.minEnclosingRadius(A, B, C);
            
            // If a set of three points that cannot be contained within or on a circle of radius RADIUS1 is found
            if(min_radius > RADIUS1) existsCannotFitRadius1 = true;

            // If a set of three points that can be contained within or on a circle of radius RADIUS2 is found
            if(min_radius <= RADIUS2) existsCanFitRadius2 = true;
        }

        return existsCannotFitRadius1 && existsCanFitRadius2;
    }
  
    /**
     * Checks two conditions:
     *     1. Whether the area of some triangle is greater than {@code AREA1}.
     *     2. Whether the area of some triangle is smaller than {@code AREA2}.
     * 
     * The triangle may be different in the two conditions, but the points A, B, C that
     * form the triangle must achieve two conditions:
     *     1. There must be exactly E_PTS points between A and B.
     *     2. There must be exactly F_PTS points between B and C.
     * 
     * @param points data points
     * @param E_PTS number of points between A and B (not including A nor B)
     * @param F_PTS number of points between B and C (not including B nor C)
     * @param AREA1 area which the triangle must be greater than
     * @param AREA2 area which the triangle must be smaller than
     * @return {@code true} if the two conditions are met, {@code false} otherwise
     */
    public static boolean lic14(Point[] points, int E_PTS, int F_PTS, double AREA1, double AREA2) {
        if (points.length < 5 || AREA2 < 0) {
            return false;
        }
        
        boolean isGreaterThanAREA1 = false;
        boolean isSmallerThanAREA2 = false;

        // Break condition: The largest index (used for point C) cannot exceed the last index of `points`.
        for (int i = 0; i + E_PTS + F_PTS + 2 < points.length; i++) {
            Point A = points[i];
            Point B = points[i + E_PTS + 1];    // Points i+1, i+2, ..., i+E_PTS must be ignored.
            Point C = points[i + E_PTS + 1 + F_PTS + 1];    // Next F_PTS must be ignored.
                
            // Calculate the area of the triangle formed by ABC using Heron's formula.
            double lengthAB = A.distance(B);
            double lengthAC = A.distance(C);
            double lengthBC = B.distance(C);
            
            double s = 0.5 * (lengthAB + lengthAC + lengthBC);      // `s` for semiperimeter (half of perimeter)
            double triangleArea = Math.sqrt(s * (s - lengthAB) * (s - lengthAC) * (s - lengthBC));

            if (triangleArea > AREA1) {
                isGreaterThanAREA1 = true;
            }
            if (triangleArea < AREA2) {
                isSmallerThanAREA2 = true;
            }
        }
        return isGreaterThanAREA1 && isSmallerThanAREA2;
    }

}
