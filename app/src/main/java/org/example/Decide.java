package org.example;

public class Decide {
    public String DECIDE(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, Connector[][] LCM, boolean[] PUV) {
        String LAUNCH = "NO";

        Boolean[] cmv = CMV.computeCMV(POINTS, PARAMETERS);
        boolean[][] pum = PUM.computePUM(LCM, PUV);
    
        return LAUNCH;
    }
}

enum Connector {
    ANDD,
    ORR,
    NOTUSED
}