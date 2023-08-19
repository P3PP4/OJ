import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[N + 1];
		q.offer(1);
		visited[1] = 1;
		int cnt = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (2 < visited[now]) break;
			
			for (int next : list[now]) {
				if (visited[next] == 0) {
					q.offer(next);
					visited[next] = visited[now] + 1;
					cnt++;
				}
			}
		}
		System.out.print(cnt);
	
	}
	
}