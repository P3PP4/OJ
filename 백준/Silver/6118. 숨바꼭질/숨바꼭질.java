import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	static int N, M, num, dist, cnt, total;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		total = 1;
		while (!q.isEmpty()) {
			if (total == N) break;
			int size = q.size();
			dist++;
			cnt = 0;
			num = 99999;
			while (size-- > 0) {
				int now = q.poll();
				for (int next : list[now]) {
					if (!visited[next]) {
						cnt++;
						q.offer(next);
						visited[next] = true;
						if (next < num) num = next;
						total++;
					}
				}
			}
		}
		System.out.print(num + " " + dist + " " + cnt);
	
	}
	
}