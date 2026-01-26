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

}
