import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		// end of input
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] min = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		pq.offer(new Edge(S, 0));
		min[S] = 0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (!visited[now.to]) {
				if (now.to == T) {
					System.out.print(min[now.to]);
					return;
				}
				visited[now.to] = true;
				for (Edge next : list[now.to]) {
					if (!visited[next.to] && min[next.to] > min[now.to] + next.weight) {
						min[next.to] = min[now.to] + next.weight;
						pq.offer(new Edge(next.to, min[next.to]));
					}
				}
			}
		}
	
	}
	
	static class Edge implements Comparable<Edge> {
		int to, weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
	
}