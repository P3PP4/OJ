import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static double result;
	static int[][] god;
	static int[] parent;
	static PriorityQueue<Election> pq = new PriorityQueue<Election>((o1, o2) -> Double.compare(o1.weight, o2.weight));
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 우주신 개수
		M = Integer.parseInt(st.nextToken());	// 통로의 개수
		god = new int[N + 1][2];	// 신들 좌표
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			god[i][0] = Integer.parseInt(st.nextToken());
			god[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.offer(new Election(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
		} // 이미 연결된 통로 pq에 가중치 0으로 삽입
		
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				pq.offer(new Election(i, j, Math.sqrt(Math.pow(god[i][0] - god[j][0], 2) + Math.pow(god[i][1] - god[j][1], 2))));
			}
		} // 간선 모두 계산해서 우선순위 큐에 삽입
		
		make();
		
		int limit = N - 1;
		int cnt = 0;
		
		while(true) {
			
			Election e = pq.poll();
			
			if(find(e.from) != find(e.to)) {
				
				union(e.from, e.to);
				result += e.weight;
				
				if(++cnt == limit) break;
				
			}
			
		}
		
		System.out.printf("%.2f", result);
		
	}
	
	
	static void make() {
		
		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			
			parent[i] = i;
			
		}
		
	}
	
	static int find(int a) {
		
		if(parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
		
	}
	
	static boolean union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a == b) return false;
		
		if(a > b) parent[a] = b;
		else parent[b] = a;
		return true;
		
	}
	
	static class Election {
		
		int from, to;
		double weight;

		public Election(int from, int to, double weight) {

			this.from = from;
			this.to = to;
			this.weight = weight;
			
		}

	}
	
}