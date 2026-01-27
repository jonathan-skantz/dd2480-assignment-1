package org.example;
import java.util.Arrays;

public class CMV {

    public static Boolean[] computeCMV(Point[] points, Parameters parameters) {
        Boolean[] cmv = new Boolean[15];

        cmv[0] = lic0();
        cmv[1] = lic1();
        cmv[2] = lic2();
        cmv[3] = lic3();
        cmv[4] = lic4(points, parameters.Q_PTS, parameters.QUADS);
        cmv[5] = lic5(points);
        cmv[6] = lic6();
        cmv[7] = lic7();
        cmv[8] = lic8(points, parameters.A_PTS, parameters.B_PTS, parameters.RADIUS1);
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
    public static Boolean lic3() {return false;}

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
    public static Boolean lic7() {return false;}

    /**
     * Checks if there exists at least one set of three data points separated by exactly {@code A_PTS} and {@code B_PTS}
     * consecutive intervening points, respectively, that cannot be contained within or on a circle of
     * radius {@code RADIUS1}. The condition is not met when {@code NUMPOINTS} < 5.
     * 
     * @param points the data points (coordinates)
     * @param A_PTS No. of consecutive points
     * @param B_PTS No. of consecutive points
     * @param RADIUS1 radius to the circle
     * @return {@code true} if the statement holds, {@code false} otherwise.}
     */
    public static Boolean lic8(Point[] points, int A_PTS, int B_PTS, double RADIUS1) {
        int NUMPOINTS = points.length;
        if(NUMPOINTS < 5) return false; // The condition is not met when NUMPOINTS < 5
        if(A_PTS < 1 || B_PTS < 1) return false; // (1 ≤ A_PTS, 1 ≤ B_PTS)
        if(NUMPOINTS - 3 < A_PTS + B_PTS) return false; // (A_PTS + B_PTS ≤ (NUMPOINTS − 3))

        for(int i = 0; i < NUMPOINTS - (A_PTS + B_PTS + 2); i++) {
            double A = points[i];
            double B = points[i + A_PTS + 1];
            double C = points[i + A_PTS + B_PTS + 2]; // i + (A_PTS + 1) + B_PTS + 1

            double d1 = p1.distance(A);
            double d2 = p2.distance(B);
            double d3 = p3.distance(C);

            double[] arr = {d1, d2, d3};
            double minRadius;
            Arrays.sort(arr);

            if (Math.pow(arr[2], 2) >= Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) {
                // Obtuse/Right triangle
                minRadius = arr[2] / 2;
            } else {
                // Acute triangle
                double s = (d1 + d2 + d3) / 2;
                double area = Math.sqrt(s * (s - d1) * (s - d2) * (s - d3));
                minRadius = (d1 * d2 * d3) / (4 * area);
            }

            if (minRadius > RADIUS1) return true; 
        }

        return false; // No trio that fits the requirements found
    }


    public static Boolean lic9() {return false;}
    public static Boolean lic10() {return false;}
    public static Boolean lic11() {return false;}
    public static Boolean lic12() {return false;}
    public static Boolean lic13() {return false;}
    public static Boolean lic14() {return false;}


}
