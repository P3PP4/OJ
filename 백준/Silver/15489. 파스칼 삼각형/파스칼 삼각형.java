import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[][] dp = new int[30][30];
		for (int i = 1; i < 30; i++) {
			dp[i][1] = 1;
		}
		for (int i = 2; i < 30; i++) {
			for (int j = 2; j <= i; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int sum = 0;
		for (int i = R; i < R + W; i++) {
			for (int j = C; j <= C + i - R ; j++) {
				sum += dp[i][j];
			}
		}
		System.out.print(sum);
	
	}
	
}