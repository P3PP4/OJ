import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map = new char[5][5];
	static boolean[][] promise = new boolean[5][5];
	static int sum;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		make(0, 0);
		System.out.print(sum);
		
	}
	
	static void check() {
		
		int s = 0;
		int y = 0;
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (promise[i][j]) {
					q.offer(new int[] { i, j });
					visited[i][j] = true;
					
					while (!q.isEmpty()) {
						int[] now = q.poll();
						int r = now[0];
						int c = now[1];
						
						if (map[r][c] == 'Y') y++;
						if (map[r][c] == 'S') s++;
						
						for (int dir = 0; dir < 4; dir++) {
							int nr = now[0] + dr[dir];
							int nc = now[1] + dc[dir];
							
							if (0 <= nr && nr < 5 && 0 <= nc && nc < 5 && promise[nr][nc] && !visited[nr][nc]) {
								q.offer(new int[] { nr, nc });
								visited[nr][nc] = true;
								cnt++;
							}
						}
					}
					
					if (cnt == 7 && y < s) sum++;
					
					return;
				}
			}
		}
		
	}
	
	static void make(int n, int cnt) {
		
		if (cnt == 7) {
			check();
			return;
		}
		
		for (int i = n; i < 25; i++) {
			int r = i / 5;
			int c = i % 5;
			promise[r][c] = true;
			make(i + 1, cnt + 1);
			promise[r][c] = false;
		}
	
	}
	
}