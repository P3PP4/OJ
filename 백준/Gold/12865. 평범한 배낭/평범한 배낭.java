import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int[][] input, dp;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 물건 수
		K = Integer.parseInt(st.nextToken());	// 최대 무게
		input = new int[N + 1][2];
		dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());	// 무게
			input[i][1] = Integer.parseInt(st.nextToken());	// 가치
		} // 입력 끝
		
		for (int i = 1; i <= N; i++) {
			
			for (int w = 1; w <= K; w++) {
				
				if(w < input[i][0]) dp[i][w] = dp[i - 1][w];
				else dp[i][w] = Math.max(input[i][1] + dp[i - 1][w - input[i][0]], dp[i - 1][w]);
				
			}
			
		}
        
		System.out.print(dp[N][K]);
		
	}
	
}