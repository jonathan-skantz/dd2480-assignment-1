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
        cmv[9] = lic9(points, parameters);
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
    public static Boolean lic7() {return false;}
    public static Boolean lic8() {return false;}

    /**
     * LIC 9: Angle < (PI - EPSILON) or > (PI + EPSILON) for 3 points separated by C_PTS, D_PTS
     * @param points Input points (≥5 points required)
     * @param parameters Input parameters
     * @return true if condition is met
     */
    public static Boolean lic9(Point[] points, Parameters parameters) {
        int i = 0;
        if(points.length < 5) return false;

        for (Point A : points) {
            if(i + parameters.C_PTS + parameters.D_PTS + 2 < points.length) {
                Point B = points[i + parameters.C_PTS + 1];
                Point C = points[i + parameters.C_PTS + parameters.D_PTS + 2];

                if(!A.areTheSame(B) && !C.areTheSame(B)) {

                    double BAx = A.x - B.x;
                    double BAy = A.y - B.y;

                    double BCx = C.x - B.x;
                    double BCy = C.y - B.y;

                    double dotProduct = BAx*BCx + BAy*BCy;

                    double norm_BA = A.distance(B);
                    double norm_BC = C.distance(B);

                    if(norm_BA > 0 && norm_BC > 0) {
                        double cosValue = dotProduct / (norm_BA * norm_BC);
                        cosValue = Math.max(-1.0, Math.min(1.0, cosValue));
                        double angle = Math.acos(cosValue);

                        if(angle < Parameters.PI - parameters.EPSILON || angle > Parameters.PI + parameters.EPSILON) {
                            return true;
                        }
                    }
                }
            }
            i = i + 1;
        }
        return false;
    }

    public static Boolean lic10() {return false;}
    public static Boolean lic11() {return false;}
    public static Boolean lic12() {return false;}
    public static Boolean lic13() {return false;}
    public static Boolean lic14() {return false;}


}
