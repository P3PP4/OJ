import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int[] dr = { -1, -1, -1,  0,  1,  1,  1,  0 };
		int[] dc = { -1,  0,  1,  1,  1,  0, -1, -1 };
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != '.') {
					sb.append('*');
					continue;
				}
				int cnt = 0;
				for (int dir = 0; dir < 8; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] != '.') cnt += map[nr][nc] - '0';
				}
				if (9 < cnt) sb.append('M');
				else sb.append(cnt);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
}