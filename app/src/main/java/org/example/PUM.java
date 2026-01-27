package org.example;

public class PUM {

    /**
     * Computes the Preliminary Unlocking Matrix (PUM) - A 15x15 symmetrix boolean matrix calculated from the 
     * Conditions Met Vector (CMV) and the Logical Connector Matrix (LCM).
     * 
     * {@code PUM[i][j]} is calculated by applying the logical connector {@code LCM[i][j]} to {@code CMV[i]} and {@code CMV[j]}.
     * 
     * @param lcm the Logical Connector Matrix (LCM)
     * @param cmv the Conditions Met Vector (CMV)
     * @return the calculated Preliminary Unlocking Matrix (PUM)
     */
    public static boolean[][] computePUM(Connector[][] lcm, boolean[] cmv) {
        boolean[][] pum = new boolean[lcm.length][lcm[0].length];

        for(int i = 0; i < lcm.length; i++) {
            for(int j = 0; j < lcm[i].length; j++) {
                Connector connector = lcm[i][j];
                switch (connector) {
                    case ANDD -> pum[i][j] = (cmv[i] && cmv[j]);
                    case ORR -> pum[i][j] = (cmv[i] || cmv[j]);
                    case NOTUSED -> pum[i][j] = true;
                }
            }
        }

        return pum;
    }
}
