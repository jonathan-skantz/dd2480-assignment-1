package org.example;

public class FUV {

    /**
    * Computes the Final Unlocking Vector (FUV) - A vector calculated from the
    * Preliminary Unlocking Vector (PUV) and the Preliminary Unlocking Matrix (PUM).
    *
    * @param puv the Preliminary Unlocking Vector (PUV)
    * @param pum the Preliminary Unlocking Matrix (PUM)
    * @return the Final Unlocking Vector (FUV)
    */
    public static boolean[] computeFUV(boolean[] puv, boolean[][] pum) {
        int fuvLength = puv.length;
        boolean[] fuv = new boolean[fuvLength];

        for(int i = 0; i < fuvLength; i++) {
            fuv[i] = puv[i] ? isAllTrue(pum[i]) : true;
        }

        return fuv;
    }

    /**
     * Checks if all elements in a boolean array are true.
     * 
     * @param arr the boolean array
     * @return {@code true} if all elements are true, {@code false} otherwise
     */
    public static boolean isAllTrue(boolean[] arr) {
        for(boolean b : arr) {
            if(!b) return false;
        }
        return true;
    }
}
