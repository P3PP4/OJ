import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] input = new double[N];
		double[] dp = new double[N];
		for (int i = 0; i < N; i++) {
			input[i] = Double.parseDouble(br.readLine());
		}
		
		double max = 0.0;
		dp[0] = input[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] * input[i], input[i]);
			if (max < dp[i]) max = dp[i];
		}
		System.out.printf("%.3f", max);
		
	}
	
}