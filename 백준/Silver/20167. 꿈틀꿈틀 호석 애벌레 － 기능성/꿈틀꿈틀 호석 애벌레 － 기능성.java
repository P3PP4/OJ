import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] input = new int[N + 1];
		int[] dp = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			int sum = 0;
			for (int j = i; j <= N; j++) {
				sum += input[j];
				if (K <= sum) {
					dp[j] = Math.max(dp[i - 1] + sum - K, dp[j]);
					break;
				}
			}
		}
		System.out.print(dp[N]);
	
	}
	
}