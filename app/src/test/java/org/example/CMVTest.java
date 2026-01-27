package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CMVTest {
    
    @Test 
    void initialTest() {
        assertTrue(true);
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

}
