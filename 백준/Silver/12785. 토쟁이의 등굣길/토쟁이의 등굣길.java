import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken()) - 1;
		int H = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;
		long[][] dp = new long[200][200];
		for (int i = 0; i < 200; i++) {
			dp[i][0] = dp[0][i] = 1;
		}
		
		for (int i = 1; i < 200; i++) {
			for (int j = 1; j < 200; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_007;
			}
		}
		
		System.out.print((dp[X][Y] * dp[W - X][H - Y]) % 1_000_007);
		
	}
	
}