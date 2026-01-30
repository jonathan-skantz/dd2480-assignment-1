package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CMVTest {
    
    @Test 
    void initialTest() {
        assertTrue(true);
    }        

    @Test
    void lic0_noConsecutivePointsSeparatedByMoreThanLENGTH1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(5, 0),
            new Point(10, 0)
        };

        double LENGTH1 = 5;

        assertFalse(CMV.lic0(points, LENGTH1));
    }

    @Test
    void lic0_twoConsecutivePointsSeparatedByMoreThanLENGTH1_returnsTrue() {
        Point[] points = {
            new Point(5, 0),
            new Point(0, 0),
            new Point(10, 0)
        };

        double LENGTH1 = 5;

        assertTrue(CMV.lic0(points, LENGTH1));
    }

    @Test
    void lic0_emptyInput_returnsFalse() {
        Point[] points = {};
        double len = 5;
        assertFalse(CMV.lic0(points, len));
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

    
    /**
     * If {@code EPSILON} is negative, lic1 should return false.
     */
    @Test
    void lic2_negativeEPSILON_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic2(points, -1.0, Parameters.PI));
    }

    /**
     * If {@code EPSILON} is larger than {@code PI}, lic1 should return false.
     */
    @Test
    void lic2_EPSILONBiggerThanPI_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic2(points, 4.0, Parameters.PI));
    }

    /**
     * If less than three points in input, lic2 should return false.
     */
    @Test
    void lic2_lessThanThreePoints_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0)
        };

        assertFalse(CMV.lic2(points, 1, Parameters.PI));
    }

    /**
     * If the first point coincides with the vertex, lic2 should return false.
     */
    @Test
    void lic2_firstPointEqualToVertex_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(1, 0)
        };

        assertFalse(CMV.lic2(points, 1, Parameters.PI));
    }

    /**
     * If the last point coincides with the vertex, lic2 should return false.
     */
    @Test
    void lic2_lastPointEqualToVertex_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(1, 0)
        };

        assertFalse(CMV.lic2(points, 1, Parameters.PI));
    }

    /**
     * If both other points coincides with the vertex, lic2 should return false.
     */
    @Test
    void lic2_bothPointsEqualToVertex_returnsFalse() {
        Point[] points = {
            new Point(1, 0),
            new Point(1, 0),
            new Point(1, 0)
        };

        assertFalse(CMV.lic2(points, 1, Parameters.PI));
    }

    /**
     * If angle < {@code (PI − EPSILON)}, lic2 should return true.
     */
    @Test
    void lic2_angleSmall_returnsTrue() {
        Point[] points = {
            new Point(1, 0),
            new Point(0, 0),
            new Point(0, 1)
        };
        
        assertTrue(CMV.lic2(points, 0.5, Parameters.PI));
    }

    /**
     * If angle > {@code (PI + EPSILON)}, lic2 should return true.
     */
    @Test
    void lic2_angleLarge_returnsTrue() {
        Point[] points = {
            new Point(-1, -0.01),
            new Point(0, 0), 
            new Point(1, -0.01)
        };

        assertTrue(CMV.lic2(points, 0.0, Parameters.PI));
    }

    /**
     * Negative test: If {@code AREA1} is negative, lic3 should return false.
     * Test case: Points (0, 0) → (1, 0) → (0, 1).
     * Expected: false, since area -1.0 is input to lic3.
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
     * Negative test: If less than three points in input, lic3 should return false.
     * Test case: Points (0, 0) → (1, 0)
     * Expected: false, since there are only two points and {@code 2 < 3}
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
     * Negative test: If two points are the same, lic3 should return false.
     * Test case: (0, 0) → (0, 0) → (1, 0)
     * Expected: false, since two the first two points are the same, thus the three points cannot form a triangle with {@code area > AREA1}.
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
     * Negative case: If all points are on the same line, the area is zero and lic3 should return false.
     * Test case: (0, 0) → (1, 1) → (2, 2)
     * Expected: false, since all points lie on the same line and can therefore not form a triangle with {@code area > AREA1}.
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
     * Negative case: If area of triangle equal to {@code AREA1}, then the area isn't greater than {@code AREA1} and lic3 should fail.
     * Test case: (0, 0) → (2, 0) → (0, 1)
     * Expected: false, since the area is equal to {@code AREA1}, and thus {@code area !> AREA1}.
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
     * Positive case: If three consecutive points form a triangle with and area larger than {@code AREA1}, lic3 should return true.
     * Test case: (0, 0) → (4, 0) → (0, 2)
     * Expected: true, since {@code area > AREA1}.
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
     * Positive test: If a triplet which satisfies the condition {@code area > AREA1} appears later in the point array, lic3 should return true.
     * Test case: (0, 0) → (1, 1) → (2, 2) → (2, 1)
     * Expected: true, since the last triplet satisfies the coondition area > 
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
     * Negative case: If multiple triangles can be formed out of the points but none satisfy the condition {@code area > AREA1}, lic3 should return false.
     * Test case: (0, 0) → (1, 1) → (1, 0) → (3, 0) → (3, 0.5)
     * Expected: false, since none of the triplets form an area greater than {@code AREA1}.
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

    /**
     * Defensive test: LIC8 should return false when RADIUS1 is negative.
     * lic8 should return false.
     * Test case: Points (0,0), (1,0), (0,0), (1,0), (0,1) with A_PTS = 1, B_PTS = 1, RADIUS1 = -1.0.
     * Expected: false (invalid radius).
     */
    @Test
    void lic8_negativeRadius_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic8(points, 1, 1, -1.0));
    }

    /**
     * Defensive test: LIC8 should return false when fewer than five points are provided.
     * lic8 should return false.
     * Test case: Points (0,0), (1,0), (0,1), (1,1) with A_PTS = 1, B_PTS = 1, RADIUS1 = 1.0.
     * Expected: false (not enough points to evaluate LIC8).
     */
    @Test
    void lic8_lessThanFivePoints_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1),
            new Point(1, 1)
        };

        assertFalse(CMV.lic8(points, 1, 1, 1.0));
    }

    /**
     * Defensive test: LIC8 should return false when A_PTS is less than 1.
     * lic8 should return false.
     * Test case: Points (0,0), (1,0), (0,0), (1,0), (0,1) with A_PTS = 0, B_PTS = 1, RADIUS1 = 1.0.
     * Expected: false (invalid A_PTS).
     */
    @Test
    void lic8_aPTSLessThanOne_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic8(points, 0, 1, 1.0));
    }

    /**
     * Defensive test: LIC8 should return false when B_PTS is less than 1.
     * lic8 should return false.
     * Test case: Points (0,0), (1,0), (0,0), (1,0), (0,1) with A_PTS = 1, B_PTS = 0, RADIUS1 = 1.0.
     * Expected: false (invalid B_PTS).
     */
    @Test
    void lic8_bPTSLessThanOne_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic8(points, 1, 0, 1.0));
    }

    /**
     * Defensive test: LIC8 should return false when A_PTS + B_PTS equals (NUMPOINTS − 3).
     * lic8 should return false.
     * Test case: Five points with A_PTS = 1, B_PTS = 1, RADIUS1 = 1.0.
     * Expected: false (no valid triplet of points satisfies the separation constraint).
     */
    @Test
    void lic8_aPTSPlusBPTSEqualToNUMPOINTSMinusThree_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };

        assertFalse(CMV.lic8(points, 1, 1, 1.0));
    }

    /**
     * Defensive test: LIC8 should return false when (NUMPOINTS − 3) is less than A_PTS + B_PTS.
     * lic8 should return false.
     * Test case: Points (0,0), (1,0), (0,0), (0,1), (2,0) with A_PTS = 2, B_PTS = 2, RADIUS1 = 1.0.
     * Expected: false (invalid separation between points).
     */
    @Test
    void lic8_aPTSPlusBPTSBiggerThanNUMPOINTSMinusThree_returnsFalse() {

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(0, 1),
            new Point(2, 0)
        };

        assertFalse(CMV.lic8(points, 2, 2, 1.0));
    }

    /**
     * Positive test: LIC8 should return true when three points separated by A_PTS and B_PTS
     * form an obtuse/right triangle that cannot be enclosed by a circle with radius RADIUS1.
     * lic8 should return true.
     * Test case: Points (0,0), (0,0), (3,0), (0,0), (0,4) with A_PTS = 1, B_PTS = 1, RADIUS1 = 2.0.
     * Expected: true (minimum enclosing circle radius is 2.5 > 2.0).
     */
    @Test
    void lic8_obtuseRightTriangleMinimumRadiusGreaterThanRADIUS1_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 0),
            new Point(0, 4)
        };

        assertTrue(CMV.lic8(points, 1, 1, 2.0));
    }

    /**
     * Negative test: LIC8 should return false when the minimum enclosing circle radius
     * of an obtuse/right triangle equals RADIUS1.
     * lic8 should return false.
     * Test case: Points (0,0), (0,0), (3,0), (0,0), (0,4) with A_PTS = 1, B_PTS = 1, RADIUS1 = 2.5.
     * Expected: false (minimum radius equals RADIUS1).
     */
    @Test
    void lic8_obtuseRightTriangleMinimumRadiusEqualToRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 0),
            new Point(0, 4)
        };

        assertFalse(CMV.lic8(points, 1, 1, 2.5));
    }

    /**
     * Negative test: LIC8 should return false when an obtuse/right triangle
     * can be enclosed by a circle with radius RADIUS1.
     * lic8 should return false.
     * Test case: Points (0,0), (0,0), (3,0), (0,0), (0,4) with A_PTS = 1, B_PTS = 1, RADIUS1 = 3.0.
     * Expected: false (minimum radius 2.5 < 3.0).
     */
    @Test
    void lic8_obtuseRightTriangleMinimumRadiusSmallerThanRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 0),
            new Point(0, 4)
        };

        assertFalse(CMV.lic8(points, 1, 1, 3.0));
    }

    /**
     * Positive test: LIC8 should return true when three points separated by A_PTS and B_PTS
     * form an acute triangle that cannot be enclosed by a circle with radius RADIUS1.
     * lic8 should return true.
     * Test case: Points (0,0), (0,0), (2,0), (0,0), (1, √3) with A_PTS = 1, B_PTS = 1, RADIUS1 = 1.0.
     * Expected: true (minimum enclosing circle radius ≈ 1.155 > 1.0).
     */
    @Test
    void lic8_acuteTriangleMinimumRadiusGreaterThanRADIUS1_returnsTrue() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(2, 0),
            new Point(0, 0),
            new Point(1, Math.sqrt(3))
        };

        assertTrue(CMV.lic8(points, 1, 1, 1.0));
    }

    /**
     * Negative test: LIC8 should return false when the minimum enclosing circle
     * radius of an acute triangle equals RADIUS1.
     * lic8 should return false.
     * Test case: Points (0,0), (0,0), (2,0), (0,0), (1, √3) with A_PTS = 1, B_PTS = 1,
     * RADIUS1 = 2 / √3.
     * Expected: false (minimum radius equals RADIUS1).
     */
    @Test
    void lic8_acuteTriangleMinimumRadiusEqualToRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(2, 0),
            new Point(0, 0),
            new Point(1, Math.sqrt(3))
        };

        assertFalse(CMV.lic8(points, 1, 1, (2.0 / Math.sqrt(3))));
    }

    /**
     * Negative test: LIC8 should return false when an acute triangle
     * can be enclosed by a circle with radius RADIUS1.
     * lic8 should return false.
     * Test case: Points (0,0), (0,0), (2,0), (0,0), (1, √3) with A_PTS = 1, B_PTS = 1, RADIUS1 = 1.3.
     * Expected: false (minimum radius ≈ 1.155 < 1.3).
     */
    @Test
    void lic8_acuteTriangleMinimumRadiusSmallerThanRADIUS1_returnsFalse() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(2, 0),
            new Point(0, 0),
            new Point(1, Math.sqrt(3))
        };

        assertFalse(CMV.lic8(points, 1, 1, 1.3));
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
    void lic9_conditionsMet_returnsTrue() {
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
  
    /**
     * Negative test: lic10 should return false when NUMPOINTS < 5.
     * Test case: 4 points.
     * Expected: false.
     */
    @Test
    void lic10_lessThanFivePoints_returnsFalse() {
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
  
  
    /**
     * Positive test: lic10 returns true when there exists three points separated by
     * exactly E_PTS and F_PTS intervening points forming triangle area > AREA1.
     * Test case: Points (0,0), (1,0), (3,0) with E_PTS=1, F_PTS=2.
     * Expected: true (area = 1.5 > 1.49).
     */
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
  
  
    /**
     * Negative test: lic10 returns false when no triangle area > AREA1 exists.
     * Test case: Same points as above but AREA1 larger.
     * Expected: false (area = 1.5 < 1.51).
     */
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


    /**
     * Positive test: If the longest distance between two points in a set of three is 2, {@code minEnclosingRadius} should return 1;
     * Test case: (0, 0) → (0, 2) → (1, 1)
     * Expected: 1, since the triangle is right angle and the longest side has length 2. 
     */
    @Test
    void minEnclosingRadius_longestDistanceIs2_returns1() {
        Point A = new Point(0, 0);
        Point B = new Point(0, 2); // Distance AB is 2
        Point C = new Point(1, 1);

        assertEquals(1.0, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return 1 when the longest side is 2.");
    }

    /**
     * Positive test: If all points are the same, {@code minEnclosingRadius} should return 0.
     * Test case: (0, 0) → (0, 0) → (0, 0)
     * Expected: 0, since all the points are the same.
     */
    @Test
    void minEnclosingRadius_allPointsAreTheSame_returnsZero(){
        Point A = new Point(0, 0);
        Point B = new Point(0, 0);
        Point C = new Point(0, 0);

        assertEquals(0.0, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return 0 when all points are the same.");
    }

    /**
     * Positive test: If two points are the same, {@code minEnclosingRadius} should return half the length of the longest distance.
     * Test case: (0, 0) → (0, 0) → (2, 0)
     * Expected: 1, since the first two points are the same and the distance between these points and the third point is 2.
     */
    @Test
    void minEnclosingRadius_twoPointsAreTheSame_returnsHalfOfLongestDistance() {
        Point A = new Point(0, 0);
        Point B = new Point(0, 0);
        Point C = new Point(2, 0);

        assertEquals(1, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return half the length of the longest distance when two points are the same.");
    }

    /**
     * Positive test: If the three points form a right angle triangle, the function should return half of the longest distance.
     * Test case: (0, 0) → (1, 0) → (0, 1)
     * Expected: sqrt(2) / 2, since the triangle is right angle and its longest side is sqrt(2).
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
     * Positive test: If the three points form an obtuse triangle, the function should return half of the longest distance.
     * Test case: (0, 0) → (4, 0) → (1, 1)
     * Expected: 2, since the triangle is obtuse and its longest side is of length 4.
     */
    @Test
    void minEnclosingRadius_triangleIsObtuse_returnsHalfLongestDistance() {
        Point A = new Point(0, 0);
        Point B = new Point(4, 0);
        Point C = new Point(1, 1);

        assertEquals(2.0, Point.minEnclosingRadius(A, B, C), 1e-9, "minEnclosingRadius should return half the length of the longest distance when the triangle is obtuse.");
    }

    /**
     * Positive test: If the three points form an acute triangle, the function should return the radius of its circumcircle.
     * Test case: (0, 0) → (2, 0) → (1, sqrt(3))
     * Expected: 2 / sqrt(3), since the points form an acute triangle with side length 2.
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


    /**
     * Negative test: If {@code NUMPOINTS} is less than five, lic13 should return false.
     * Test case: (0, 0) → (1, 0)
     * Expected: false, since {@code NUMPOINTS = 2} and {@code 2 < 5}
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
     * Negative test: If {@code RADIUS2} is less than zero, lic13 should return false.
     * Test case: (0, 0) → (1, 0) → (2, 0) → (3, 0) → (4, 0)
     * Expected: false, since {@code RADIUS2 = -1.0} and {@code -1.0 < 0}.
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
     * Negative test: If all triplets can be contained within a circle of radius {@code RADIUS1}, lic13 ahould return false.
     * Test case: (0, 0) → (1, 0) → (-1, 0) → (0, 1) → (0, -1)
     * Expected: false, since {@code RADIUS1 = 2.0} all triplets can be contained within a circle of radius 2.0.
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
     * Negative test: If no triplets can be contained within a circle of radius {@code RADIUS2}, lic13 should return false.
     * Test case: (0, 0) → (4, 0) → (-4, 0) → (0, 4) → (0, -4)
     * Expected: false, since {@code RADIUS2 = 1.0} and no triplet can be contained in a circle with radius 1.0.
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
     * Positive test: If a triplet which can not be contained by {@code RADIUS1} exists and a triplet which can be contained by {@code RADIUS2} exists, lic13 should return true.
     * Test case: (0, 0) → (0, 0) → (2, 0) → (4, 0) → (-2, 0) → (0, -4)
     * Expected: true, since triplet ((0, 0), (2, 0), (-2, 0)) cannot be contained within a circle of radius {@code RADIUS1 = 1.0}
     * and triplet ((0, 0), (4, 0), (0, -4)) can be contained within a circle of radius {@code RADIUS2 = 4.0}.
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


