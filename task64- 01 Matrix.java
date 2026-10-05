import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (mat[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                } else {
                    mat[r][c] = -1;
                }
            }
        }

        int[][] directions = {
            {-1, 0},  // Up
            {1, 0},   // Down
            {0, -1},  // Left
            {0, 1}    // Right
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int[] direction : directions) {

                int nr = r + direction[0];
                int nc = c + direction[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    mat[nr][nc] == -1) {

                    mat[nr][nc] = mat[r][c] + 1;

                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}
