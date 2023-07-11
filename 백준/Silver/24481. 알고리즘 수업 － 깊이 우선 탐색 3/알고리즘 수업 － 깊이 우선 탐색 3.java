import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int[] visited;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		visited = new int[N + 1];
		Arrays.fill(visited, -1);
		dfs(R, 0);
		
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.print(sb);
	
	}
	
	static void dfs(int now, int cnt) {
		visited[now] = cnt;
		
		for (Integer next : list[now]) {
			if (visited[next] == -1) dfs(next, cnt + 1);
		}
	}
	
}