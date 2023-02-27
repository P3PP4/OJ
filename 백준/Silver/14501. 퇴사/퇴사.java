import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][2];
		for (int i = 0; i < input.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		} // 입력 끝
		
		int[] dp = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			
			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
			
			if(i + input[i][0] <= N) dp[i + input[i][0]] = Math.max(dp[i + input[i][0]], dp[i] + input[i][1]);
			
		}
		
		System.out.println(dp[N]);
		
	}
	
}