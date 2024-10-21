import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 교차로
			int M = Integer.parseInt(st.nextToken());	// 도로
			int T = Integer.parseInt(st.nextToken());	// 목적지 후보의 개수
			ArrayList<Road>[] list = new ArrayList[N + 1];
			boolean[] visited = new boolean[N + 1];
			int[] min = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
				min[i] = 100000000;
			}
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());	// 출발지
			int G = Integer.parseInt(st.nextToken());	// 이 사이를
			int H = Integer.parseInt(st.nextToken());	// 지나감
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				if ((G == from && H == to) || (H == from && G == to)) {
					list[from].add(new Road(to, weight * 2 - 1));
					list[to].add(new Road(from, weight * 2 - 1));
				} else {
					list[from].add(new Road(to, weight * 2));
					list[to].add(new Road(from, weight * 2));
				}
			}
			List<Integer> ans = new ArrayList<>();		// 목적지 후보 저장
			for (int i = 0; i < T; i++) {
				ans.add(Integer.parseInt(br.readLine()));
			} // end of input
			
			PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
			pq.offer(new Road(S, 0));
			min[S] = 0;
			while (!pq.isEmpty()) {
				Road now = pq.poll();
				if (!visited[now.to]) {
					visited[now.to] = true;
					for (Road next : list[now.to]) {
						if (min[next.to] >= min[now.to] + next.weight) {
							min[next.to] = min[now.to] + next.weight;
							pq.offer(new Road(next.to, min[next.to]));
						}
					}
				}
			}
			
			Collections.sort(ans);
			for (Integer i : ans) {
				if (min[i] % 2 == 1) sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	
	}
	
	static class Road {
		int to, weight;
		
		public Road(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
}