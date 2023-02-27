import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, result;
	static int[][] arr;
	static int[][] drStick = { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } };
	static int[][] dcStick = { { 0, 1, 2, 3 }, { 0, 0, 0, 0 } };
	static int[][] drQuad = { { 0, 0, 1, 1 } };
	static int[][] dcQuad = { { 0, 1, 0, 1 } };
	static int[][] drL = { { 0, 1, 2, 2 }, { 0, 0, 0, -1 }, { 0, -1, -2, -2 }, { 0, 0, 0, 1 }, { 0, 1, 2, 2 }, { 0, 0, 0, -1 }, { 0, -1, -2, -2 }, { 0, 0, 0, 1 } };
	static int[][] dcL = { { 0, 0, 0, 1 }, { 0, 1, 2, 2 }, { 0, 0, 0, -1 }, { 0, -1, -2, -2 }, { 0, 0, 0, -1 }, { 0, -1, -2, -2 }, { 0, 0, 0, 1 }, { 0, 1, 2, 2 } };
	static int[][] drS = { { 0, 1, 1, 2 }, { 0, 0, -1, -1 }, { 0, 1, 1, 2 }, { 0, 0, -1, -1 } };
	static int[][] dcS = { { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, -1, -1 }, { 0, -1, -1, -2 } };
	static int[][] drT = { { 0, 0, 0, 1 }, { 0, -1, -2, -1 }, { 0, 0, 0, -1 }, { 0, 1, 2, 1 } };
	static int[][] dcT = { { 0, 1, 2, 1 }, { 0, 0, 0, 1 }, { 0, -1, -2, -1 }, { 0, 0, 0, -1 } };
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 행
		M = Integer.parseInt(st.nextToken());	// 열
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				
				findStick(i, j);
				findQuad(i, j);
				findL(i, j);
				findS(i, j);
				findT(i, j);
				
			}
			
		}
		
		System.out.println(result);
		
	}

	static void findStick(int i, int j) {
		
		for (int dir1 = 0; dir1 < 2; dir1++) {
			
			int sum = 0;
			
			for (int dir2 = 0; dir2 < 4; dir2++) {
				
				int nextR = i + drStick[dir1][dir2];
				int nextC = j + dcStick[dir1][dir2];
				
				if(0 <= nextR && nextR < N && 0 <= nextC && nextC < M) {
					
					sum += arr[nextR][nextC];
					
				}
				
			}
			
			if(sum > result) result = sum;
			
		}
		
	}
	
	static void findQuad(int i, int j) {
		
		int sum = 0;
		
		for (int dir2 = 0; dir2 < 4; dir2++) {
			
			int nextR = i + drQuad[0][dir2];
			int nextC = j + dcQuad[0][dir2];
			
			if(0 <= nextR && nextR < N && 0 <= nextC && nextC < M) {
				
				sum += arr[nextR][nextC];
				
			}
			
		}
		
		if(sum > result) result = sum;
		
	}

	static void findL(int i, int j) {
		
		for (int dir1 = 0; dir1 < 8; dir1++) {
			
			int sum = 0;
			
			for (int dir2 = 0; dir2 < 4; dir2++) {
				
				int nextR = i + drL[dir1][dir2];
				int nextC = j + dcL[dir1][dir2];
				
				if(0 <= nextR && nextR < N && 0 <= nextC && nextC < M) {
					
					sum += arr[nextR][nextC];
					
				}
				
			}
			
			if(sum > result) result = sum;
			
		}
		
	}

	static void findS(int i, int j) {
		
		for (int dir1 = 0; dir1 < 4; dir1++) {
			
			int sum = 0;
			
			for (int dir2 = 0; dir2 < 4; dir2++) {
				
				int nextR = i + drS[dir1][dir2];
				int nextC = j + dcS[dir1][dir2];
				
				if(0 <= nextR && nextR < N && 0 <= nextC && nextC < M) {
					
					sum += arr[nextR][nextC];
					
				}
				
			}
			
			if(sum > result) result = sum;
			
		}
		
	}

	static void findT(int i, int j) {
		
		for (int dir1 = 0; dir1 < 4; dir1++) {
			
			int sum = 0;
			
			for (int dir2 = 0; dir2 < 4; dir2++) {
				
				int nextR = i + drT[dir1][dir2];
				int nextC = j + dcT[dir1][dir2];
				
				if(0 <= nextR && nextR < N && 0 <= nextC && nextC < M) {
					
					sum += arr[nextR][nextC];
					
				}
				
			}
			
			if(sum > result) result = sum;
			
		}
		
	}
	
}