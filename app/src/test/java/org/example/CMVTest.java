package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CMVTest {
    
    @Test 
    void initialTest() {
        assertTrue(true);
    }
    
    /**
     * If {@code AREA1} is negative, lic3 should return false.
     */
    @Test
    void lic3_negativeAreaInput_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic3(points, -1.0));
    }

    /**
     * If less than three points in input, lic3 should return false.
     */
    @Test
    void lic3_lessThanThreePoints_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0)
        };

        assertFalse(CMV.lic3(points, 1));
    }

    /**
     * If two points are the same, lic3 should return false.
     */
    @Test
    void lic3_twoPointsAreTheSame_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(1, 0)
        };

        assertFalse(CMV.lic3(points, 1));
    }

    /**
     * If all points are on the same line, the area is zero and lic3 should return false.
     */
    @Test
    void lic3_allPointsOnSameLine_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 2)
        };

        assertFalse(CMV.lic3(points, 1));
    }

    /**
     * If area of triangle equal to {@code AREA1}, then the area isn't greater than {@code AREA1} and lic3 should fail.
     */
    @Test
    void lic3_triangleAreaEqualToAREA1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(2, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic3(points, 1));
    }

    /**
     * If three consecutive points form a triangle with and area larger than {@code AREA1}, lic3 should return true.
     */
    @Test
    void lic3_trianglAreaGreaterThanAREA1_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(4, 0),
            new Point(0, 2)
        };

        assertTrue(CMV.lic3(points, 1));
    }

    /**
     * If a triplet which satisfies the condition {@code area > AREA1} appears later in the point array, lic3 should return true.
     */
    @Test
    void lic3_laterTripletSatisfiesCondition_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 2), // First set are on the same line, thus area = 0
            new Point(2, 1)  // Second set forms triangle of area 0.5
        };

        assertTrue(CMV.lic3(points, 0.1));
    }

    /**
     * If multiple triangles can be formed out of the points but none satisfy the condition {@code area > AREA1}, lic3 should return false.
     */
    @Test
    void lic3_noTriangleWithAreaLargerThanAREA1Exists_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 1),
            new Point(1, 0),   // area = 0.5
            new Point(3, 0),   // area = 1
            new Point(3, 0.5)  // area = 0.5
        };

        assertFalse(CMV.lic3(points, 1));
    }

    /**
     * If {@code Q_PTS} is less than 2, lic4 should return false.
     */
    @Test
    void lic4_Q_PTSLessThanTwo_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(1, 1)
        };
        int Q_PTS = 1;
        int QUADS = 2;

        assertFalse(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return false when Q_PTS is less than 2");
    }
    
    /**
     * If {@code NUMPOINTS} is less than {@code Q_PTS}, lic4 should return false.
     */
    @Test
    void lic4_NUMPOINTSLessThanQ_PTS_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
        };
        int Q_PTS = 3;
        int QUADS = 2;

        assertFalse(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return false when NUMPOINTS is less than Q_PTS");
    }
    
    /**
     * If {@code QUADS} is less than one, lic4 should return false. 
     */
    @Test
    void lic4_QUADSLessThanOne_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(1, 1)
        };
        int Q_PTS = 3;
        int QUADS = 0;

        assertFalse(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return false when QUADS is less than one");
    }

    /**
     * If {@code QUADS} is higher than three, lic4 should return false.
     */
    @Test
    void lic4_QUADSHigherThanThree_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(1, 1)
        };
        int Q_PTS = 3;
        int QUADS = 4;

        assertFalse(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return false when QUADS is higher than three");
    }

    /**
     * If {@code Q_PTS} consecutive points lie in more than {@code QUADS} quadrants, lic4 should return true.
     */
    @Test
    void lic4_Q_PTSInMoreThanQUADSQuadrants_returnsTrue() {
        Point[] points = {
            new Point(1, 1),
            new Point(-1, 1),
        };
        int Q_PTS = 2;
        int QUADS = 1;

        assertTrue(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return true when there exists a set of Q_PTS consecutive points that lie in more than QUADS quadrants.");
    }   
    
    /**
     * If {@code Q_PTS} consecutive points lie in exactly {@code QUADS} quadrants, lic4 should return false.
     */
    @Test
    void lic4_Q_PTSInExactlyQUADSQuadrants_returnsFalse() {
        Point[] points = {
            new Point(1, 1),
            new Point(-1, 1),
        };
        int Q_PTS = 2;
        int QUADS = 2;

        assertFalse(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return false when the only set of Q_PTS consecutive points lie in exactly QUADS quadrants.");
    }   

    /**
     * If there does not exist a set of {@code Q_PTS} consecutive points that lie in more than {@code QUADS} quadrants, lic4 should return false.
     */
    @Test
    void lic4_noSetOfQ_PTSConsecutivePointsSatisfiesCondition_returnsFalse() {
        Point[] points = {
            new Point(1, 1),
            new Point(2, 2),
            new Point(-1, 1),
        };
        int Q_PTS = 2;
        int QUADS = 2;

        assertFalse(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return false if there does not exists a set of Q_PTS consecutive points that lie in more than QUADS quadrants.");
    }

    /**
     * If quadrant membership is ambiguous (points on axes),
     * lic4 should resolve the ambiguity using the priority rule (I -> II -> III -> IV)
     * and return true when {@code Q_PTS} points lie in more than {@code QUADS} quadrants.
     */
    @Test
    void lic4_positiveCaseWithAmbiguousQuadrants_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(-1, 0),
            new Point(0, -1),
            new Point(0, 1),
            new Point(1, 0)
        };
        int Q_PTS = points.length;
        int QUADS = 2;

        assertTrue(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return true when axis points are assigned using quadrant priority and Q_PTS consecutive points lie in more than QUADS quadrants.");
    }

    /**
     * If a set of {@code Q_PTS} consecutive points that lie in more than {@code QUADS} quadrants appears later in the array, lic4 should return true.
     */
    @Test
    void lic4_laterSetSatisfiesCondition_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3), // All are in quadrant I
            new Point(-1, 1)     // In quadrant II
        };
        int Q_PTS = 2;
        int QUADS = 1;

        assertTrue(CMV.lic4(points, Q_PTS, QUADS), "lic4 should return true if a set of Q_PTS consecutive points which lie in more than QUADS quadrants appears later in the point array.");
    }
  
    /**
     * Positive test: LIC5 should return true when x decreases between consecutive points.
     * lic5 should return true.
        * Test case: Points (3, 0) → (4, 2) → (1, 5) → (2, 1).
        * Expected: true because 1 < 4 between the second and third points.
     */
    void lic5_xDecreasesBetweenConsecutivePoints_returnsTrue() {
        Point[] points = {
            new Point(3, 0),
            new Point(4, 2),
            new Point(1, 5),
            new Point(2, 1)
        };
        assertTrue(CMV.lic5(points));
    }
    
    /**
     * Negative test: LIC5 should return false when x never decreases.
     * lic5 should return false.
    * Test case: Points (0, 0) → (1, 5) → (3, 2) → (3, 7).
    * Expected: false because x never decreases between consecutive points.
     */
    @Test 
    void lic5_xNeverDecreases_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 5),
            new Point(3, 2),
            new Point(3, 7)
        };
        assertFalse(CMV.lic5(points));
    }
    
    /**
     * Edge case test: LIC5 should return false when x stays equal (strict comparison).
     * lic5 should return false because the comparison is strict (< not <=).
    * Test case: Points (2, 1) → (2, 9) → (4, 3).
    * Expected: false because equal x values should not satisfy the strict comparison.
     */
    @Test 
    void lic5_xStaysEqualStrictComparison_returnsFalse() {
        Point[] points = {
            new Point(2, 1),
            new Point(2, 9), 
            new Point(4, 3)
        };
        assertFalse(CMV.lic5(points));
    }

    /**
     * Null input test: LIC5 should return false when points array is null.
     * Expected: false.
     */
    @Test
    void lic5_nullPoints_returnsFalse() {
        Point[] points = null;
        assertFalse(CMV.lic5(points));
    }

    /**
     * Too few points test: LIC5 should return false when array has fewer than two points.
     * Expected: false.
     */
    @Test
    void lic5_lessThanTwoPoints_returnsFalse() {
        Point[] points = { new Point(1, 1) };
        assertFalse(CMV.lic5(points));
    }
  
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

    @Test
    void lic14_negativeAREA2_returnsFalse() {
        Point[] points = {
            new Point(0, 5),
            new Point(1, 3),
            new Point(2, 0),
            new Point(3, 2),
            new Point(4, 0)
        };

        assertFalse(CMV.lic14(points, 1, 1, 1.0, -1.0));
    }

    @Test
    void lic14_lessThanFivePoints_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0)
        };

        assertFalse(CMV.lic14(points, 1, 1, 1.0, 2.0));
    }

    /**
     * Expected: true, because 0 intervening points is still valid
     * (points A and B are immediate neighbors)
     */
    @Test
    void lic14_invalidE_PTS_returnsTrue() {
        Point[] points = {
            new Point(0, 5),
            new Point(1, 3),
            new Point(2, 0),
            new Point(3, 2),
            new Point(4, 0)
        };

        assertTrue(CMV.lic14(points, 0, 1, 1.0, 2.0));
    }

    /**
     * Expected: true, because 0 intervening points is still valid
     * (points B and C are immediate neighbors)
     */
    @Test
    void lic14_F_PTSis0_returnsTrue() {
        Point[] points = {
            new Point(0, 5),
            new Point(1, 3),
            new Point(2, 0),
            new Point(3, 2),
            new Point(4, 0)
        };

        assertTrue(CMV.lic14(points, 1, 0, 1.0, 2.0));
    }

    @Test
    void lic14_E_PTSandF_PTStooLarge_returnsFalse() {
        Point[] points = {
            new Point(0, 5),
            new Point(1, 3),
            new Point(2, 0),
            new Point(3, 2),
            new Point(4, 0)
        };

        assertFalse(CMV.lic14(points, 3, 4, 1.0, 2.0));
    }

    /**
     * The area formed by the three points (0,0), (0,2), (4,0) should be
     * between 1.0 and 10.0.
     * Expected: true, because the true area is 4.
     */
    @Test
    void lic14_validBothConditions_returnsTrue() {
        Point[] points = {
            new Point(0, 0),   // A
            new Point(0, 0),
            new Point(0, 2),   // B
            new Point(0, 0),
            new Point(4, 0)    // C
        };

        assertTrue(CMV.lic14(points, 1, 1, 1.0, 10.0));
    }
    
    /**
     * All points are on the same line.
     * Expected: false, since the area is 0.
     */
    @Test
    void lic14_allPointsOnOneLine_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(4, 0)
        };

        assertFalse(CMV.lic14(points, 1, 1, 0.5, 2.0));
    }
}
