import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[117];
		dp[1] = dp[2] = dp[3] = 1;
		for (int i = 4; i < 117; i++) {
			dp[i] = dp[i - 1] + dp[i - 3];
		}
		System.out.print(dp[Integer.parseInt(br.readLine())]);
	
	}
	
}