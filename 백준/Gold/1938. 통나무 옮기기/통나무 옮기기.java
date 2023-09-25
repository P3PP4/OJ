import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] dr = { -1, -1,  0,  1,  1,  1,  0, -1 };
		int[] dc = {  0,  1,  1,  1,  0, -1, -1, -1 };
		Queue<Pos> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		int[][][] visited = new int[N][N][N];
		int er = 0;
		int ec = 0;
		int es = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'B') {
					if (0 <= i - 1 && i + 1 < N && map[i - 1][j] == 'B' && map[i + 1][j] == 'B') {
						q.offer(new Pos(i, j, 1));
						visited[i][j][1] = 1;
						map[i][j] = map[i - 1][j] = map [i + 1][j] = '0';
					} else if (0 <= j - 1 && j + 1 < N && map[i][j - 1] == 'B' && map[i][j + 1] == 'B') {
						q.offer(new Pos(i, j, 0));
						visited[i][j][0] = 1;
						map[i][j] = map[i][j - 1] = map [i][j + 1] = '0';
					}
				} else if (map[i][j] == 'E') {
					if (0 <= i - 1 && i + 1 < N && map[i - 1][j] == 'E' && map[i + 1][j] == 'E') {
						er = i;
						ec = j;
						es = 1;
						map[i][j] = map[i - 1][j] = map[i + 1][j] = '0';
					} else if (0 <= j - 1 && j + 1 < N && map[i][j - 1] == 'E' && map[i][j + 1] == 'E') {
						er = i;
						ec = j;
						es = 0;
						map[i][j] = map[i][j - 1] = map [i][j + 1] = '0';
					}
				}
			}
		}
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			if (p.r == er && p.c == ec && p.s == es) {
				System.out.print(visited[er][ec][es] - 1);
				return;
			}
			
			for (int dir = 0; dir < 8; dir += 2) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				if ((p.s == 0 && dir % 4 == 0) || (p.s == 1 && dir % 4 == 2)) {
					int lr = p.r + dr[dir - 1 < 0 ? 7 : dir - 1];
					int lc = p.c + dc[dir - 1 < 0 ? 7 : dir - 1];
					int rr = p.r + dr[7 < dir + 1 ? 0 : dir + 1];
					int rc = p.c + dc[7 < dir + 1 ? 0 : dir + 1];
					if (0 <= lr && lr < N && 0 <= lc && lc < N && map[lr][lc] == '0' && 0 <= rr && rr < N && 0 <= rc && rc < N && map[rr][rc] == '0' && map[nr][nc] == '0' && visited[nr][nc][p.s] == 0) {
						q.offer(new Pos(nr, nc, p.s));
						visited[nr][nc][p.s] = visited[p.r][p.c][p.s] + 1;
					}
				}
				if ((p.s == 0 && dir % 4 == 2) || (p.s == 1 && dir % 4 == 0)) {
					nr += dr[dir];
					nc += dc[dir];
					if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == '0' && visited[nr - dr[dir]][nc - dc[dir]][p.s] == 0) {
						q.offer(new Pos(nr - dr[dir], nc - dc[dir], p.s));
						visited[nr - dr[dir]][nc - dc[dir]][p.s] = visited[p.r][p.c][p.s] + 1;
					}
				}
			}
			
			boolean flag = true;
			for (int dir = 0; dir < 8; dir++) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				if (nr < 0 || N <= nr || nc < 0 || N <= nc || map[nr][nc] == '1') {
					flag = false;
					break;
				}
			}
			if (flag && visited[p.r][p.c][(p.s + 1) % 2] == 0) {
				q.offer(new Pos(p.r, p.c, (p.s + 1) % 2));
				visited[p.r][p.c][(p.s + 1) % 2] = visited[p.r][p.c][p.s] + 1;
			}
		}
		System.out.print(0);
	
	}
	
	static class Pos {
		int r, c, s;
		
		public Pos(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
}