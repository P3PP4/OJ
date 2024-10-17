import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		long[] sum = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			sum[M - 1] += arr[i];
		}
		long max = sum[M - 1];
		for (int i = M; i < N; i++) {
			sum[i] = sum[i - 1] - arr[i - M] + arr[i];
			if (max < sum[i]) max = sum[i];
		}
		System.out.print(max);
	
	}
	
}