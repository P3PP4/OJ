import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		int[] start = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		int[] dr = { -1,  0,  1,  0 };
		int[] dc = {  0,  1,  0, -1 };
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			int[] n = q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = n[0] + dr[dir];
				int nc = n[1] + dc[dir];
				
				if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 1 && visited[nr][nc] == 0) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = visited[n[0]][n[1]] + 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) sb.append(-1);
				else sb.append(visited[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
}