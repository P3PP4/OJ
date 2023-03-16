import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		if(K == 0) {
			System.out.println(X);
			return;
		}
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			list[from].add(to);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(X);
		visited[X] = true;
		int dist = 0;
		
		while(!q.isEmpty() && dist < K) {
			
			int size = q.size();
			dist++;
			
			while(size-- > 0) {
				
				int a = q.poll();
				
				for (int next : list[a]) {
					
					if(!visited[next]) {
						
						visited[next] = true;
						q.offer(next);
						
						if(dist == K) pq.offer(next);
						
					}
					
				}
				
			}
			
		}
		
		if(pq.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}
	
}