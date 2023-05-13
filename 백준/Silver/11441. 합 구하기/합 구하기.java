import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] sums = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			sums[i] = sums[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken());
			sb.append(sums[j] - sums[i]).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}