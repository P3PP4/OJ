import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static boolean[] notPrime = new boolean[100001];
	static int[] dp = new int[100001];
	
	public static void main(String[] args) throws Exception {
		
		for (int i = 2; i < 100001; i++) {
			if (!notPrime[i]) {
				for (int j = i * 2; j < 100001; j += i) {
					notPrime[j] = true;
				}
			}
		} // sieve of Eratosthenes
		
		for (int prime = 2; prime < 100001; prime++) {
			if (notPrime[prime]) continue;
			dp[prime]++;
			for (int i = prime; i < 100001; i++) {
				dp[i] += dp[i - prime];
				dp[i] %= 1000000007;
			}
		}
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}