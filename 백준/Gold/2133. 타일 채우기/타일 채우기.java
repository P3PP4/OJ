import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;
		for (int i = 4; i <= 30; i += 2) {
			dp[i] = dp[i - 2] * dp[2];
			for (int j = 0; j < i - 2; j += 2) {
				dp[i] += dp[j] * 2;
			}
		}
		
		System.out.print(dp[N]);
	
	}
	
}