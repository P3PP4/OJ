import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] price = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= N; j++) {
				if (i < j) break;
				int tmp = dp[i - j] + price[j];
				if (tmp < dp[i]) dp[i] = tmp;
			}
		}
		System.out.print(dp[N]);
	
	}
	
}