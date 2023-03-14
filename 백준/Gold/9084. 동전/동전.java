import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, M;
	static int[] value;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
	
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
		
			N = Integer.parseInt(br.readLine());
			value = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				value[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			dp = new int[N + 1][M + 1];
			
			for (int i = 1; i <= N; i++) {
				if (value[i] <= M) dp[i][value[i]] = 1;
				for (int j = 1; j <= M; j++) {
					dp[i][j] = dp[i][j] + dp[i - 1][j] + (value[i] <= j ? dp[i][j - value[i]] : 0);
				}
			}
			
			sb.append(dp[N][M]).append("\n");
		
		}
		
		System.out.print(sb);
	
	}
	
}