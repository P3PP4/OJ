import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int n = N * N;
		int[] pos = new int[2];
		int dir = 0;
		int r = 0;
		int c = 0;
		
		while (n > 0) {
			if (n == target) {
				pos[0] = r + 1;
				pos[1] = c + 1;
			}
			
			map[r][c] = n--;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || N <= nr || nc < 0 || N <= nc || map[nr][nc] != 0) {
				dir = (dir + 1) % 4;
				r = r + dr[dir];
				c = c + dc[dir];
			} else {
				r = nr;
				c = nc;
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(pos[0]).append(" ").append(pos[1]);
		System.out.print(sb);
		
	}
	
}