import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] dp = new BigInteger[10001];
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		for (int i = 2; i < 10001; i++) {
			dp[i] = dp[i - 2].add(dp[i - 1]);
		}
		
		System.out.print(dp[Integer.parseInt(br.readLine())]);
	
	}
	
}
