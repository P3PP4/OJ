import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] dr = { -1,  0,  1,  0 };
		int[] dc = {  0,  1,  0, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
x:		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if (R == 0 && C == 0) break;
			int[][] map = new int[R + 1][C + 1];
			int[][] key = new int[R + 1][C + 1];
			for (int i = 1; i <= R; i++) {
				String s = " " + br.readLine();
				for (int j = 1; j <= C; j++) {
					char c = s.charAt(j);
					if (c == 'N') map[i][j] = 0;
					else if (c == 'E') map[i][j] = 1;
					else if (c == 'S') map[i][j] = 2;
					else map[i][j] = 3;
				}
			}
			int K = Integer.parseInt(br.readLine());
			int done = (1 << K) - 1;
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				key[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i;
			} // end of input
			
			Queue<Pos> q = new LinkedList<>();
			q.offer(new Pos(1, 1, 0, 0));
			boolean[][][][] visited = new boolean[R + 1][C + 1][1 << K][4];
			visited[1][1][0][0] = true;
			int time = 0;
			
			while (!q.isEmpty()) {
				int size = q.size();
				
				while (0 < size--) {
					Pos p = q.poll();
					
					if (p.k == done && p.r == R && p.c == C) {
						sb.append(time).append("\n");
						continue x;
					}
					
					// 제자리 회전
					int nt = (time + 1) % 4;
					if (!visited[p.r][p.c][p.k][nt]) {
						q.offer(new Pos(p.r, p.c, p.k, nt));
						visited[p.r][p.c][p.k][nt] = true;
					}
					
					// 이동
					int nd = (map[p.r][p.c] + time) % 4;
					int nr = p.r + dr[nd];
					int nc = p.c + dc[nd];
					int nk = p.k;
					
					// map 안인지 확인
					if (nr < 1 || R < nr || nc < 1 || C < nc) {
						nr -= dr[nd];
						nc -= dc[nd];
					}
					
					// 열쇠 있나 확인
					if (key[nr][nc] != 0) nk |= 1 << (key[nr][nc] - 1);
					
					if (!visited[nr][nc][nk][nt]) {
						q.offer(new Pos(nr, nc, nk, nt));
						visited[nr][nc][nk][nt] = true;
					}
				}
				
				time++;
			}
		}
		
		System.out.print(sb);
	
	}
	
	static class Pos {
		int r, c, k, t;
		
		public Pos (int r, int c, int k, int t) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.t = t;
		}
	}
	
}