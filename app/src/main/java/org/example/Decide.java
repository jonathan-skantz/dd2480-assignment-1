package org.example;

public class Decide {
    public String DECIDE(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, Connector[][] LCM, boolean[] PUV) {
        boolean[] cmv = CMV.computeCMV(POINTS, PARAMETERS);
        boolean[][] pum = PUM.computePUM(LCM, cmv);
        boolean[] fuv = FUV.computeFUV(PUV, pum);
    
        return FUV.isAllTrue(fuv) ? "YES" : "NO";
    }
}

enum Connector {
    ANDD,
    ORR,
    NOTUSED
}