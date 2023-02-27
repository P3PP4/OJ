import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] input = new int[n];
		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		} // end of input
		
		dp[0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (0 <= j - input[i]) dp[j] += dp[j - input[i]];
			}
		}
		
		System.out.print(dp[k]);
	
	}
	
}