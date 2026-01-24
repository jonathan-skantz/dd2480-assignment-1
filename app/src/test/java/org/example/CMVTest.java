package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CMVTest {

    /**
     * Positive test: LIC11 should return true when x decreases across the correct gap.
     * G_PTS = 1; check pair (0, 2).
     * Points: (5, 0) → (9, 0) → (3, 0).
     * Expected: true because 3 < 5.
     */
    @Test
    void lic11_xDecreasesWithExactGap_returnsTrue() {
        Point[] points = {
            new Point(5, 0),
            new Point(9, 0),
            new Point(3, 0)
        };

        int G_PTS = 1;

        assertTrue(CMV.lic11(points, G_PTS));
    }

    /**
     * Negative test: LIC11 should return false when no decrease occurs across the gap.
     * G_PTS = 1; check pair (0, 2).
     * Points: (1, 0) → (2, 0) → (3, 0).
     * Expected: false because 3 is not < 1.
     */
    @Test
    void lic11_noDecreaseWithExactGap_returnsFalse() {
        Point[] points = {
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0)
        };

        int G_PTS = 1;

        assertFalse(CMV.lic11(points, G_PTS));
    }

    /**
     * Edge case test: LIC11 uses a strict comparison equal x-values should be false.
     * G_PTS = 1; check pair (0, 2).
     * Points: (4, 0) → (9, 0) → (4, 0).
     * Expected: false because 4 is not < 4.
     */
    @Test
    void lic11_strictComparisonEqualX_returnsFalse() {
        Point[] points = {
            new Point(4, 0),
            new Point(9, 0),
            new Point(4, 0)
        };

        int G_PTS = 1;

        assertFalse(CMV.lic11(points, G_PTS));
    }

    /**
     * Base case test: LIC11 should return false when fewer than three points are provided.
     * Points array length = 2.
     * Expected: false.
     */
    @Test
    void lic11_tooFewPoints_returnsFalse() {
        Point[] points = {
            new Point(1, 0),
            new Point(0, 0)
        };

        int G_PTS = 1;

        assertFalse(CMV.lic11(points, G_PTS));
    }

    /**
     * Off by one guard: ensure we require exactly G_PTS intervening points.
     * G_PTS = 1; correct pair is (0, 2).
     * Points: (5, 0) → (3, 0) → (5, 0).
     * Expected: false because 5 is not < 5 at the required gap, even though
     *            points[1].x < points[0].x would be true for the wrong gap.
     */
    @Test
    void lic11_offByOneGuard_exactGapRequired_returnsFalse() {
        Point[] points = {
            new Point(5, 0),
            new Point(3, 0),
            new Point(5, 0)
        };

        int G_PTS = 1;

        assertFalse(CMV.lic11(points, G_PTS));
    }

    /**
     * Null input test: LIC11 should return false when points array is null.
     * Expected: false.
     */
    @Test
    void lic11_nullPoints_returnsFalse() {
        Point[] points = null;

        int G_PTS = 1;

        assertFalse(CMV.lic11(points, G_PTS));
    }

    /**
     * Positive test: LIC11 should return true for an even larger gap and data set.
     * G_PTS = 3; check pair (0, 4).
     * Points: (12, 0) → (11, 0) → (10, 0) → (9, 0) → (1, 0).
     * Expected: true because 1 < 12 with exactly three intervening points.
     */
    @Test
    void lic11_xDecreasesWithLargerGap_returnsTrue() {
        Point[] points = {
            new Point(12, 0),
            new Point(11, 0),
            new Point(10, 0),
            new Point(9, 0),
            new Point(1, 0)
        };

        int G_PTS = 3;

        assertTrue(CMV.lic11(points, G_PTS));
    }

    /**
     * Invalid G_PTS test: LIC11 should return false when G_PTS is less than 1.
     * G_PTS = 0; violates the constraint 1 ≤ G_PTS.
     * Points: (5, 0) → (3, 0) → (1, 0).
     * Expected: false.
     */
    @Test
    void lic11_invalidG_PTSBelowMin_returnsFalse() {
        Point[] points = {
            new Point(5, 0),
            new Point(3, 0),
            new Point(1, 0)
        };

        int G_PTS = 0;

        assertFalse(CMV.lic11(points, G_PTS));
    }

    /**
     * Invalid G_PTS test: LIC11 should return false when G_PTS exceeds NUMPOINTS - 2.
     * G_PTS = 5; violates the constraint G_PTS ≤ NUMPOINTS - 2 (3 - 2 = 1).
     * Points: (5, 0) → (9, 0) → (3, 0).
     * Expected: false.
     */
    @Test
    void lic11_invalidG_PTSAboveMax_returnsFalse() {
        Point[] points = {
            new Point(5, 0),
            new Point(9, 0),
            new Point(3, 0)
        };

        int G_PTS = 5;

        assertFalse(CMV.lic11(points, G_PTS));
    }
}
