import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, V, E;
	static boolean flag;
	static int[] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		for (int testcase = 0; testcase < T; testcase++) {
		
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			visited = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			
			flag = true;
			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0) {
					if (!bfs(i)) {
						flag = false;
						break;
					}
				}
			}
			
			if (flag) sb.append("YES\n");
			else sb.append("NO\n");
		
		}
		
		System.out.print(sb);
	
	}
	
	static boolean bfs(int index) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(index);
		visited[index] = 1;
		
		while (!q.isEmpty()) {
		
			int now = q.poll();
			
			for (int i = 0; i < list[now].size(); i++) {
				
				int next = list[now].get(i);
				
				if (visited[next] == 0) {
					q.offer(next);
					visited[next] = visited[now] == 1 ? 2 : 1;
				} else if (visited[now] == visited[next]) return false;
				
				
			}
		
		}
		
		return true;
	
	}
	
}
