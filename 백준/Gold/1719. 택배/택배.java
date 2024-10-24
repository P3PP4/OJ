import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] ans = new int[N + 1][N + 1];
		ArrayList<Edge>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(from, to, weight));
			list[to].add(new Edge(to, from, weight));
		} // end of input
		
		for (int i = 1; i <= N; i++) {
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[N + 1];
			int[] min = new int[N + 1];
			Arrays.fill(min, Integer.MAX_VALUE);
			pq.offer(new Edge(i, i, 0));
			min[i] = 0;
			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				if (!visited[now.to]) {
					int first = now.first == i && now.to != i ? now.to : now.first;
					visited[now.to] = true;
					ans[i][now.to] = first;
					for (Edge next : list[now.to]) {
						if (!visited[next.to] && min[next.to] > min[now.to] + next.weight) {
							min[next.to] = min[now.to] + next.weight;
							pq.offer(new Edge(first, next.to, min[next.to]));
						}
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) sb.append("- ");
				else sb.append(ans[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	
	}
	
	static class Edge implements Comparable<Edge> {
		int first, to, weight;
		
		public Edge(int first, int to, int weight) {
			this.first = first;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
	
}