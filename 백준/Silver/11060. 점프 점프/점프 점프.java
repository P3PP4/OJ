import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int INF = 9999;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.print(0);
			return;
		}
		int[] input = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = INF;
		} // end of input
		
		dp[0] = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j <= input[i]; j++) {
				if (N <= i + j) break;
				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}
		
		System.out.print(dp[N - 1] == INF ? -1 : dp[N - 1]);
	
	}
	
}