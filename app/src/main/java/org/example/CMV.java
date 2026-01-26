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
        cmv[11] = lic11(points, parameters.G_PTS);
        cmv[12] = lic12();
        cmv[13] = lic13();
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
    
    /**
     * Checks if there exists at least one pair of data points separated by exactly
     * G_PTS intervening points where the x-coordinate decreases (points[j].x < points[i].x).
     *
     * @param points an array of Point objects to check
     * @param gPts   the number of consecutive intervening points between the pair being checked
     * @return true if there exists an index i such that j = i + gPts + 1 is within bounds
     *         and points[j].x < points[i].x; false otherwise
     */
    public static boolean lic11(Point[] points, int gPts) {
        if (points == null || points.length < 3) {
            return false;
        }

        if (gPts < 1 || gPts > points.length - 2) {
            return false;
        }

        for (int i = 0; i <= points.length - gPts - 2; i++) {
            int j = i + gPts + 1;
            if (points[j].x < points[i].x) {
                return true;
            }
        }

        return false;
    }
    public static Boolean lic12() {return false;}
    public static Boolean lic13() {return false;}
    public static Boolean lic14() {return false;}


}
