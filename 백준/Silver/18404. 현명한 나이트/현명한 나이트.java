import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int[] dr = { -2, -1,  1,  2,  2,  1, -1, -2 };
		int[] dc = {  1,  2,  2,  1, -1, -2, -2, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		int[][] visited = new int[N + 1][N + 1];
		int[] time = new int[M + 1];
		Queue<int[]> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		q.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = i;
		}
		
		while (!q.isEmpty()) {
			int[] a = q.poll();
			
			if (map[a[0]][a[1]] != 0) time[map[a[0]][a[1]]] = visited[a[0]][a[1]];
			
			for (int dir = 0; dir < 8; dir++) {
				int nr = a[0] + dr[dir];
				int nc = a[1] + dc[dir];
				
				if (0 < nr && nr <= N && 0 < nc && nc <= N && visited[nr][nc] == 0) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = visited[a[0]][a[1]] + 1;
				}
			}
		}
		
		for (int i = 1; i <= M; i++) {
			sb.append(time[i]).append(" ");
		}
		System.out.print(sb);
	
	}
	
}