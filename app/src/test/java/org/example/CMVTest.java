package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CMVTest {
    
    // Just a placeholder test
    @Test 
    void initialTest() {
        assertTrue(true);
    }


    /**
     * Negative test: lic10 should return false when NUMPOINTS < 5.
     * Test case: 4 points.
     * Expected: false.
     */
    @Test
    void lic10_lessThanFivePoints_returnsFalse() {
        Point[] points = {
                new Point(0,0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0)
        };

        int E_PTS = 1;
        int F_PTS = 1;
        double AREA1 = 2.2;

        assertFalse(CMV.lic10(points, E_PTS, F_PTS, AREA1));
    }

    /**
     * Positive test: lic10 returns true when there exists three points separated by
     * exactly E_PTS and F_PTS intervening points forming triangle area > AREA1.
     * Test case: Points (0,0), (1,0), (3,0) with E_PTS=1, F_PTS=2.
     * Expected: true (area = 1.5 > 1.49).
     */
    @Test
    void lic10_conditionsMet_returnsTrue() {
        Point[] points = {
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 0),
                new Point(1, 0),
                new Point(3, 0),
                new Point(3,0)
        };

        int E_PTS = 1;
        int F_PTS = 2;
        double AREA1 = 1.49;

        assertTrue(CMV.lic10(points, E_PTS, F_PTS, AREA1));
    }

    /**
     * Negative test: lic10 returns false when no triangle area > AREA1 exists.
     * Test case: Same points as above but AREA1 larger.
     * Expected: false (area = 1.5 < 1.51).
     */
    @Test
    void lic10_conditionsAreNotMet_returnsFalse () {
        Point[] points = {
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 0),
                new Point(1, 0),
                new Point(3, 0),
                new Point(3,0)
        };

        int E_PTS = 1;
        int F_PTS = 2;
        double AREA1 = 1.51;

        assertFalse(CMV.lic10(points, E_PTS, F_PTS, AREA1));
    }
}
