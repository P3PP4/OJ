import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, color;
	static int[] parent;
	static int[][] map;
	static int[] dr = { -1,  0,  1,  0 };
	static int[] dc = {  0,  1,  0, -1 };
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j * 2) - '0';
			}
		} // 입력 끝
		
		// 섬마다 고유한 색을 칠할 예정(다른 번호 부여)
		boolean[][] colored = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				
				// 섬이고 아직 색이 칠해지지 않았다면 bfs로 섬 전체에 색칠
				if(map[i][j] != 0 && !colored[i][j]) {
					
					color++;
					Queue<Pos> q = new LinkedList<>();
					q.offer(new Pos(i, j));
					map[i][j] = color;
					colored[i][j] = true;
					
					while(!q.isEmpty()) {
						
						Pos p = q.poll();
						
						for (int dir = 0; dir < 4; dir++) {
							
							int nr = p.row + dr[dir];
							int nc = p.col + dc[dir];
							
							if(0 <= nr && nr < N && 0 <= nc && nc < M && !colored[nr][nc] && map[nr][nc] != 0) {
								
								q.offer(new Pos(nr, nc));
								map[nr][nc] = color;
								colored[nr][nc] = true;
								
							}
							
						}
						
					}
					
				}
				
			}
			
		} // 색칠 끝
		
		// union-find 사용하기 위해 set을 만들고 PQ 선언
		make();
		PriorityQueue<Island> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				
				if(map[i][j] > 0) {
					
					// 이 섬의 색을 now에 저장
					int now = map[i][j];
					
					for (int dir = 0; dir < 4; dir++) {
						
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						int cnt = 1;
						
						// 상하좌우로 맵을 나가거나 다른 섬을 발견할 때까지 뻗어나갈 것
						while(true) {
							
							// 맵을 나가거나 같은 섬에 닿으면 탈출
							if(nr < 0 || N <= nr || nc < 0 || M <= nc || map[nr][nc] == now) break;
							
							// 바다면 한 칸 더 진행
							else if(map[nr][nc] == 0) {
								
								nr += dr[dir];
								nc += dc[dir];
								cnt++;
							
							// 다른 섬 발견
							} else if(map[nr][nc] != 0 && map[nr][nc] != now) {
								
								// 다리 짓기에 거리가 너무 짧으면 탈출
								if(cnt < 3) break;
								
								// 다리를 지을 수 있으면 PQ에 삽입 후 탈출
								pq.offer(new Island(now, map[nr][nc], cnt - 1));
								break;
								
							}
							
						}
						
					}
					
				}
				
			}
			
		} // 다리 후보를 모두 PQ에 저장했음
		
		int cnt = 1;
		int sum = 0;
		
		// MST 만들기
		while(!pq.isEmpty()) {
			
			Island i = pq.poll();
			
			if(union(i.from, i.to)) {
				
				sum += i.cost;
				
				if(++cnt == color) {
					
					// MST가 만들어졌다!
					System.out.println(sum);
					return;
					
				}
				
			}
			
		}
		
		// MST를 만들지 못했다면 -1 출력
		System.out.println(-1);
		
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
		
		if(a == parent[a]) return a;
		
		return parent[a] = find(parent[a]); 
		
	}
	
	static void make() {
		
		parent = new int[color + 1];
		
		for (int i = 1; i <= color; i++) {
			
			parent[i] = i;
			
		}
		
	}
	
	static class Island implements Comparable<Island> {
		
		int from, to, cost;

		public Island(int from, int to, int cost) {

			this.from = from;
			this.to = to;
			this.cost = cost;
			
		}

		@Override
		public int compareTo(Island o) {
			
			return this.cost - o.cost;
			
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