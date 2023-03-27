import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][][] arr = new int[2][N][N];
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		} // end of input
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if ((arr[0][i][k] & arr[1][k][j]) == 1) {
						++cnt;
						break;
					}
				}
			}
		}
		
		System.out.print(cnt);
		
	}
	
}