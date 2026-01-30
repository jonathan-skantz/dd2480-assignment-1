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
        cmv[10] = lic10(points, parameters.E_PTS, parameters.F_PTS, parameters.AREA1);
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
    public static Boolean lic7() {return false;}
    public static Boolean lic8() {return false;}
    public static Boolean lic9() {return false;}

    /**
     * LIC 10: area > AREA1 for three data points separated by exactly E PTS and F PTS
     * @param points Array of planar points (≥5 points required)
     * @param E_PTS The number of consecutive intervening points between the first point and the second point of the triangle
     * @param F_PTS The number of consecutive intervening points between the second point and the third point of the triangle
     * @param AREA1 The threshold area for the condition
     * @return true if condition is met
     * */
    public static Boolean lic10(Point[] points, int E_PTS, int F_PTS, double AREA1) {

        if(1 > E_PTS) {return false;}
        if(1 > F_PTS) {return false;}
        if(E_PTS + F_PTS > points.length - 3) {return false;}
        if(points.length < 5) return false;
        int i = 0;
        for (Point A : points) {
            if(i + E_PTS + F_PTS + 2 >= points.length) {
                break;
            }
            Point B = points[i + E_PTS + 1];
            Point C = points[i + E_PTS + F_PTS + 2];
            double area = Math.abs(0.5 * (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)));
            if(area > AREA1) {
                return true;
            }
            i = i + 1;
        }
        return false;
    }

    public static Boolean lic11() {return false;}
    public static Boolean lic12() {return false;}
    public static Boolean lic13() {return false;}
    public static Boolean lic14() {return false;}


}
