import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		int[] visited = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		visited[R] = 1;
		q.offer(R);
		int cnt = 2;
		while (!q.isEmpty()) {
			int n = q.poll();
			
			for (int next : list[n]) {
				if (visited[next] == 0) {
					visited[next] = cnt++;
					q.offer(next);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.print(sb);
	
	}
	
}