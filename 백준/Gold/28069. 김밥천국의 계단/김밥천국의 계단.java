import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[1000001];
		for (int i = 1; i < 1000001; i++) {
			dp[i] = 1234567;
		}
		
		for (int i = 1; i < 1000001; i++) {
			if (i < dp[i]) dp[i] = i;
			if (dp[i - 1] + 1 < dp[i]) dp[i] = dp[i - 1] + 1;
			
			int next = i + (i / 2);
			if (next <= 1000000) dp[next] = Math.min(dp[i] + 1, dp[next]);
		}
		
		System.out.print(dp[N] <= K ? "minigimbob" : "water");
		
	}
	
}