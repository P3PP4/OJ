import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[1001][10];
		
		for (int i = 1; i <= 1000; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
			}
		}
		
		int result = 0;
		for (int i = 0; i <= 9; i++) {
			result += dp[N][i];
		}
		
		System.out.print(result % 10007);
	
	}
	
}
