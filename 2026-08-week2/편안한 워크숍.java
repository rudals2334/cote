import java.util.Arrays;

class Solution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][][] dp;

    public int solution(int n, int k, int[][] mountain) {

        // dp[x][y][cnt]
        // (x,y)에서 시작해서 길이가 cnt인 등산로를 만들 때
        // 가능한 최소 최대 높이 차
        dp = new int[n][n][k + 1];

        // -1 = 아직 계산하지 않은 상태
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int answer = Integer.MAX_VALUE;

        // 어느 칸에서 시작해도 되므로
        // 모든 칸을 시작점으로 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                answer = Math.min(
                    answer,
                    dfs(i, j, k, mountain, n)
                );
            }
        }

        // 길이 k인 등산로를 만들 수 없는 경우
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

        // 이미 계산한 상태라면 재사용
        if (dp[x][y][cnt] != -1) {
            return dp[x][y][cnt];
        }

        // 길이가 1이면 이동할 필요가 없으므로
        // 높이 차는 0
        if (cnt == 1) {
            return dp[x][y][cnt] = 0;
        }

        int best = Integer.MAX_VALUE;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어나면 이동 불가
            if (nx < 0 || nx >= n ||
                ny < 0 || ny >= n) {
                continue;
            }

            // 반드시 현재보다 높은 칸으로만 이동
            if (mountain[nx][ny] <= mountain[x][y]) {
                continue;
            }

            // 다음 위치부터 cnt - 1개의 칸을 지나가는
            // 등산로의 최소 불편함
            int next = dfs(
                nx,
                ny,
                cnt - 1,
                mountain,
                n
            );

            // 해당 방향으로 길이 cnt짜리 경로를
            // 만들 수 없는 경우
            if (next == Integer.MAX_VALUE) {
                continue;
            }

            // 현재 → 다음 칸의 높이 차
            int diff =
                mountain[nx][ny] - mountain[x][y];

            // 한 경로 안에서는 가장 큰 높이 차를 구함
            int current = Math.max(next, diff);

            // 여러 경로 중에서는 가장 작은 값을 선택
            best = Math.min(best, current);
        }

        // 계산 결과 저장
        return dp[x][y][cnt] = best;
    }
}