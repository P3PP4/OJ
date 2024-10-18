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
	static int m, n, o, p, q, r, s, t, u, v, w, cnt;
	static int[][][][][][][][][][][] box, visited;
	static Queue<Tomato> queue = new LinkedList<Tomato>();
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		o = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		box = new int[w][v][u][t][s][r][q][p][o][n][m];
		visited = new int[w][v][u][t][s][r][q][p][o][n][m];
		for (int W = 0; W < w; W++) {
			for (int V = 0; V < v; V++) {
				for (int U = 0; U < u; U++) {
					for (int T = 0; T < t; T++) {
						for (int S = 0; S < s; S++) {
							for (int R = 0; R < r; R++) {
								for (int Q = 0; Q < q; Q++) {
									for (int P = 0; P < p; P++) {
										for (int O = 0; O < o; O++) {
											for (int N = 0; N < n; N++) {
												st = new StringTokenizer(br.readLine(), " ");
												for (int M = 0; M < m; M++) {
													box[W][V][U][T][S][R][Q][P][O][N][M] = Integer.parseInt(st.nextToken());
													if(box[W][V][U][T][S][R][Q][P][O][N][M] == 0) cnt++;
													else if(box[W][V][U][T][S][R][Q][P][O][N][M] == 1) {
														visited[W][V][U][T][S][R][Q][P][O][N][M] = 1;
														queue.offer(new Tomato(W, V, U, T, S, R, Q, P, O, N, M));
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} // 입력 끝
		
		if(cnt == 0) {
			
			System.out.println(0);
			return;
			
		}
		
		while(!queue.isEmpty()) {
			
			Tomato to = queue.poll();

			if(0 <= to.m - 1 && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m - 1] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m - 1] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q, to.p, to.o, to.n, to.m - 1));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m - 1] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.m + 1 < m && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m + 1] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m + 1] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q, to.p, to.o, to.n, to.m + 1));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m + 1] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}

			if(0 <= to.n - 1 && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n - 1][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n - 1][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q, to.p, to.o, to.n - 1, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n - 1][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.n + 1 < n && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n + 1][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n + 1][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q, to.p, to.o, to.n + 1, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n + 1][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.o - 1 && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o - 1][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o - 1][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q, to.p, to.o - 1, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o - 1][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.o + 1 < o && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o + 1][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o + 1][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q, to.p, to.o + 1, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o + 1][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.p - 1 && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p - 1][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p - 1][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q, to.p - 1, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p - 1][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.p + 1 < p && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p + 1][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p + 1][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q, to.p + 1, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p + 1][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.q - 1 && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q - 1][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q - 1][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q - 1, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q - 1][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.q + 1 < q && visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q + 1][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r][to.q + 1][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r, to.q + 1, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q + 1][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.r - 1 && visited[to.w][to.v][to.u][to.t][to.s][to.r - 1][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r - 1][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r - 1, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r - 1][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.r + 1 < r && visited[to.w][to.v][to.u][to.t][to.s][to.r + 1][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s][to.r + 1][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s, to.r + 1, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s][to.r + 1][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.s - 1 && visited[to.w][to.v][to.u][to.t][to.s - 1][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s - 1][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s - 1, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s - 1][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.s + 1 < s && visited[to.w][to.v][to.u][to.t][to.s + 1][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t][to.s + 1][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t, to.s + 1, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t][to.s + 1][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.t - 1 && visited[to.w][to.v][to.u][to.t - 1][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t - 1][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t - 1, to.s, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t - 1][to.s][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.t + 1 < t && visited[to.w][to.v][to.u][to.t + 1][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u][to.t + 1][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u, to.t + 1, to.s, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u][to.t + 1][to.s][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.u - 1 && visited[to.w][to.v][to.u - 1][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u - 1][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u - 1, to.t, to.s, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u - 1][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.u + 1 < u && visited[to.w][to.v][to.u + 1][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v][to.u + 1][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v, to.u + 1, to.t, to.s, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v][to.u + 1][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.v - 1 && visited[to.w][to.v - 1][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v - 1][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v - 1, to.u, to.t, to.s, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v - 1][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.v + 1 < v && visited[to.w][to.v + 1][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w][to.v + 1][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w, to.v + 1, to.u, to.t, to.s, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w][to.v + 1][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
			if(0 <= to.w - 1 && visited[to.w - 1][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w - 1][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w - 1, to.v, to.u, to.t, to.s, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w - 1][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			if(to.w + 1 < w && visited[to.w + 1][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0 && box[to.w + 1][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] == 0) {
				queue.offer(new Tomato(to.w + 1, to.v, to.u, to.t, to.s, to.r, to.q, to.p, to.o, to.n, to.m));
				visited[to.w + 1][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] = visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m] + 1;
				cnt--;
			}
			if(cnt == 0) {
				System.out.println(visited[to.w][to.v][to.u][to.t][to.s][to.r][to.q][to.p][to.o][to.n][to.m]);
				return;
			}
			
		}
		
		System.out.println(-1);
		
	}
	
	static class Tomato {
		
		int w, v, u, t, s, r, q, p, o, n, m;

		public Tomato(int w, int v, int u, int t, int s, int r, int q, int p, int o, int n, int m) {

			this.w = w;
			this.v = v;
			this.u = u;
			this.t = t;
			this.s = s;
			this.r = r;
			this.q = q;
			this.p = p;
			this.o = o;
			this.n = n;
			this.m = m;
			
		}

	}
	
}