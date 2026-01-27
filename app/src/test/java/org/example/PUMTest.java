package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PUMTest {
    
    /**
     * If all elements in {@code LCM} are NOTUSED, all elements in {@code PUM} should be true.
     */
    @Test
    void computePUM_LCMallElementsNOTUSED_alwaysTrue() {
        Connector[][] lcm = {
            {Connector.NOTUSED, Connector.NOTUSED},
            {Connector.NOTUSED, Connector.NOTUSED}
        };

        boolean[] cmv = {false, false};
        boolean[][] pum = PUM.computePUM(lcm, cmv);

        assertTrue(pum[0][0]);
        assertTrue(pum[0][1]);
        assertTrue(pum[1][0]);
        assertTrue(pum[1][1]);
    }

    /**
     * Check that when connector is ANDD logical AND is applied correctly.
     */
    @Test
    void computePUM_connectorIsAND_computesLogicalAND() {
        Connector[][] lcm = {
            {Connector.ANDD, Connector.ANDD},
            {Connector.ANDD, Connector.ANDD}
        };

        boolean[] cmv = {true, false};
        boolean[][] pum = PUM.computePUM(lcm, cmv);

        assertTrue(pum[0][0]);
        assertFalse(pum[0][1]);
        assertFalse(pum[1][0]);
        assertFalse(pum[1][1]);
    }

    /**
     * Check that when connector is ORR logical OR is applied correctly.
     */
    @Test
    void computePUM_connectorIsORR_computesLogicalOR() {
        Connector[][] lcm = {
            {Connector.ORR, Connector.ORR},
            {Connector.ORR, Connector.ORR}
        };

        boolean[] cmv = {true, false};
        boolean[][] pum = PUM.computePUM(lcm, cmv);

        assertTrue(pum[0][0]);
        assertTrue(pum[0][1]);
        assertTrue(pum[1][0]);
        assertFalse(pum[1][1]);
    }
}
