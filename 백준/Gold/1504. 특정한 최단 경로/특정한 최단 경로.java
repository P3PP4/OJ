import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, E, t1, t2, idx;
	static long[][] dist;
	static ArrayList<Road>[] list;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 정점
		E = Integer.parseInt(st.nextToken());	// 간선
		list = new ArrayList[N + 1];
		dist = new long[3][N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Road>();
			for (int j = 0; j < 3; j++) {
				dist[j][i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken()); 
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Road(to, weight));
			list[to].add(new Road(from, weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		t1 = Integer.parseInt(st.nextToken());	// 2
		t2 = Integer.parseInt(st.nextToken());	// 3
		// 입력 끝
		
		dijkstra(1);
		idx++;
		dijkstra(t1);
		idx++;
		dijkstra(t2);
		
		long sum1 = dist[0][t1] + dist[1][t2] + dist[2][N];
		long sum2 = dist[0][t2] + dist[2][t1] + dist[1][N];
		
		long result = sum1 > sum2 ? sum2 : sum1;
		
		System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
		
	}
	
	static void dijkstra(int start) {
		
		PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		pq.offer(new Road(start, 0));
		dist[idx][start] = 0;
		
		while(!pq.isEmpty()) {
			
			Road r = pq.poll();
			
			if(r.weight > dist[idx][r.to]) continue;
			
			for (Road next : list[r.to]) {
				
				if(dist[idx][next.to] > dist[idx][r.to] + next.weight) {
					
					dist[idx][next.to] = dist[idx][r.to] + next.weight;
					pq.offer(new Road(next.to, next.weight));
					
				}
				
			}
			
		}
		
	}
	
	static class Road {
		
		int to, weight;
		
		public Road(int to, int weight) {
			
			this.to = to;
			this.weight = weight;
			
		}
		
	}
	
}