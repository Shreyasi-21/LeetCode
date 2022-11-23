
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean[][] cols = new boolean[n][n];
        boolean[][] rows = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = matrix[i][j] - 1;
                if (cols[j][x] || rows[i][x]) {
                    return false;
                }
                cols[j][x] = true;
                rows[i][x] = true;
            }
        }
        return true;
    }
}