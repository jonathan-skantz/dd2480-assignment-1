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

    /**
     * Negative test: NUMPOINTS below valid range should trigger assertion.
     * NUMPOINTS = 1 (minimum is 2).
     * Expected: AssertionError thrown 1 < 2.
     */
    @Test
    void decide_numPointsTooSmall_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = lcmAllNotUsed();

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(1, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: NUMPOINTS above valid range should trigger assertion.
     * NUMPOINTS = 101 (maximum is 100).
     * Expected: AssertionError thrown 101 > 100.
     */
    @Test
    void decide_numPointsTooLarge_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = new Point[101];
        for (int i = 0; i < 101; i++) {
            points[i] = new Point(0, 0);
        }
        boolean[] puv = new boolean[15];
        Connector[][] lcm = lcmAllNotUsed();

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(101, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: Null POINTS array should trigger assertion.
     * POINTS = null.
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_pointsArrayNull_throwsAssertionError() {
        Decide decide = new Decide();

        boolean[] puv = new boolean[15];
        Connector[][] lcm = lcmAllNotUsed();

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, null, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: POINTS length mismatch should trigger assertion.
     * NUMPOINTS = 3 but POINTS.length = 2.
     * Expected: AssertionError thrown 3 != 2.
     */
    @Test
    void decide_pointsLengthMismatch_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = lcmAllNotUsed();

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(3, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: Null element in POINTS array should trigger assertion.
     * POINTS[1] = null.
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_pointElementNull_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), null, new Point(1,3) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = lcmAllNotUsed();

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(3, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: Null PARAMETERS should trigger assertion.
     * PARAMETERS = null.
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_parametersNull_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = lcmAllNotUsed();

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, null, lcm, puv);
        });
    }

    /**
     * Negative test: Null LCM matrix should trigger assertion.
     * LCM = null.
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_lcmNull_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[15];

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, paramsWithLength1(1.0), null, puv);
        });
    }

    /**
     * Negative test: LCM with incorrect row count should trigger assertion.
     * LCM has 14 rows (required to be 15).
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_lcmWrongRowCount_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = new Connector[14][15]; 

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: Null row in LCM matrix should trigger assertion.
     * LCM[0] = null.
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_lcmRowNull_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = new Connector[15][15];
        lcm[0] = null; 

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: LCM rows with incorrect column count should trigger assertion.
     * Each LCM row has 14 columns (required to be 15).
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_lcmWrongColumnCount_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = new Connector[15][];
        for (int i = 0; i < 15; i++) {
            lcm[i] = new Connector[14]; 
        }

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: Null element in LCM matrix should trigger assertion.
     * LCM[0][0] = null.
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_lcmElementNull_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = lcmAllNotUsed();
        lcm[0][0] = null;

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: None symmetric LCM matrix should trigger assertion.
     * LCM[0][1] = ANDD but LCM[1][0] = ORR (must be symmetric).
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_lcmNotSymmetrical_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[15];
        Connector[][] lcm = lcmAllNotUsed();
        lcm[0][1] = Connector.ANDD;
        lcm[1][0] = Connector.ORR; 

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, paramsWithLength1(1.0), lcm, puv);
        });
    }

    /**
     * Negative test: Null PUV array should trigger assertion.
     * PUV = null.
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_puvNull_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        Connector[][] lcm = lcmAllNotUsed();

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, paramsWithLength1(1.0), lcm, null);
        });
    }

    /**
     * Negative test: PUV with incorrect length should trigger assertion.
     * PUV.length = 14 (required to be 15).
     * Expected: AssertionError thrown.
     */
    @Test
    void decide_puvWrongLength_throwsAssertionError() {
        Decide decide = new Decide();

        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean[] puv = new boolean[14]; // Wrong length
        Connector[][] lcm = lcmAllNotUsed();

        assertThrows(AssertionError.class, () -> {
            decide.DECIDE(2, points, paramsWithLength1(1.0), lcm, puv);
        });
    }
}
