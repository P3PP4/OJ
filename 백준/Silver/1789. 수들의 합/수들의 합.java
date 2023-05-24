import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long[] dp = new long[100_000];
		for (int i = 1; i < 100_000; i++) {
			dp[i] = dp[i - 1] + i;
		}
		
		int i;
		for (i = 1; i < 100000; i++) {
			if (S < dp[i]) break;
		}
		
		System.out.print(i - 1);
	
	}
	
}