package org.example;


public class CMV {

    public static Boolean[] computeCMV(Point[] points, Parameters parameters) {
        Boolean[] cmv = new Boolean[15];

        cmv[0] = lic0(points, parameters.LENGTH1);
        cmv[1] = lic1(points, parameters.RADIUS1);
        cmv[2] = lic2(points, parameters.EPSILON);
        cmv[3] = lic3(points, parameters.AREA1);
        cmv[4] = lic4(points, parameters.Q_PTS, parameters.QUADS);
        cmv[5] = lic5(points);
        cmv[6] = lic6(points, parameters.N_PTS, parameters.DIST);
        cmv[7] = lic7(points, parameters.K_PTS, parameters.LENGTH1);
        cmv[8] = lic8(points, parameters.A_PTS, parameters.B_PTS, parameters.RADIUS1);
        cmv[9] = lic9(points, parameters.C_PTS, parameters.D_PTS, parameters.EPSILON);
        cmv[10] = lic10(points, parameters.E_PTS, parameters.F_PTS, parameters.AREA1);
        cmv[11] = lic11(points, parameters.G_PTS);
        cmv[12] = lic12(points, parameters.K_PTS, parameters.LENGTH1, parameters.LENGTH2);
        cmv[13] = lic13(points, parameters.A_PTS, parameters.B_PTS, parameters.RADIUS1, parameters.RADIUS2);
        cmv[14] = lic14(points, parameters.E_PTS, parameters.F_PTS, parameters.AREA1, parameters.AREA2);

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
    public static Boolean lic13() {return false;}
    public static Boolean lic14() {return false;}


}
