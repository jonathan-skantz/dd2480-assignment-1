package org.example;

public class FUV {

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
