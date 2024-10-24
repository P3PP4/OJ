import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(dist[i], 200_000);
				dist[i][i] = 0;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				dist[A][B] = C;
				dist[B][A] = C;
			}
			int K = Integer.parseInt(br.readLine());
			int[] friend = new int[K];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) {
				friend[i] = Integer.parseInt(st.nextToken());
			} // end of input
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;
					for (int k = 1; k <= N; k++) {
						if (i == k || j == k) continue;
						if (dist[j][k] > dist[j][i] + dist[i][k]) dist[j][k] = dist[j][i] + dist[i][k];
					}
				}
			}
			
			int min = 200000;
			int idx = 0;
			for (int i = 1; i <= N; i++) {
				int tmp = 0;
				for (int j = 0; j < K; j++) {
					tmp += dist[i][friend[j]];
				}
				if (tmp < min) {
					min = tmp;
					idx = i;
				}
			}
			sb.append(idx).append("\n");
		}
		System.out.print(sb);
	
	}
	
}