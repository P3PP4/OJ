import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, NN, sr, sc;
	static int[][] map;
	static int[][][][] visited;
	static int[] dr = { -2, -1,  1,  2,  2,  1, -1, -2, -1,  1,  1, -1, -1,  0,  1,  0 };
	static int[] dc = {  1,  2,  2,  1, -1, -2, -2, -1,  1,  1, -1, -1,  0,  1,  0, -1 };
	
	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(br.readLine());
		NN = N * N;
		map = new int[N][N];
		visited = new int[3][N * N + 1][N][N];
		sr = 0;
		sc = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					sr = i;
					sc = j;
				}
			}
		} // end of input
		
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(sr, sc, 0, 1));
		q.offer(new Pos(sr, sc, 1, 1));
		q.offer(new Pos(sr, sc, 2, 1));
		visited[0][1][sr][sc] = 1;
		visited[1][1][sr][sc] = 1;
		visited[2][1][sr][sc] = 1;
		
		while(!q.isEmpty()) {
			
			Pos p = q.poll();
			
			// 종료 조건
			if(map[p.row][p.col] == NN && p.num + 1 == NN) {
				System.out.println(visited[p.state][NN - 1][p.row][p.col] - 1);
				return;
			// 다음 숫자에 위치
			} else if(map[p.row][p.col] == p.num + 1) {
				q.offer(new Pos(p.row, p.col, p.state, p.num + 1));
				visited[p.state][p.num + 1][p.row][p.col] = visited[p.state][p.num][p.row][p.col];
			}
			
			// 제자리에서 말 바꾸기
			for (int i = 0; i < 3; i++) {
				
				if(visited[i][p.num][p.row][p.col] == 0) {

					q.offer(new Pos(p.row, p.col, i, p.num));
					visited[i][p.num][p.row][p.col] = visited[p.state][p.num][p.row][p.col] + 1;
					
				}
				
			}			
			
			// 나이트일 때 이동
			if(p.state == 0) {
				
				for (int dir = 0; dir < 8; dir++) {
					
					int nr = p.row + dr[dir];
					int nc = p.col + dc[dir];
					
					if(0 <= nr && nr < N && 0 <= nc && nc < N && visited[p.state][p.num][nr][nc] == 0) {
						
						q.offer(new Pos(nr, nc, p.state, p.num));
						visited[p.state][p.num][nr][nc] = visited[p.state][p.num][p.row][p.col] + 1;
						
					}
					
				}
				
			// 비숍이나 룩일 때 이동
			} else {

				for (int dir = 8; dir < 16; dir++) {
					
					if(p.state == 1 && 11 < dir) break;
					else if(p.state == 2 && dir < 12) continue;
					
					int nr = p.row + dr[dir];
					int nc = p.col + dc[dir];
					
					while(0 <= nr && nr < N && 0 <= nc && nc < N) {
						
						if(visited[p.state][p.num][nr][nc] == 0) {
							
							q.offer(new Pos(nr, nc, p.state, p.num));
							visited[p.state][p.num][nr][nc] = visited[p.state][p.num][p.row][p.col] + 1;
							
						}
						
						nr += dr[dir];
						nc += dc[dir];
						
					}
					
				}
				
			}
			
		}
		
	}
	
	static class Pos {

		int row, col, state, num;

		public Pos(int row, int col, int state, int num) {
			this.row = row;
			this.col = col;
			this.state = state;
			this.num = num;
		}
		
	}

}