import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(br.readLine());
		if (target > R * C) {
			System.out.print(0);
			return;
		}
		int[][] map = new int[R][C];
		int num = 0;
		int dir = 0;
		int r = 0;
		int c = 0;
		
		while (true) {
			map[r][c] = ++num;
			if (num == target) {
				System.out.print((c + 1) + " " + (r + 1));
				return;
			}
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || R <= nr || nc < 0 || C <= nc || map[nr][nc] != 0) {
				dir = (dir + 1) % 4;
				r += dr[dir];
				c += dc[dir];
				continue;
			}
			r = nr;
			c = nc;
		}
		
	}
	
}