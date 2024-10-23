import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 도시 수
		int M = Integer.parseInt(st.nextToken());	// 도로 수
		int K = Integer.parseInt(st.nextToken());	// 면접장 수
		boolean[] visited = new boolean[N  + 1];
		long[] min = new long[N + 1];
		ArrayList<Road>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Road>();
			min[i] = Long.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[to].add(new Road(from, weight));
		}
		PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.weight, o2.weight));
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int start = Integer.parseInt(st.nextToken());
			pq.offer(new Road(start, 0));
			min[start] = 0;
		} // end of input
		
		while (!pq.isEmpty()) {
			Road now = pq.poll();
			if (!visited[now.to]) {
				visited[now.to] = true;
				for (Road next : list[now.to]) {
					if (!visited[next.to] && min[next.to] > min[now.to] + next.weight) {
						min[next.to] = min[now.to] + next.weight;
						pq.offer(new Road(next.to, min[next.to]));
					}
				}
			}
		}
		
		long max = 0;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			if (max < min[i]) {
				max = min[i];
				idx = i;
			}
		}
		System.out.print(idx + "\n" + max);
		
	}
	
	static class Road {
		int to;
		long weight;
		
		public Road(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
}