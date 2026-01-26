package org.example;


public class CMV {

    public static Boolean[] computeCMV(Point[] points, Parameters parameters) {
        Boolean[] cmv = new Boolean[15];

        cmv[0] = lic0();
        cmv[1] = lic1(points, parameters.RADIUS1);
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
        cmv[13] = lic13();
        cmv[14] = lic14();

        return cmv;
    }

    public static Boolean lic0() {return false;}

    public static Boolean lic1(Point[] points, double radius1) {

        // No need to check if there are no trio of points
        if (radius1 < 0) return false;
        if (points.length < 3) return false; 

        for (int i = 0; i < points.length - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            Point p3 = points[i + 2];

            double d1 = p1.distance(p2);
            double d2 = p2.distance(p3);
            double d3 = p3.distance(p1);

            double[] arr = {d1, d2, d3};
            double minRadius;
            Arrays.sort(arr);

            if (Math.pow(arr[2], 2) >= Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) {
                // Obtuse/Right triangle
                minRadius = arr[2] / 2;
            } else {
                // Acute triangle
                double s = (d1 + d2 + d3) / 2;
                double area = Math.sqrt(s*(s-d1)*(s-d2)*(s-d3));
                minRadius = (d1 * d2 * d3) / (4 * area);
            }

            if (minRadius > radius1) return true; 
        }

        return false; // No trio that fits the requirements found
    }

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
