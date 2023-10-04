import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			for (int r = sr; r <= er; r++) {
				for (int c = sc; c <= ec; c++) {
					arr[r][c]++;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (M < arr[i][j]) cnt++;
			}
		}
		System.out.print(cnt);
	
	}
	
}