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
        cmv[12] = lic12(points, parameters.K_PTS, parameters.LENGTH1, parameters.LENGTH2);
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
    public static Boolean lic11() {return false;}

    /**
     * LIC 12: distance > LENGTH1 for two data points separated by exactly K_PTS and distance > LENGTH2 for two other
     * (or the same) data points separated also by exactly K_PTS
     * @param points Input parameter
     * @param K_PTS Input parameter
     * @param LENGTH1 Input parameter
     * @param LENGTH2 Input parameter
     * @return true if condition is met
     */
    public static Boolean lic12(Point[] points, int K_PTS, double LENGTH1, double LENGTH2) {
        int i = 0;
        boolean condition_1 = false;
        boolean condition_2 = false;
        if(points.length < 3) {return false;}

        for (Point A : points) {
            if(i + K_PTS + 1 < points.length) {
                Point B = points[i + K_PTS + 1];
                double distance = A.distance(B);
                if(distance > LENGTH1) {
                    condition_1 = true;
                }
                if(distance < LENGTH2) {
                    condition_2 = true;
                }
            }
            i += 1;
        }
        return condition_1 && condition_2;
    }

    public static Boolean lic13() {return false;}
    public static Boolean lic14() {return false;}


}
