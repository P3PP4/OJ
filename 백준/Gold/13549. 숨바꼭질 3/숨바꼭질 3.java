import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, next, min = 999999;
	static boolean[] visited = new boolean[200001]; 
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
	}
	
	static void bfs() {
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>( (o1, o2) -> {
			return o1.time - o2.time;
		});

		pq.offer(new Node(N, 0));
		
		while(!pq.isEmpty()) {
			
			Node now = pq.poll();
			
			if(now.idx == K) {
				
				System.out.println(now.time);
				return;
				
			}
			
			next = now.idx * 2;
			if(0 < next && next <= 200000) {
				pq.offer(new Node(next, now.time));
				visited[next] = true;
			}
			next = now.idx + 1;
			if(next <= 100000 && !visited[next]) {
				pq.offer(new Node(next, now.time + 1));
				visited[next] = true;
			}
			next = now.idx - 1;
			if(0 <= next && !visited[next]) {
				pq.offer(new Node(next, now.time + 1));
				visited[next] = true;
			}
			
		}
		
	}
	
	static class Node {
		
		int idx;
		int time;
		
		public Node(int idx, int time) {

			this.idx = idx;
			this.time = time;
			
		}
		
	}
	
}