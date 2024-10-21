import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 컴퓨터 개수
			int D = Integer.parseInt(st.nextToken());	// 의존성 개수
			int C = Integer.parseInt(st.nextToken());	// 해킹당한 컴퓨터 번호
			boolean[] visited = new boolean[N + 1];
			int[] min = new int[N + 1];
			ArrayList<Node>[] list = new ArrayList[N + 1];
			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
				min[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				list[from].add(new Node(to, time));
			}
			
			pq.offer(new Node(C, 0));
			min[C] = 0;
			int cnt = 0;
			int endTime = 0;
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				if (!visited[now.to]) {
					visited[now.to] = true;
					cnt++;
					if (endTime < min[now.to]) endTime = min[now.to];
					for (Node next : list[now.to]) {
						if (!visited[next.to] && min[next.to] > min[now.to] + next.time) {
							min[next.to] = min[now.to] + next.time;
							pq.offer(new Node(next.to, min[next.to]));
						}
					}
				}
			}
			sb.append(cnt).append(" ").append(endTime).append("\n");
		}
		System.out.print(sb);
	
	}
	
	static class Node {
		int to, time;
		
		public Node(int to, int time) {
			this.to = to;
			this.time = time;
		}
	}
	
}