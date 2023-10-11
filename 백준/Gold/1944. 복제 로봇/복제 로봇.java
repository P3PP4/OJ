import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int[] dr = { -1,  0,  1,  0 };
	static int[] dc = {  0,  1,  0, -1 };
	static int N, M, cnt, sum;
	static PriorityQueue<Path> pq;
	static List<Pos> pos;
	static int[] parent;
	static int[][] visited;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		pos = new ArrayList<>();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'S' || map[i][j] == 'K') {
					pos.add(new Pos(i, j));
				}
			}
		}
		
		make();
		for (int i = 1; i < pos.size(); i++) {
			Pos p = pos.get(i);
			Queue<Pos> q = new LinkedList<>();
			visited = new int[N][N];
			q.offer(p);
			visited[p.r][p.c] = 1;
			
			while (!q.isEmpty()) {
				Pos now = q.poll();
				
				if ((map[now.r][now.c] == 'S' || map[now.r][now.c] == 'K') && visited[now.r][now.c] != 1) {
					for (int j = 0; j < pos.size(); j++) {
						if (pos.get(j).r == now.r && pos.get(j).c == now.c) {
							pq.add(new Path(i, j, visited[now.r][now.c]));
							break;
						}
					}
				}
				
				for (int dir = 0; dir < 4; dir++) {
					int nr = now.r + dr[dir];
					int nc = now.c + dc[dir];
					
					if (map[nr][nc] != '1' && visited[nr][nc] == 0) {
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = visited[now.r][now.c] + 1;
					}
				}
			}
		}
		
		while (!pq.isEmpty()) {
			Path path = pq.poll();
			if (union(path.from, path.to)) {
				sum += path.weight;
				
				if (++cnt == M) {
					System.out.print(sum - M);
					return;
				}
			}
		}
		
		System.out.print(-1);
	
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		if (a < b) parent[b] = a;
		else parent[a] = b;
		return true;
	}
	
	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void make() {
		parent = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			parent[i] = i;
		}
	}
	
	static class Path implements Comparable<Path> {
		int from, to, weight;
		
		public Path(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Path o) {
			return this.weight - o.weight;
		}
	}
	
	static class Pos {
		int r, c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}