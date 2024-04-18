import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] input = new int[N][M + 2];
		int[][][] dp = new int[N][M + 2][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][0][j] = 99999999;
				dp[i][M + 1][j] = 99999999;
			}
		}
		for (int j = 1; j <= M; j++) {
			for (int k = 0; k < 3; k++) {
				dp[0][j][k] = input[0][j];
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j][0] = input[i][j] + Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]);
				dp[i][j][1] = input[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
				dp[i][j][2] = input[i][j] + Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]);
			}
		}
		
		int min = 99999999;
		for (int j = 1; j <= M; j++) {
			for (int k = 0; k < 3; k++) {
				if (dp[N - 1][j][k] < min) min = dp[N - 1][j][k];
			}
		}
		System.out.print(min);
		
	}
	
}