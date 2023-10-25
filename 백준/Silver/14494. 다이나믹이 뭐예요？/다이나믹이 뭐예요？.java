import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int[] dr = { 0, 1, 1 };
		int[] dc = { 1, 0, 1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][M + 1];
		dp[1][1] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				for (int dir = 0; dir < 3; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					if (nr <= N && nc <= M) {
						dp[nr][nc] = (dp[nr][nc] + dp[i][j]) % 1_000_000_007;
					}
				}
			}
		}
		System.out.print(dp[N][M]);
		
	}
	
}