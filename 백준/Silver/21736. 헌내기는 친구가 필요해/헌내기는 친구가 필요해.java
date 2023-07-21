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
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') {
					q.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}
		
		int[] dr = { -1,  0,  1,  0 };
		int[] dc = {  0,  1,  0, -1 };
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = now[0] + dr[dir];
				int nc = now[1] + dc[dir];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] != 'X') {
					if (map[nr][nc] == 'P') cnt++;
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
		System.out.print(cnt == 0 ? "TT" : cnt);
	
	}
	
}