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
    void lic10_enoughPoint_returnsFalse() {
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
