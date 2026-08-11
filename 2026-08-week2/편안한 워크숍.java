import java.util.Arrays;

class Solution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][][] dp;

    public int solution(int n, int k, int[][] mountain) {

        dp = new int[n][n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                answer = Math.min(
                    answer,
                    dfs(i, j, k, mountain, n)
                );
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }

    public int dfs(
        int x,
        int y,
        int cnt,
        int[][] mountain,
        int n
    ) {

        if (dp[x][y][cnt] != -1) {
            return dp[x][y][cnt];
        }

        if (cnt == 1) {
            return dp[x][y][cnt] = 0;
        }

        int best = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n ||
                ny < 0 || ny >= n) {
                continue;
            }

            
            if (mountain[nx][ny] <= mountain[x][y]) {
                continue;
            }

            int next = dfs(
                nx,
                ny,
                cnt - 1,
                mountain,
                n
            );

            if (next == Integer.MAX_VALUE) {
                continue;
            }

            int diff =
                mountain[nx][ny] - mountain[x][y];

            int current = Math.max(next, diff);

            best = Math.min(best, current);
        }

        return dp[x][y][cnt] = best;
    }
}