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
    void lic9_enoughPoint_returnsFalse() {
        Point[] points = {
                new Point(0,0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0)
        };

        int C_PTS = 1;
        int D_PTS = 1;
        double EPSILON = 0.1;

        assertFalse(CMV.lic9(points, C_PTS, D_PTS, EPSILON));
    }

    @Test
    void lic9_coincideWithVertex_returnsFalse() {
        Point[] points = {
                new Point(0,1),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(2, 0)
        };

        int C_PTS = 1;
        int D_PTS = 1;
        double EPSILON = 0;

        assertFalse(CMV.lic9(points, C_PTS, D_PTS, EPSILON));
    }

    @Test
    void lic9_ConditionsMet_returnsTrue() {
        Point[] points = {
                new Point(0,1),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(3, 0)
        };

        int C_PTS = 1;
        int D_PTS = 1;
        double EPSILON = 0;

        assertTrue(CMV.lic9(points, C_PTS, D_PTS, EPSILON));
    }


    @Test
    void lic9_conditionsMet2_returnsTrue() {
        Point[] points = {
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 0),
                new Point(1, 0),
                new Point(3, 0),
                new Point(3,0)
        };

        int C_PTS = 1;
        int D_PTS = 2;
        double EPSILON = 0.5;

        assertTrue(CMV.lic9(points, C_PTS, D_PTS, EPSILON));
    }
}
