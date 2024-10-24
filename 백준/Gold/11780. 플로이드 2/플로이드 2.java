import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] dist = new int[N + 1][N + 1];
		ArrayList<Integer>[][] list = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], 10_000_000);
			dist[i][i] = 0;
			for (int j = 1; j <= N; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (dist[a][b] > c) dist[a][b] = c;
		} // end of input
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				for (int k = 1; k <= N; k++) {
					if (i == k || j == k) continue;
					if (dist[j][k] > dist[j][i] + dist[i][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
						list[j][k].clear();
						for (Integer n : list[j][i]) {
							list[j][k].add(n);
						}
						list[j][k].add(i);
						for (Integer n : list[i][k]) {
							list[j][k].add(n);
						}
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] == 10_000_000) sb.append(0).append(" ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j || dist[i][j] == 10_000_000) sb.append(0);
				else {
					sb.append(list[i][j].size() + 2).append(" ").append(i).append(" ");
					for (int n : list[i][j]) {
						sb.append(n).append(" ");
					}
					sb.append(j);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		
	}
	
}