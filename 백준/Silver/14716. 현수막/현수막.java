import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				if ("1".equals(st.nextToken())) map[i][j] = true;
			}
		}
		
		int[] dr = { -1, -1, -1,  0,  1,  1,  1,  0 };
		int[] dc = { -1,  0,  1,  1,  1,  0, -1, -1 };
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] now = q.poll();
						for (int dir = 0; dir < 8; dir++) {
							int nr = now[0] + dr[dir];
							int nc = now[1] + dc[dir];
							if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] && !visited[nr][nc]) {
								q.offer(new int[] { nr, nc });
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}
		System.out.print(cnt);
	
	}
	
}