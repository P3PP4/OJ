import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[100001];
		dp[1] = 3;
		dp[2] = 7;
	    for (int i = 3; i < 100001; i++) {
		    dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
	    }
		
	    System.out.print(dp[Integer.parseInt(br.readLine())]);
		
    }
	
}
