import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N + M + 1];
		for (int i = 1; i < N + M + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < K; j++) {
				int temp = Integer.parseInt(st.nextToken());
				list[temp].add(N + i);
				list[N + i].add(temp);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + M + 1];
		q.offer(1);
		visited[1] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int now = q.poll();
				if (now == N) {
					System.out.print(cnt);
					return;
				}
				for (int tube : list[now]) {
					if (!visited[tube]) {
						for (int next : list[tube]) {
							if (!visited[next]) {
								q.offer(next);
								visited[next] = true;
							}
						}
						visited[tube] = true;
					}
				}
			}
			cnt++;
		}
		
		System.out.print(-1);
	
	}
	
}