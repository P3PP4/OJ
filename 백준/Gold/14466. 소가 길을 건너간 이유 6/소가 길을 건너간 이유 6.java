import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, R, result, cnt;
	static boolean[][] cow, visited;
	static boolean[][][] road;
	static int[] dr = { -1,  0,  1,  0 };
	static int[] dc = {  0,  1,  0, -1 };
	
	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 목초지 넓이
		K = Integer.parseInt(st.nextToken()); // 소
		R = Integer.parseInt(st.nextToken()); // 길
		cow = new boolean[N][N];
		road = new boolean[4][N][N];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int er = Integer.parseInt(st.nextToken()) - 1;
			int ec = Integer.parseInt(st.nextToken()) - 1;
			if (sr < er) road[2][sr][sc] = road[0][er][ec] = true;
			else if (er < sr) road[0][sr][sc] = road[2][er][ec] = true;
			else if (sc < ec) road[1][sr][sc] = road[3][er][ec] = true;
			else road[3][sr][sc] = road[1][er][ec] = true;
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			cow[r][c] = true;
		} // end of input
		
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cow[i][j]) {
					cnt = 0;
					visited = new boolean[N][N];
					visited[i][j] = true;
					q.offer(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] a = q.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nr = a[0] + dr[dir];
							int nc = a[1] + dc[dir];

							if (road[dir][a[0]][a[1]]) continue;
							
							if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
								visited[nr][nc] = true;
								q.offer(new int[] { nr, nc });
								
								if (cow[nr][nc]) cnt++;
							}
						}
					}
					
					result += K - cnt - 1;
				}
			}
		}
		
		System.out.print(result / 2);
		
	}
	
}