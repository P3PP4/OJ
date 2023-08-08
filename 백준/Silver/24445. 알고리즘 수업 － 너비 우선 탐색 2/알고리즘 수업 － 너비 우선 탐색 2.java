import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i], Comparator.reverseOrder());
		}
		
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[N + 1];
		q.offer(R);
		visited[R] = 1;
		int weight = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int next : list[now]) {
				if (visited[next] == 0) {
					q.offer(next);
					visited[next] = ++weight;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.print(sb);
	
	}
	
}