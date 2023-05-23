import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dr = { 0,  0,  1 };
		int[] dc = { 1, -1,  K };
		char[][] map = new char[2][N];
		boolean[][] visited = new boolean[2][N];
		map[0] = br.readLine().toCharArray();
		map[1] = br.readLine().toCharArray();
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0 });
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			if (now[1] < now[2]) continue;
			
			for (int dir = 0; dir < 3; dir++) {
				int nr = (now[0] + dr[dir]) % 2;
				int nc = now[1] + dc[dir];
				
				if (N <= nc) {
					System.out.print(1);
					return;
				}
				
				if (0 <= nc && nc < N && map[nr][nc] == '1' && !visited[nr][nc]) {
					q.offer(new int[] { nr, nc, now[2] + 1 });
					visited[nr][nc] = true;
				}
			}
		}
		
		System.out.print(0);
	
	}
	
}