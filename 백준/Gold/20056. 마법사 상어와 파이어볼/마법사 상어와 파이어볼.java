import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K, result;
	static int[][] map;
	static int[] dr = { -1, -1,  0,  1,  1,  1,  0, -1 };
	static int[] dc = {  0,  1,  1,  1,  0, -1, -1, -1 };
	static ArrayList<Fire> list = new ArrayList<Fire>();
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 격자 크기
		M = Integer.parseInt(st.nextToken());	// 파이어볼 수
		K = Integer.parseInt(st.nextToken());	// 명령 수
		map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;	// r
			int c = Integer.parseInt(st.nextToken()) - 1;	// c
			int m = Integer.parseInt(st.nextToken());		// 질량
			int s = Integer.parseInt(st.nextToken());		// 속도
			int d = Integer.parseInt(st.nextToken());		// 방향
			list.add(new Fire(r, c, m, s, d));
			map[r][c]++;
		} // 입력 끝
		
		for (int i = 0; i < K; i++) {
			
			order();
			
		}
		
		for (Fire fire : list) {
			
			result += fire.m;
			
		}
		
		System.out.println(result);
		
	}
	
	static void order() {
		
		int size = list.size();
		
		for(int i = 0; i < size; i++) {
			
			Fire current = list.get(i);
			
			int nextR = (current.r + dr[current.d] * current.s) % N;
			int nextC = (current.c + dc[current.d] * current.s) % N;
			
			if(nextR < 0) nextR += 	N;
			else if(N <= nextR) nextR -= N;
			if(nextC < 0) nextC += N;
			else if(N <= nextC) nextC -= N;
			
			map[current.r][current.c]--;
			map[nextR][nextC]++;
			
			list.get(i).r = nextR;
			list.get(i).c = nextC;
			
		}
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < N; j++) {
				
				if(map[i][j] > 1) {
					
					split(i, j, map[i][j]);
					
				}
				
			}
			
		}
		
	}
	
	// 합쳤다가 네 방향으로 나눠
	static void split(int i, int j, int fires) {
		
		boolean flag = true;
		int sumM = 0;
		int sumS = 0;
		int dir = -1;
		
		for (int idx = list.size() - 1; idx >= 0; idx--) {
			
			Fire fire = list.get(idx);
			
			if(fire.r == i && fire.c == j) {
				
				sumM += fire.m;
				sumS += fire.s;
				if(dir == -1) dir = fire.d;
				else if(dir % 2 != fire.d % 2) flag = false;
				
				list.remove(idx);
				
			}
			
		}
		
		int newM = sumM / 5;
		int newS = sumS / fires;
		int newD = flag ? 0 : 1;
		
		if(newM > 0) {
			
			for (int k = 0; k < 4; k++) {
				
				list.add(new Fire(i, j, newM, newS, newD));
				newD += 2;
				
			}
			
			map[i][j] = 4;
			
		} else map[i][j] = 0;
		
		
	}
	
	static class Fire {
		
		int r, c, m, s, d;

		public Fire(int r, int c, int m, int s, int d) {

			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			
		}
		
	}
	
}