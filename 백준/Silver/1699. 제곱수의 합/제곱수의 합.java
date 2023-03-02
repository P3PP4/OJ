import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		
		for (int i = 1; i < 100001; i++) {
			dp[i] = dp[i - 1] + 1;
			int a = 2;
			while(a * a <= i) {
				int aa = a * a;
				dp[i] = Math.min(dp[i], dp[i - aa] + 1);
				a++;
			}
		}
		
		System.out.print(dp[N]);
	
	}
	
}