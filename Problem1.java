import java.util.LinkedList;
import java.util.Queue;
/*
TC-> O(m*n) if we start from 0
O((m*n)^2) if we start from 1
SC ->O(m*n)

DFS approach also the TC of O((m*n)^2)
SC-> O(m*n)

So here the better appraoch would be BFS starting from 0
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        int level = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        q.add(new int[] { nr, nc });
                        mat[nr][nc] = level + 1;
                    }

                }

            }
            level++;
        }
        return mat;
    }
}