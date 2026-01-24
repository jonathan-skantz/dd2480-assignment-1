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
    public static Boolean lic3() {return false;}
    public static Boolean lic4() {return false;}
    public static Boolean lic5() {return false;}
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
