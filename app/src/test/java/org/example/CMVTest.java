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
     * If the longest distance between two points in a set of three is 2, {@code minEnclosingRadius} should return 1;
     */
    @Test
    void minEnclosingRadius_longestDistanceIs2_returns1() {
        Point A = new Point(0, 0);
        Point B = new Point(0, 2); // Distance AB is 2
        Point C = new Point(1, 1);

        assertEquals(1.0, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return 1 when the longest side is 2.");
    }

    /**
     * If all points are the same, {@code minEnclosingRadius} should return 0.
     */
    @Test
    void minEnclosingRadius_allPointsAreTheSame_returnsZero(){
        Point A = new Point(0, 0);
        Point B = new Point(0, 0);
        Point C = new Point(0, 0);

        assertEquals(0.0, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return 0 when all points are the same.");
    }

    /**
     * If two points are the same, {@code minEnclosingRadius} should return half the length of the longest distance.
     */
    @Test
    void minEnclosingRadius_twoPointsAreTheSame_returnsHalfOfLongestDistance() {
        Point A = new Point(0, 0);
        Point B = new Point(0, 0);
        Point C = new Point(2, 0);

        assertEquals(1, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return half the length of the longest distance when two points are the same.");
    }

    /**
     * If the three points form a right angle triangle, the function should return half of the longest distance.
     */
    @Test
    void minEnclosingRadius_triangleIsRight_returnsHalfLongestDistance() {
        Point A = new Point(0, 0);
        Point B = new Point(1, 0);
        Point C = new Point(0, 1);

        double expected = Math.sqrt(1 * 1 + 1 * 1) / 2;

        assertEquals(expected, Point.minEnclosingRadius(A, B, C), 1e-9, "Right triangle should return half the longest side (hypotenuse).");
    }


    /**
     * If the three points form an obtuse triangle, the function should return half of the longest distance.
     */
    @Test
    void minEnclosingRadius_triangleIsObtuse_returnsHalfLongestDistance() {
        Point A = new Point(0, 0);
        Point B = new Point(4, 0);
        Point C = new Point(1, 1);

        assertEquals(2.0, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return half the length of the longest distance when the triangle is obtuse.");
    }

    /**
     * If the three points form an acute triangle, the function should return the radius of its circumcircle.
     */
    @Test
    void minEnclosingRadius_triangleIsAcute_returnsRadiusOfCircumcircle() {
        Point A = new Point(0, 0);
        Point B = new Point(2, 0);
        Point C = new Point(1, Math.sqrt(3));

        double a = 2.0;
        double b = 2.0;
        double c = 2.0;

        double area = (Math.sqrt(3) / 4.0) * a * a;

        double expected = (a * b * c) / (4.0 * area);

        assertEquals(expected, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return radius of the circumcircle of the triangle created by the three points when the triangle is acute.");
    }

    /**
     * If {@code NUMPOINTS} is less than five, lic13 should return false.
     */
    @Test
    void lic13_NUMPOINTSLessThanFive_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0)
        };

        int A_PTS = 1;
        int B_PTS = 1;
        double RADIUS1 = 1.0;
        double RADIUS2 = 1.0;

        assertFalse(CMV.lic13(points, A_PTS, B_PTS, RADIUS1, RADIUS2), "lic13 should return false if NUMPOINTS is less than 5.");
    }

    /**
     * If {@code RADIUS2} is less than zero, lic13 should return false.
     */
    @Test
    void lic13_RADIUS2LessThanZero_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(4, 0)
        };

        int A_PTS = 1;
        int B_PTS = 1;
        double RADIUS1 = 1.0;
        double RADIUS2 = -1.0;

        assertFalse(CMV.lic13(points, A_PTS, B_PTS, RADIUS1, RADIUS2), "lic13 should return false if RADIUS2 is less than 0.");
    }

    /**
     * If all triplets can be contained within a circle of radius {@code RADIUS1}, lic13 ahould return false.
     */
    @Test
    void lic13_allTripletsContainedWithinRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(-1, 0),
            new Point(0, 1),
            new Point(0, -1)
        };

        int A_PTS = 1;
        int B_PTS = 1;
        double RADIUS1 = 2.0;
        double RADIUS2 = 2.0;

        assertFalse(CMV.lic13(points, A_PTS, B_PTS, RADIUS1, RADIUS2), "lic13 should return false if all triplets are within a circle of radius RADIUS1.");
    }

    /**
     * If no triplets can be contained within a circle of radius {@code RADIUS2}, lic13 should return false.
     */
    @Test
    void lic13_noTripletsContainedWithinRADIUS2_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(4, 0),
            new Point(-4, 0),
            new Point(0, 4),
            new Point(0, -4)
        };

        int A_PTS = 1;
        int B_PTS = 1;
        double RADIUS1 = 1.0;
        double RADIUS2 = 1.0;

        assertFalse(CMV.lic13(points, A_PTS, B_PTS, RADIUS1, RADIUS2), "lic13 should return false if no triplet are within a circle of radius RADIUS2.");
    }

    /**
     * If a triplet which can not be contained by {@code RADIUS1} exists and a triplet which can be contained by {@code RADIUS2} exists, lic13 should return true.
     */
    @Test
    void lic13_notWithinRADIUS1ExistsAndWithinRADIUS2Exists_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(2, 0),
            new Point(4, 0),
            new Point(-2, 0),
            new Point(0, -4)
        };

        int A_PTS = 1;
        int B_PTS = 1;
        double RADIUS1 = 1.0;
        double RADIUS2 = 4.0;

        assertTrue(CMV.lic13(points, A_PTS, B_PTS, RADIUS1, RADIUS2), "lic13 should return true if there exists a triplet which can not be contained by RADIUS1 and a triplet exists whihc can be contained by RADIUS2.");
    }
}
