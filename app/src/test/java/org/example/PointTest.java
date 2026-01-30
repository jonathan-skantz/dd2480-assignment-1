package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    void distance_twoPointsAreTheSame_returns0() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(10, 10);
        assertEquals(0, p1.distance(p2));
    }

    @Test
    void distance_twoDifferentPoints_returnsMoreThan0() {
        Point p1 = new Point(10, -3);
        Point p2 = new Point(7, -7);
        assertEquals(5, p1.distance(p2));
    }

    @Test
    void equals_twoPointsAreTheSame_returnsTrue() {
        Point p1 = new Point(-5, 12);
        Point p2 = new Point(-5, 12);
        assertEquals(p1, p2);
    }

    @Test
    void equals_twoDifferentPoints_returnsFalse() {
        Point p1 = new Point(5, 12);
        Point p2 = new Point(-5, 12);
        assertNotEquals(p1, p2);
    }

    @Test
    void magnitude_pointWithNegativeCoords_returnsPositiveMagnitude() {
        Point p = new Point(-5, -12);
        assertEquals(13, p.magnitude());
    }

    @Test
    void magnitude_pointWithPositiveCoords_returnsPositiveMagnitude() {
        Point p = new Point(5, 12);
        assertEquals(13, p.magnitude());
    }

    @Test
    void vectorTo_twoPointsAreTheSame_returnsZeroVector() {
        Point p1 = new Point(5, 12);
        Point p2 = new Point(5, 12);
        Point vec = p1.vectorTo(p2);
        assertEquals(0, vec.x);
        assertEquals(0, vec.y);
    }

    @Test
    void vectorTo_twoDifferentPoints_returnsCorrectNewVector() {
        Point p1 = new Point(5, 2);
        Point p2 = new Point(1, 12);
        Point vec = p1.vectorTo(p2);
        assertEquals(-4, vec.x);
        assertEquals(10, vec.y);
    }

    @Test
    void dotProduct_onePointIsTheOrigin_returns0() {
        Point p1 = new Point(5, 2);
        Point p2 = new Point(0, 0);
        assertEquals(0, p1.dotProduct(p2));
    }

    @Test
    void dotProduct_twoDifferentPoints_returnsCorrectDotProduct() {
        Point p1 = new Point(5, 2);
        Point p2 = new Point(12, 3);
        assertEquals(66, p1.dotProduct(p2));
    }

    @Test
    void projectOnto_parallelVectors_returnsSameVector() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point proj = p1.projectOnto(p2);
        assertEquals(1, proj.x);
        assertEquals(1, proj.y);
    }
    
    @Test
    void projectOnto_orthogonalVectors_returnsZeroVector() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, 1);
        Point proj = p1.projectOnto(p2);
        
        // Use assertTrue() instead of assertEquals() because the projected coords are -0.0.
        assertTrue(proj.x == 0);
        assertTrue(proj.y == 0);
    }

    @Test
    void projectOnto_twoNonZeroAndNonOrthogonalVectors_returnsNewVector() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point proj = p1.projectOnto(p2);
        
        // Margin of error: 1e-9
        assertEquals(6.0/5.0, proj.x, 1e-9);
        assertEquals(3.0/5.0, proj.y, 1e-9);
    }
    
    @Test
    void add_twoDifferentPoints_returnsCorrectPoint() {
        Point p1 = new Point(5, 6);
        Point p2 = new Point(-3, 7);
        Point p3 = p1.add(p2);
        assertEquals(2, p3.x);
        assertEquals(13, p3.y);
    }

    @Test
    void add_oppositePoints_returnsOrigin() {
        Point p1 = new Point(5, 6);
        Point p2 = new Point(-5, -6);
        Point p3 = p1.add(p2);
        assertEquals(0, p3.x);
        assertEquals(0, p3.y);
    }

    @Test
    void subtract_twoDifferentPoints_returnsCorrectPoint() {
        Point p1 = new Point(5, 6);
        Point p2 = new Point(-3, 7);
        Point p3 = p1.subtract(p2);
        assertEquals(8, p3.x);
        assertEquals(-1, p3.y);
    }

    @Test
    void subtract_oppositePoints_returnsFirstPointWithDoubleCoords() {
        Point p1 = new Point(5, 6);
        Point p2 = new Point(-5, -6);
        Point p3 = p1.subtract(p2);
        assertEquals(10, p3.x);
        assertEquals(12, p3.y);
    }

}
