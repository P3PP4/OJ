import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of input
		
		for (int i = 1; i < N; i++) {
			dp[i][0] += dp[i - 1][0];
	    }
		for (int j = 1; j < M; j++) {
			dp[0][j] += dp[0][j - 1];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + dp[i][j];
			}
		}
		
		System.out.print(dp[N - 1][M - 1]);
	
	}

}
