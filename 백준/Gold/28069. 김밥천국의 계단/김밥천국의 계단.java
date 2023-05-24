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
		dp[1] = 1;
		for (int i = 2; i < 1000001; i++) {
			if (dp[i] == 0) dp[i] = dp[i - 1] + 1;
			
			int next = i + (i / 2);
			if (next < 1000001) dp[next] = dp[i] + 1;
		}
		
		System.out.print(dp[N] <= K ? "minigimbob" : "water");
		
	}
	
}