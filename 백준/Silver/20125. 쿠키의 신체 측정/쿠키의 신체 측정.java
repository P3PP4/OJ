import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		// 심장
		int[] heart = new int[2];
a:		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == '*') {
					heart[0] = i + 1;
					heart[1] = j;
					break a;
				}
			}
		}
		
		int nr, nc;
		
		// 팔
		int la = 1;
		nr = heart[0];
		for (int i = 2; i < N; i++) {
			nc = heart[1] - i;
			if (0 <= nc && board[nr][nc] == '*') la++;
			else break;
		}
		int ra = 1;
		for (int i = 2; i < N; i++) {
			nc = heart[1] + i;
			if (nc < N && board[nr][nc] == '*') ra++;
			else break;
		}
		
		// 허리
		int[] waist = new int[2];
		int len = 1;
		nc = heart[1];
		for (int i = 2; i < N; i++) {
			nr = heart[0] + i;
			if (nr < N && board[nr][nc] == '*') len++;
			else {
				waist[0] = nr - 1;
				waist[1] = nc;
				break;
			}
		}
		
		// 다리
		int ll = 1;
		nc = waist[1] - 1;
		for (int i = 2; i < N; i++) {
			nr = waist[0] + i;
			if (nr < N && board[nr][nc] == '*') ll++;
			else break;
		}
		int rl = 1;
		nc = waist[1] + 1;
		for (int i = 2; i < N; i++) {
			nr = waist[0] + i;
			if (nr < N && board[nr][nc] == '*') rl++;
			else break;
		}
		
		sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
		sb.append(la).append(" ").append(ra).append(" ").append(len).append(" ").append(ll).append(" ").append(rl);
		System.out.print(sb);
		
	}
	
}