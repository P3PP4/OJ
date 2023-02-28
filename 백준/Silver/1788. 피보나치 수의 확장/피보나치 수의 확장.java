import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[2_000_001];
		dp[1_000_001] = 1;
		for (int i = 1_000_002; i < 2_000_001; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_000;
		}
		for (int i = 999_999; i >= 0; i--) {
			dp[i] = (dp[i + 2] - dp[i + 1]) % 1_000_000_000;
		}
		
		int N = Integer.parseInt(br.readLine()) + 1_000_000;
		
		if (dp[N] == 0) System.out.println(0);
		else if(0 < dp[N]) System.out.println(1);
		else System.out.println(-1);
		System.out.print(Math.abs(dp[N]));
	
	}
	
}
