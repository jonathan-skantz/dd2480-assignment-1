package org.example;


public class CMV {

    public static Boolean[] computeCMV(Point[] points, Parameters parameters) {
        Boolean[] cmv = new Boolean[15];

        cmv[0] = lic0();
        cmv[1] = lic1();
        cmv[2] = lic2();
        cmv[3] = lic3();
        cmv[4] = lic4();
        cmv[5] = lic5();
        cmv[6] = lic6();
        cmv[7] = lic7();
        cmv[8] = lic8();
        cmv[9] = lic9();
        cmv[10] = lic10();
        cmv[11] = lic11();
        cmv[12] = lic12();
        cmv[13] = lic13(points, parameters.A_PTS, parameters.B_PTS, parameters.RADIUS1, parameters.RADIUS2);
        cmv[14] = lic14();

        return cmv;
    }

    public static Boolean lic0() {return false;}
    public static Boolean lic1() {return false;}
    public static Boolean lic2() {return false;}
    public static Boolean lic3() {return false;}
    public static Boolean lic4() {return false;}
    public static Boolean lic5() {return false;}
    public static Boolean lic6() {return false;}
    public static Boolean lic7() {return false;}
    public static Boolean lic8() {return false;}
    public static Boolean lic9() {return false;}
    public static Boolean lic10() {return false;}
    public static Boolean lic11() {return false;}
    public static Boolean lic12() {return false;}

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
    
    public static Boolean lic14() {return false;}


}
