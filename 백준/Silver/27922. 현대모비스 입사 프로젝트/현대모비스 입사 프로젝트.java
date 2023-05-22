import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] input = new int[N][4];
		int[][] sum = new int[3][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
			sum[0][i] = input[i][0] + input[i][1];
			sum[1][i] = input[i][1] + input[i][2];
			sum[2][i] = input[i][0] + input[i][2];
		} // end of input
		
		Arrays.sort(sum[0]);
		Arrays.sort(sum[1]);
		Arrays.sort(sum[2]);
		
		int[] max = new int[3];
		for (int i = N - K; i < N; i++) {
			max[0] += sum[0][i];
			max[1] += sum[1][i];
			max[2] += sum[2][i];
		}
		
		System.out.print(Math.max(max[0], Math.max(max[1], max[2])));
		
	}
	
}