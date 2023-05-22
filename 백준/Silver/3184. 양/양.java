import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] dr = { -1,  0,  1,  0 };
		int[] dc = {  0,  1,  0, -1 };
		int sheep = 0;
		int wolf = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][];
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		} // end of input
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'o')) {
					int w = 0;
					int s = 0;
					
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] { i, j });
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int[] now = q.poll();
						
						if (map[now[0]][now[1]] == 'v') w++;
						else if (map[now[0]][now[1]] == 'o') s++;
						
						for (int dir = 0; dir < 4; dir++) {
							int nr = now[0] + dr[dir];
							int nc = now[1] + dc[dir];
                            
							if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && map[nr][nc] != '#') {
								q.offer(new int[] { nr, nc });
								visited[nr][nc] = true;
							}
						}
					}
					
					if (w < s) sheep += s;
					else wolf += w;
				}
			}
		}
		
		System.out.print(sheep + " " + wolf);
	
	}
	
}