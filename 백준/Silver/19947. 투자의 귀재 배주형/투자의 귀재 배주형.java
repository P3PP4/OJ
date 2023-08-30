import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] dp = new int[11];
		dp[0] = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= Y; i++) {
			if (4 < i) dp[i] = (int) Math.max(dp[i - 1] * 1.05, Math.max(dp[i - 3] * 1.2, dp[i - 5] * 1.35));
			else if (2 < i) dp[i] = (int) Math.max(dp[i - 1] * 1.05, dp[i - 3] * 1.2);
			else dp[i] = (int) (dp[i - 1] * 1.05);
		}
		System.out.print(dp[Y]);
	
	}
	
}