import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K, cnt, time;
	static int[] parent;
	static int[][] map;
	static int[] dr = { -1,  0,  1,  0 };
	static int[] dc = {  0,  1,  0, -1 };
	static Queue<Pos> q = new LinkedList<Pos>();
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 배열 크기
		K = Integer.parseInt(st.nextToken());	// 문명 수
		map = new int[N][N];
		make();
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			map[row][col] = i;
			q.offer(new Pos(row, col));
			for (int dir = 0; dir < 4; dir++) {
				int nr = row + dr[dir];
				int nc = col + dc[dir];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] != 0 && map[nr][nc] != map[row][col]) {
					if(union(map[nr][nc], map[row][col])) cnt++;
				}
			}
		} // 입력 끝
		
		K--;
		if(cnt == K) {
			System.out.println(0);
			return;
		}
		
		while(true) {
			
			int size = q.size();
			
			while (size-- > 0) {
				
				Pos now = q.poll();
				
				for (int dir = 0; dir < 4; dir++) {

					int nr = now.row + dr[dir];
					int nc = now.col + dc[dir];

					if (0 <= nr && nr < N && 0 <= nc && nc < N) {

						if (map[nr][nc] == 0) {

							q.offer(new Pos(nr, nc));
							map[nr][nc] = map[now.row][now.col];
							
							for (int i = 0; i < 4; i++) {
								
								int nnr = nr + dr[i];
								int nnc = nc + dc[i];
								
								if (0 <= nnr && nnr < N && 0 <= nnc && nnc < N && map[nnr][nnc] != 0 && map[nr][nc] != map[nnr][nnc]) {
									
									if(union(map[nr][nc], map[nnr][nnc])) cnt++;

								}
								
							}

						} else if (map[nr][nc] != map[now.row][now.col]) {

							if(union(map[now.row][now.col], map[nr][nc])) cnt++;
							
						}

					}

					if (cnt == K) {

						System.out.println(time + 1);
						return;

					}

				}
				
			}
			
			time++;
			
		}
		
	}
	
	static boolean union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a == b) return false;
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
		return true;
		
	}
	
	static int find(int a) {
		
		if(parent[a] == a) return a;
		
		return parent[a] = find(parent[a]); 
		
	}
	
	static void make() {
		
		parent = new int[K + 1];
		
		for (int i = 1; i <= K; i++) {
			
			parent[i] = i; 
			
		}
		
	}
	
	static class Pos {
		
		int row, col;

		public Pos(int row, int col) {

			this.row = row;
			this.col = col;
			
		}
		
	}

}
