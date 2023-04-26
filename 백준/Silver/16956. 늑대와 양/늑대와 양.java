import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = line.charAt(j);
				map[i][j] = c;
				if (c == 'S') list.add(new int[] { i, j });
				if (c == '.') map[i][j] = 'D';
			}
		}
		
		int[] dr = { -1,  0,  1,  0 };
		int[] dc = {  0,  1,  0, -1 };
		for (int[] pos : list) {
			for (int dir = 0; dir < 4; dir++) {
				int nr = pos[0] + dr[dir];
				int nc = pos[1] + dc[dir];
				if (0 <= nr && nr < R && 0 <= nc && nc < C) {
					if (map[nr][nc] == 'W') {
						System.out.print(0);
						return;
					}
				}
			}
		}
		
		System.out.println(1);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	
	}
	
}