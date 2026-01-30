package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {

    /**
     * Helper: Creates a 15x15 LCM filled with NOTUSED.
     * This makes every PUM[i][j] = true, meaning the LCM cannot block launch.
     */
    private static Connector[][] lcmAllNotUsed() {
        Connector[][] lcm = new Connector[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                lcm[i][j] = Connector.NOTUSED;
            }
        }
        return lcm;
    }

    /**
     * Helper: Creates a Parameters object with only LENGTH1 set meaningfully.
     */
    private static Parameters paramsWithLength1(double length1) {
        return new Parameters(
                length1, 
                0.0,     
                0.0,     
                0.0,    
                2,       
                1,      
                3,       
                0.0,     
                1,       
                1,     
                1,        
                1,        
                1,       
                1,     
                1,       
                1,      
                0.0,     
                0.0,    
                0.0     
        );
    }

    /**
     * If all PUV entries are false, then no LIC is considered.
     * Therefore every FUV[i] must be true, and DECIDE must return "YES" regardless of CMV/LCM.
     */
    @Test
    void decide_allPUVFalse_returnsYES() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(0, 0) };
        boolean[] puv = new boolean[15]; 
        Connector[][] lcm = lcmAllNotUsed();

        String launch = decide.DECIDE(points.length, points, paramsWithLength1(999.0), lcm, puv);
        assertEquals("YES", launch);
    }

    /**
     * If PUV[0] is true and LCM is all NOTUSED,
     * then PUM row 0 is all true, so FUV[0] is true.
     * With all other PUV false, DECIDE must return "YES".
     */
    @Test
    void decide_puv0TrueAndLCMNotUsed_returnsYES() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(3, 0) };
        Parameters params = paramsWithLength1(2.0);

        boolean[] puv = new boolean[15];
        puv[0] = true;

        String launch = decide.DECIDE(points.length, points, params, lcmAllNotUsed(), puv);
        assertEquals("YES", launch);
    }

    /**
     * ANDD can block launch.
     * Set PUV[0] = true so LIC0 is considered.
     * Make LCM[0][1] = ANDD.
     * 
     * If CMV[0] is true, then PUM[0][1] = (true && false) = false.
     * That makes FUV[0] false -> DECIDE must return "NO".
     */
    @Test
    void decide_anddConnectorBlocksLaunch_returnsNO() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(3, 0) };
        Parameters params = paramsWithLength1(2.0); // CMV[0] true

        boolean[] puv = new boolean[15];
        puv[0] = true;

        Connector[][] lcm = lcmAllNotUsed();
        lcm[0][1] = Connector.ANDD;
        lcm[1][0] = Connector.ANDD;

        String launch = decide.DECIDE(points.length, points, params, lcm, puv);
        assertEquals("NO", launch);
    }
}
