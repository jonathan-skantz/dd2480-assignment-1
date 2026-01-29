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
     * Negative test: lic12 should return false when NUMPOINTS < 3.
     * Expected: false, since points.length = 2 < 3.
     */
    @Test
    void lic12_lessThanThreePoints_returnsFalse() {
        Point[] points = {
                new Point(0,0),
                new Point(1, 0),
        };

        int K_PTS = 2;
        double LENGTH1 = 2.0;
        double LENGTH2 = 3.0;

        assertFalse(CMV.lic12(points, K_PTS, LENGTH1, LENGTH2));
    }

    /**
     * Positive test: lic12 returns true when both conditions met:
     * 1. Distance > LENGTH1 exists for some pair with K_PTS intervening points
     * 2. Distance < LENGTH2 exists for some pair with K_PTS intervening points
     * Expected: true, since condition 1 and 2 are met for points: (0, 1) and (0, 3.1)
     */
    @Test
    void lic12_conditionsMet_returnsTrue() {
        Point[] points = {
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 0),
                new Point(0, 3.1),
                new Point(3, 0),
                new Point(3,0),
                new Point(0,6.2)
        };
        int K_PTS = 2;
        double LENGTH1 = 2.0;
        double LENGTH2 = 3.0;

        assertTrue(CMV.lic12(points, K_PTS, LENGTH1, LENGTH2));
    }

    /**
     * Negative test: lic12 returns false when one condition fails.
     * Expected: false.
     */
    @Test
    void lic12_conditionsAreNotMet_returnsFalse() {
        Point[] points = {
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 0),
                new Point(0, 2),
                new Point(0, 0),
                new Point(0.1,0),
                new Point(0,2)
        };
        int K_PTS = 2;
        double LENGTH1 = 2.0;
        double LENGTH2 = 1.0;

        assertFalse(CMV.lic12(points, K_PTS, LENGTH1, LENGTH2));
    }


}
