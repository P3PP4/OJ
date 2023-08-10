import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		q.offer(new int[] { 1, 1 });
		visited[1][1] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			if (now[0] == N && now[1] == N) {
				System.out.print("HaruHaru");
				return;
			}
			
			int nr = now[0] + map[now[0]][now[1]];
			int nc = now[1] + map[now[0]][now[1]];
			if (nr <= N && !visited[nr][now[1]]) {
				q.offer(new int[] { nr, now[1] });
				visited[nr][now[1]] = true;
			}
			if (nc <= N && !visited[now[0]][nc]) {
				q.offer(new int[] { now[0], nc });
				visited[now[0]][nc] = true;
			}
		}
		System.out.print("Hing");
		
	}
	
}