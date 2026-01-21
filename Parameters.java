public class Parameters {
    public static final double PI = 3.1415926535;

    double LENGTH1; // Length in LICs 0, 7, 12
    double RADIUS1; // Radius in LICs 1, 8, 13
    double EPSILON; // Deviation from PI in LICs 2, 9
    double AREA1;   // Area in LICs 3, 10, 14
    int Q_PTS;      // No. of consecutive points in LIC 4
    int QUADS;      // No. of quadrants in LIC 4
    double DIST;    // Distance in LIC 6
    int N_PTS;      // No. of consecutive points in LIC 6
    int K_PTS;      // No. of int. pts in LICs 7, 12
    int A_PTS;      // No. of int. pts in LICs 8, 13
    int B_PTS;      // No. of int. pts in LICs 8, 13
    int C_PTS;      // No. of int. pts in LIC 9
    int D_PTS;      // No. of int. pts in LIC 9
    int E_PTS;      // No. of int. pts in LICs 10, 14
    int F_PTS;      // No. of int. pts in LICs 10, 14
    int G_PTS;      // No. of int. pts in LIC 11
    double LENGTH2; // Maximum length in LIC 12
    double RADIUS2; // Maximum radius in LIC 13
    double AREA2;   // Maximum area in LIC 14

    public Parameters(int length1, int radius1, int epsilon, int area1, int q_pts, int quads, int n_pts, int dist, int k_pts, int a_pts, int b_pts, int c_pts, int d_pts, int e_pts, int f_pts, int g_pts, int length2, int radius2, int area2) {
        LENGTH1 = length1;
        RADIUS1 = radius1;
        EPSILON = epsilon;
        AREA1 = area1;
        Q_PTS = q_pts;
        QUADS = quads;
        N_PTS = n_pts;
        DIST = dist;
        K_PTS = k_pts;
        A_PTS = a_pts;
        B_PTS = b_pts;
        C_PTS = c_pts;
        D_PTS = d_pts;
        E_PTS = e_pts;
        F_PTS = f_pts;
        G_PTS = g_pts;
        LENGTH2 = length2;
        RADIUS2 = radius2;
        AREA2 = area2;
    }
}
