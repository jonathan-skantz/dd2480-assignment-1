package org.example;

public class Decide {
    public String DECIDE(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, Connector[][] LCM, boolean[] PUV) {
        String LAUNCH = "NO";

        boolean[] cmv = CMV.computeCMV(POINTS, PARAMETERS);
        boolean[][] pum = PUM.computePUM(LCM, cmv);
    
        return LAUNCH;
    }
}

enum Connector {
    ANDD,
    ORR,
    NOTUSED
}