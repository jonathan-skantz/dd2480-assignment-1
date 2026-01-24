package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CMVTest {

    /**
     * Positive test: LIC7 should return true when a pair separated by K_PTS has distance greater than LENGTH1.
     * lic7 should return true.
     * Test case: Points (0, 0), (0, 0), (3, 0) with K_PTS=1, LENGTH1=2.0.
     * Expected: true (because distance 3 > 2).
     */
    @Test
    void lic7_pairExceedsLength_returnsTrue() {
        Point[] points = new Point[] {new Point(0, 0), new Point(0, 0), new Point(3, 0)};

        assertTrue(CMV.lic7(points, 1, 2.0));
    }

    /**
     * Negative test: LIC7 should return false when distance exactly equals LENGTH1.
     * lic7 should return false.
     * Test case: Points (0, 0), (0, 0), (3, 0) with K_PTS = 1, LENGTH1 = 3.
     * Expected: false (because distance 3 is not > 3).
     */
    @Test
    void lic7_distanceEqualsLength_returnsFalse() {
        Point[] points = new Point[] {new Point(0, 0), new Point(0, 0), new Point(3, 0)};

        assertFalse(CMV.lic7(points, 1, 3.0));
    }

    /**
     * Defensive test: LIC7 should return false when points array is null.
     * lic7 should return false.
     * Test case: points = null.
     * Expected: false (invalid input).
     */
    @Test
    void lic7_nullPoints_returnsFalse() {
        assertFalse(CMV.lic7(null, 1, 1.0));
    }

    /**
     * Defensive test: LIC7 should return false when there are fewer than three points.
     * lic7 should return false.
     * Test case: 2 points with K_PTS = 1.
     * Expected: false (insufficient points for any valid pair).
     */
    @Test
    void lic7_tooFewPoints_returnsFalse() {
        Point[] points = new Point[] {new Point(0, 0), new Point(1, 0)};

        assertFalse(CMV.lic7(points, 1, 1.0));
    }

    /**
     * Defensive test: LIC7 should return false when K_PTS is outside the valid range.
     * lic7 should return false.
     * Test case: 3 points with K_PTS = 0.
     * Expected: false (K_PTS must be >= 1).
     */
    @Test
    void lic7_invalidKpts_returnsFalse() {
        Point[] points = new Point[] {new Point(0, 0), new Point(1, 0), new Point(2, 0)};

        assertFalse(CMV.lic7(points, 0, 1.0));
    }

    /**
     * Defensive test: LIC7 should return false when K_PTS is too large.
     * lic7 should return false.
     * Test case: 3 points with K_PTS = 2.
     * Expected: false (K_PTS must be <= NUMPOINTS - 2, so <= 1 for 3 points).
     */
    @Test
    void lic7_kptsTooLarge_returnsFalse() {
        Point[] points = new Point[] {new Point(0, 0), new Point(1, 0), new Point(2, 0)};

        assertFalse(CMV.lic7(points, 2, 1.0));
    }

    /**
     * Defensive test: LIC7 should return false when LENGTH1 is negative.
     * lic7 should return false.
     * Test case: LENGTH1 = -1.
     * Expected: false (LENGTH1 must be >= 0).
     */
    @Test
    void lic7_negativeLength_returnsFalse() {
        Point[] points = new Point[] {new Point(0, 0), new Point(0, 0), new Point(3, 0)};

        assertFalse(CMV.lic7(points, 1, -1.0));
    }
}
