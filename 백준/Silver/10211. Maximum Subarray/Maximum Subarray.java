import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			int[] sum = new int[N + 1];
			int[] dp = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			arr[1] = Integer.parseInt(st.nextToken());
			sum[1] = arr[1];
			for (int i = 2; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + arr[i];
			}
			
			int max = -10000000;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < i; j++) {
					int temp = sum[i] - sum[j];
					if (max < temp) max = temp;
				}
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	
	}
	
}