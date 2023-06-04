import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, n, min = 1234567;
	static int[][] input;
	static boolean[] team;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		n = N / 2;
		input = new int[N][N];
		team = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		make(0, 0);
		
		System.out.print(min);
	
	}
	
	static void make(int start, int cnt) {
		if (cnt == n) {
			int a = 0;
			int b = 0;
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (team[i] && team[j]) a += input[i][j] + input[j][i];
					else if (!team[i] && !team[j]) b += input[i][j] + input[j][i];
				}
			}
			
			int result = Math.abs(a - b);
			if (result < min) min = result;
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			team[i] = true;
			make(i + 1, cnt + 1);
			team[i] = false;
		}
	}
	
}