package org.example;

public class Decide {
    public String DECIDE(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, Connector[][] LCM, boolean[] PUV) {

        assert NUMPOINTS >= 2 && NUMPOINTS <= 100 : "NUMPOINTS must be between 2 and 100";
        
        assert POINTS != null : "POINTS array can not be null";
        assert POINTS.length == NUMPOINTS : "POINTS length must be equal to NUMPOINTS";

        for (int i = 0; i < NUMPOINTS; i++) {
            assert POINTS[i] != null : "POINTS[i] cannot be null";
        }
        
     
        assert PARAMETERS != null : "PARAMETERS can not be null";

        assert LCM != null : "LCM cannot be null";
        assert LCM.length == 15 : "LCM must have 15 rows";
        
        for (int i = 0; i < 15; i++) {
            assert LCM[i] != null : "LCM row cannot be null";
            assert LCM[i].length == 15 : "Each LCM row must have 15 columns";
            
            for (int j = 0; j < 15; j++) {
                assert LCM[i][j] != null : "LCM connectors cannot be null";
            }
        }

        for (int i = 0; i < 15; i++) {
        for (int j = 0; j < 15; j++) {
        assert LCM[i][j] == LCM[j][i] : "LCM must be symmetric: LCM[i][j] != LCM[j][i]";
        }
    }

        assert PUV != null : "PUV cannot be null";
        assert PUV.length == 15 : "PUV must have length 15";



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