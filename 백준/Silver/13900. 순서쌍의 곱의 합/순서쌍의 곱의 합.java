import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] input = new long[N];
		long[] sum = new long[N];
		long[] ans = new long[N];
		input[0] = sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + input[i];
			ans[i] = ans[i - 1] + input[i] * sum[i - 1];
		}
		System.out.print(ans[N - 1]);
	
	}
	
}