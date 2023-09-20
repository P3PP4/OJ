import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] input = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N][M];
		dp[0] = input[0];
		for (int i = 1; i < N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					if (j == k) continue;
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + input[i][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			if (dp[N - 1][i] < min) min = dp[N - 1][i];
		}
		System.out.print(min);
	
	}
	
}