import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[41];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= 40; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int start = 1;
		int result = 1;
		for (int i = 0; i < M; i++) {
			int index = Integer.parseInt(br.readLine());
			if (dp[index - start] != 0) result *= dp[index - start];
			start = index + 1;
		}
		
		if (start <= N) result *= dp[N + 1 - start];
		
		System.out.print(result);
	
	}
	
}