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
     * If {@code RADIUS1} is negative, lic1 should return false.
     */
    @Test
    void lic1_negativeRadius_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic1(points, -1.0));
    }

    /**
     * If less than three points in input, lic1 should return false.
     */
    @Test
    void lic1_lessThanThreePoints_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0)
        };

        assertFalse(CMV.lic1(points, 1));
    }

    /**
     * If three consecutive points create an Obtuse/Right triangle that cannot fitt incide a cirecle with {@code RADIUS1}, lic1 should return true.
     */
    @Test
    void lic1_obtuseRightTriangleMinimumRadiusGreaterThanRADIUS1_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 4)
        };

        assertTrue(CMV.lic1(points, 2.0));
    }

    /**
     * If three consecutive points create an Obtuse/Right triangle that creates a minimum radius that is equal to {@code RADIUS1}, lic1 should return false.
     */
    @Test
    void lic1_obtuseRightTriangleMinimumRadiusEqualToRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 4)
        };

        assertFalse(CMV.lic1(points, 2.5));
    }

    /**
     * If three consecutive points create an Obtuse/Right triangle that can fitt incide a cirecle with {@code RADIUS1}, lic1 should return false.
     */
    @Test
    void lic1_obtuseRightTriangleMinimumRadiusSmallerThanRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 4)
        };

        assertFalse(CMV.lic1(points, 3.0));
    }

    /**
     * If three consecutive points create an acute triangle that cannot fitt incide a cirecle with {@code RADIUS1}, lic1 should return true.
     */
    @Test
    void lic1_acuteTriangleMinimumRadiusGreaterThanRADIUS1_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(2, 0),
            new Point(1, Math.sqrt(3))
        };

        assertTrue(CMV.lic1(points, 1.0));
    }

    /**
     * If three consecutive points create an acute triangle that creates a minimum radius that is equal to {@code RADIUS1}, lic1 should return false.
     */
    @Test
    void lic1_acuteTriangleMinimumRadiusEqualToRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(2, 0),
            new Point(1, Math.sqrt(3))
        };

        assertFalse(CMV.lic1(points, (2.0 / Math.sqrt(3))));
    }

    /**
     * If three consecutive points create an acute triangle that can fitt incide a cirecle with {@code RADIUS1}, lic1 should return false.
     */
    @Test
    void lic1_acuteTriangleMinimumRadiusSmallerThanRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(2, 0),
            new Point(1, Math.sqrt(3))
        };

        assertFalse(CMV.lic1(points, 1.3));
    }
   
}
