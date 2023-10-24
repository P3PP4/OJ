import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = { -1, -1,  0,  1,  1,  1,  0, -1 };
	static int[] dc = {  0,  1,  1,  1,  0, -1, -1, -1 };
	static int N, M, max;
	static int[][] map, visited;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		System.out.print(max);
	
	}
	
	static int bfs(int r, int c) {
		visited = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		visited[r][c] = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int dir = 0; dir < 8; dir++) {
				int nr = now[0] + dr[dir];
				int nc = now[1] + dc[dir];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && visited[nr][nc] == 0) {
					if (map[nr][nc] == 1) return visited[now[0]][now[1]];
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = visited[now[0]][now[1]] + 1;
				}
			}
		}
		return 0;
	}
	
}