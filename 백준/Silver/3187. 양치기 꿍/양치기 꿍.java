import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int sheep = 0;
		int wolf  = 0;
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int s = 0;
				int w = 0;
				
				if ((map[r][c] == 'v' || map[r][c] == 'k') && !visited[r][c]) {
					visited[r][c] = true;
					q.offer(new int[] { r, c });
				}
				
				while (!q.isEmpty()) {
					int[] p = q.poll();
					
					if (map[p[0]][p[1]] == 'v') w++;
					else if (map[p[0]][p[1]] == 'k') s++;
					
					for (int dir = 0; dir < 4; dir++) {
						int nr = p[0] + dr[dir];
						int nc = p[1] + dc[dir];
						if (0 <= nr && nr < R && 0 <= nc && nc <= C && map[nr][nc] != '#' && !visited[nr][nc]) {
							visited[nr][nc] = true;
							q.offer(new int[] { nr, nc });
						}
					}
				}
				
				if (s > w) sheep += s;
				else wolf += w;
			}
		}
		
		System.out.print(sheep + " " + wolf);
	
	}
	
}