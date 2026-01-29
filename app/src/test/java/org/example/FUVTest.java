package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FUVTest {
    
    /**
     * If {@code PUV[i]} is false, {@code FUV[i]} should be true.
     */
    @Test
    void computeFUV_PUVIsFalse_FUVIstrue() {
        boolean[] puv = {false};
        boolean[][] pum = {{true, true, true}};

        assertTrue(FUV.computeFUV(puv, pum)[0]);
    }

    /**
     * If not all elements in {@code PUM[i]} are true, {@code FUV[i]} should be false.
     */
    @Test
    void computeFUV_notAllElementsTrueInPUM_FUVIsFalse() {
        boolean[] puv = {true};
        boolean[][] pum = {{true, false, true}};

        assertFalse(FUV.computeFUV(puv, pum)[0]);
    } 

    /**
     * If all elements in {@code PUM[i]} are true, {@code FUV[i]} should be true.
     */
    @Test
    void computeFUV_allElementsTrueInPUM_FUVIsTrue() {
        boolean[] puv = {true};
        boolean[][] pum = {{true, true, true}};

        assertTrue(FUV.computeFUV(puv, pum)[0]);
    }

}
