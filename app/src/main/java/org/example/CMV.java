package org.example;


public class CMV {

    public static Boolean[] computeCMV(Point[] points, Parameters parameters) {
        Boolean[] cmv = new Boolean[15];

        cmv[0] = lic0();
        cmv[1] = lic1();
        cmv[2] = lic2(points, parameters.EPSILON, PI);
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
    public static Boolean lic1() {return false;}

    /**
     * There exists at least one set of three consecutive data points which form an angle such that:
     * angle < (PI − EPSILON) or angle > (PI + EPSILON)
     * The second of the three consecutive points is always the vertex of the angle. If either the first
     * point or the last point (or both) coincides with the vertex, the angle is undefined and the LIC
     * is not satisfied by those three points.
     * 
     * @param points the data points (coordinates)
     * @param EPSILON Deviation from PI
     * @param PI pi as specified by the excercise 
     * @return {@code true} if such a set of three consecutive points exists, {@code false} otherwise
     */
    public static boolean lic2(Point[] points, double EPSILON, double PI) {
        if(EPSILON < 0 || EPSILON >= PI) return false; // Since (0 ≤ EPSILON < PI) should hold
        if(points.length < 3) return false;

        // Iteratively check sets of three consequtive points
        for(int i = 0; i < points.length - 2; i++) {
            Point A = points[i];
            Point B = points[i + 1]; // Vertex of the angle
            Point C = points[i + 2];
            
            // Create vectors
            // Vector from B to A
            double v1x = A.x - B.x;
            double v1y = A.y - B.y;

            // Vector from B to C
            double v2x = C.x - B.x;
            double v2y = C.y - B.y;

            // Check if angle is undefined
            if(B.areTheSame(A) || B.areTheSame(C)) continue;
            
            double dotProduct = (v1x * v2x) + (v1y * v2y);
            double magnitudeV1 = Math.sqrt(Math.pow(v1x, 2) + Math.pow(v1y, 2));
            double magnitudeV2 = Math.sqrt(Math.pow(v2x, 2) + Math.pow(v2y, 2));
            double angle = Math.acos(dotProduct / (magnitudeV1 * magnitudeV2)); // Angle in radians

            if (angle < (PI - EPSILON) || angle > (PI + EPSILON)) return true;

        }

        return false; // No such trio of points excist
    }

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
