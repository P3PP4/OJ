import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] max = new int[2];
	static int[][] board, left, color;
	static int[] dr = { -1, -1 };
	static int[] dc = { -1,  1 };
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		left  = new int[N][N];
		color = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) color[i][j] = 1;
			}
		} // 입력 끝
		
		int cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if(board[i][j] == 1) left[i][j] = ++cnt;
				else left[i][j] = cnt;
			}
		}
		
		dfs(0, 0, 0);
		dfs(0, 0, 1);
		System.out.print(max[0] + max[1]);
		
	}
	
	static void dfs(int index, int cnt, int c) {
		
		if(max[c] < cnt) max[c] = cnt;
		
		for (int i = index; i < N * N; i++) {
			
			int row = i / N;
			int col = i % N;
			
			if(max[c] - cnt > left[row][col]) return;
			
			if(board[row][col] == 1 && color[row][col] == c && isPromise(row, col)) {
				
				board[row][col] = 2;
				dfs(i + 1, cnt + 1, c);
				board[row][col] = 1;
				
			}
			
		}
		
	}
	
	static boolean isPromise(int row, int col) {
		
		for (int dir = 0; dir < 2; dir++) {
			
			int mul = 1;
			
			while(true) {
				
				int nr = row + dr[dir] * mul;
				int nc = col + dc[dir] * mul++;
				
				if(nr < 0 || nc < 0 || N <= nc) break;
				
				if(board[nr][nc] == 2) return false;
				
			}
			
		}
		
		return true;
		
	}
	
}