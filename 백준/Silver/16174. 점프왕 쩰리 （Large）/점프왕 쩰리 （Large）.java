import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][N];
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of input
		
		input[N - 1][N - 1] = 1;
		int[] dr = { 1, 0 };
		int[] dc = { 0, 1 };
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] != 0) {
					for (int dir = 0; dir < 2; dir++) {
						int nr = i + dr[dir] * input[i][j];
						int nc = j + dc[dir] * input[i][j];
						if (0 <= nr && nr < N && 0 <= nc && nc < N) dp[nr][nc] = dp[i][j] + 1;
					}
				}
			}
		}
		System.out.print(dp[N - 1][N - 1] == 0 ? "Hing" : "HaruHaru");
	
	}
	
}