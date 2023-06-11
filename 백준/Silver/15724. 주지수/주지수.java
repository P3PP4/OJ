import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] input = new int[N + 1][M + 1];
		int[][] total = new int[N + 1][M + 1];
		int[][] hor = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				hor[i][j] = hor[i][j - 1] + input[i][j];
				total[i][j] = total[i - 1][j] + hor[i][j];
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			int result = total[er][ec] - total[sr - 1][ec] - total[er][sc - 1] + total[sr - 1][sc - 1];
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	
	}
	
}