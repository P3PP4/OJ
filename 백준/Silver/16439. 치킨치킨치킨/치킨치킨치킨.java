import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, ans;
	static int[][] arr;
	static int[] select = new int[3];
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0, 0);
		
		System.out.print(ans);
		
	}
	
	static void find(int cnt, int start) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int max = 1;
				for (int j = 0; j < 3; j++) {
					if (max < arr[i][select[j]]) max = arr[i][select[j]];
				}
				sum += max;
			}
			if (ans < sum) ans = sum;
			
			return;
		}
		
		for (int i = start; i < M; i++) {
			select[cnt] = i;
			find(cnt + 1, i + 1);
		}
	}
	
}