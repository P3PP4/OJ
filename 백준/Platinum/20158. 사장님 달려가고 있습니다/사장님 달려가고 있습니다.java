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
		} // end of input
		
		int[] dr = { -1,  0,  1,  0 };
		int[] dc = {  0,  1,  0, -1 };
		Queue<Pos> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[N + 1][N + 1][4][15];
		q.offer(new Pos(1, 1, 0, 0));
		int time = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			while(0 < size--) {
				Pos p = q.poll();
				
				if (p.r == N && p.c == N) {
					System.out.print(time);
					return;
				}
				
				for (int dir = 0; dir < 4; dir++) {
					int na = dir == p.d ? p.a + 1 : 1;
					int nr = p.r + (dr[dir] * na);
					int nc = p.c + (dc[dir] * na);
					
					if (nr < 1 || N < nr || nc < 1 || N < nc || visited[nr][nc][dir][na] || (map[nr][nc] != 0 && map[nr][nc] <= time + 1)) continue;
					
					if (p.d == dir) {
						boolean promise = true;
						int r = p.r;
						int c = p.c;
						
						for (int i = 1; i < na; i++) {
							r += dr[dir];
							c += dc[dir];
							
							if (map[r][c] != 0 && map[r][c] <= time) {
								promise = false;
								break;
							}
						}
						
						if (!promise) continue;
					}
					
					q.offer(new Pos(nr, nc, dir, na));
					visited[nr][nc][dir][na] = true;
				}
			}
			
			time++;
		}
		
		System.out.print("Fired");
		
	}
	
	static class Pos {
		int r, c, d, a;
		
		public Pos (int r, int c, int d, int a) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.a = a;
		}
	}
	
}