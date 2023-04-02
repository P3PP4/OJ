import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K + 1];
		for (int i = A + 1; i <= K; i++) {
			dp[i] = 1000000;
		}
		
		for (int i = A; i < K; i++) {
			dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
			if (i * 2 <= K) dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
		}
		
		System.out.print(dp[K]);
	}
	
}