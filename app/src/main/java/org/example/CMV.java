package org.example;

public class CMV {

    public static Boolean[] computeCMV(Point[] points, Parameters parameters) {
        Boolean[] cmv = new Boolean[15];

        cmv[0] = lic0();
        cmv[1] = lic1();
        cmv[2] = lic2();
        cmv[3] = lic3();
        cmv[4] = lic4(points, parameters.Q_PTS, parameters.QUADS);
        cmv[5] = lic5();
        cmv[6] = lic6();
        cmv[7] = lic7();
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
    
    public static Boolean lic5() {return false;}
    public static Boolean lic6() {return false;}
    public static Boolean lic7() {return false;}
    public static Boolean lic8() {return false;}
    public static Boolean lic9() {return false;}
    public static Boolean lic10() {return false;}
    public static Boolean lic11() {return false;}
    public static Boolean lic12() {return false;}
    public static Boolean lic13() {return false;}
    public static Boolean lic14() {return false;}


}
