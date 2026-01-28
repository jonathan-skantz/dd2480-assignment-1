package org.example;

public class Decide {
    public String DECIDE(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, Connector[][] LCM, boolean[] PUV) {
        String LAUNCH = "NO";

        boolean[] cmv = CMV.computeCMV(POINTS, PARAMETERS);
        boolean[][] pum = PUM.computePUM(LCM, cmv);
        boolean[] fuv = FUV.computeFUV(PUV, pum);
    
        if(FUV.isAllTrue(fuv)) return "YES";
        return LAUNCH;
    }
}

enum Connector {
    ANDD,
    ORR,
    NOTUSED
}