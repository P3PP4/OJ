import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
	
		int[] dp = new int[400001];
		for (int i = N - 1; i >= 0; i--) {
			dp[i] = dp[i + input[i] + 1] + 1;
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(dp[i]).append(" ");
		}
		System.out.print(sb);
		
	}
	
}