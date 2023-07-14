import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] dp = new int[46];
		dp[1] = 1;
		for (int i = 2; i < 46; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.print(dp[K - 1] + " " + dp[K]);
	
	}
	
}