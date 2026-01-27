package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CMVTest {
    
    // Just a placeholder test
    @Test 
    void initialTest() {
        assertTrue(true);
    }

    @Test
    void lic12_enoughPoint_returnsFalse() {
        Point[] points = {
                new Point(0,0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0)
        };

        int K_PTS = 2;
        double LENGTH1 = 2.0;
        double LENGTH2 = 3.0;

        assertFalse(CMV.lic12(points, K_PTS, LENGTH1, LENGTH2));
    }

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

    @Test
    void lic12_conditionsMet2_returnsTrue() {
        Point[] points = {
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 0),
                new Point(0, 3.1),
                new Point(3, 0),
                new Point(0.1,0),
                new Point(0,6.2)
        };
        int K_PTS = 2;
        double LENGTH1 = 2.0;
        double LENGTH2 = 1.0;

        assertTrue(CMV.lic12(points, K_PTS, LENGTH1, LENGTH2));
    }


}
