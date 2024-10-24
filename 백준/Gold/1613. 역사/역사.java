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
		int K = Integer.parseInt(st.nextToken());
		int[][] dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], 500);
			dist[i][i] = 0;
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				for (int k = 1; k <= N; k++) {
					if (i == k || j == k) continue;
					if (dist[j][k] > dist[j][i] + dist[i][k]) dist[j][k] = dist[j][i] + dist[i][k];
				}
			}
		}
		
		int S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (dist[a][b] == 500) {
				if (dist[b][a] == 500) sb.append(0);
				else sb.append(1);
			} else sb.append(-1);
			sb.append("\n");
		}
		System.out.print(sb);
	
	}
	
}