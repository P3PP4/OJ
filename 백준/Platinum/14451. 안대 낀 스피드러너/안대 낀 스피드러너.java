import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // end of input
		
		int n = N - 1;
		int time = 0;
		int[] dr = { -1,  0,  1,  0 };
		int[] dc = {  0,  1,  0, -1 };
		boolean[][][][][][] visited = new boolean[N][N][4][N][N][4];
		visited[n][0][0][n][0][1] = true;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(n, 0, 0, n, 0, 1, false, false));
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while (0 < size--) {
				Pos p = q.poll();
				
				if (!p.up && p.i1 == 0 && p.j1 == n) p.up = true;
				if (!p.right && p.i2 == 0 && p.j2 == n) p.right = true;
				
				if (p.up && p.right) {
					System.out.print(time);
					return;
				}
				
				// 좌회전
				int nd1 = p.d1 == 0 ? 3 : p.d1 - 1;
				int nd2 = p.d2 == 0 ? 3 : p.d2 - 1;
				if (!visited[p.i1][p.j1][nd1][p.i2][p.j2][nd2]) {
					q.offer(new Pos(p.i1, p.j1, nd1, p.i2, p.j2, nd2, p.up, p.right));
					visited[p.i1][p.j1][nd1][p.i2][p.j2][nd2] = true;
				}
				
				// 우회전
				nd1 = p.d1 == 3 ? 0 : p.d1 + 1;
				nd2 = p.d2 == 3 ? 0 : p.d2 + 1;
				if (!visited[p.i1][p.j1][nd1][p.i2][p.j2][nd2]) {
					q.offer(new Pos(p.i1, p.j1, nd1, p.i2, p.j2, nd2, p.up, p.right));
					visited[p.i1][p.j1][nd1][p.i2][p.j2][nd2] = true;
				}
				
				// 전진
				int nr1 = p.i1;
				int nc1 = p.j1;
				if (!(nr1 == 0 && nc1 == n)) {
					nr1 += dr[p.d1];
					nc1 += dc[p.d1];
					if (nr1 < 0 || n < nr1 || nc1 < 0 || n < nc1 || map[nr1][nc1] == 'H') {
						nr1 -= dr[p.d1];
						nc1 -= dc[p.d1];
					}
				}
				int nr2 = p.i2;
				int nc2 = p.j2;
				if (!(nr2 == 0 && nc2 == n)) {
					nr2 += dr[p.d2];
					nc2 += dc[p.d2];
					if (nr2 < 0 || n < nr2 || nc2 < 0 || n < nc2 || map[nr2][nc2] == 'H') {
						nr2 -= dr[p.d2];
						nc2 -= dc[p.d2];
					}
				}
				
				if (!visited[nr1][nc1][p.d1][nr2][nc2][p.d2]) {
					q.offer(new Pos(nr1, nc1, p.d1, nr2, nc2, p.d2, p.up, p.right));
					visited[nr1][nc1][p.d1][nr2][nc2][p.d2] = true;
				}
			}
			
			time++;
		}
	
	}
	
	static class Pos {
		int i1, j1, d1, i2, j2, d2;
		boolean up, right;
		
		public Pos(int i1, int j1, int d1, int i2, int j2, int d2, boolean up, boolean right) {
			this.i1 = i1;
			this.j1 = j1;
			this.d1 = d1;
			this.i2 = i2;
			this.j2 = j2;
			this.d2 = d2;
			this.up = up;
			this.right = right;
		}
	}
	
}