import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(br.readLine());
t:		for (int tc = 0; tc < C; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { S, T });
			int[][] visited = new int[127][127];
			visited[S][T] = 1;
			while (!q.isEmpty()) {
				int[] now = q.poll();
				
				if (now[0] == now[1]) {
					sb.append(visited[now[0]][now[1]] - 1).append("\n");
					continue t;
				}
				
				int ns = now[0] + 1;
				int nt = now[1];
				if (ns < 127 && ns <= nt) {
					q.offer(new int[] { ns, nt });
					visited[ns][nt] = visited[now[0]][now[1]] + 1;
				}
				ns = now[0] * 2;
				nt = now[1] + 3;
				if (ns < 127 && ns <= nt) {
					q.offer(new int[] { ns, nt });
					visited[ns][nt] = visited[now[0]][now[1]] + 1;
				}
			}
		}
		System.out.print(sb);
	
	}
	
}