import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, a, b, cnt;
	static boolean[][] no;
	
	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		no = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			no[a][b] = no[b][a] = true;
		} // end of input
		
		for (int i = 1; i < N -1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (no[i][j] || no[j][i]) continue;
				for (int k = j + 1; k <= N; k++) {
					if (!no[i][k] && !no[j][k]) cnt++;
				}
			}
		}
		
		System.out.print(cnt);
	
	}
	
}