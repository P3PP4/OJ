import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] dr = { -2, -2,  0,  0,  2,  2 };
		int[] dc = { -1,  1, -2,  2, -1,  1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] visited = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		visited[r1][c1] = 1;
		q.offer(new int[] { r1, c1 });
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			if (now[0] == r2 && now[1] == c2) {
				System.out.print(visited[now[0]][now[1]] - 1);
				return;
			}
			
			for (int dir = 0; dir < 6; dir++) {
				int nr = now[0] + dr[dir];
				int nc = now[1] + dc[dir];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && visited[nr][nc] == 0) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = visited[now[0]][now[1]] + 1;
				}
			}
		}
		
		System.out.print(-1);
	
	}
	
}