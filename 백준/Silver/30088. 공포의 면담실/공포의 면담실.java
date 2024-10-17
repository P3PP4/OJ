import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] sum = new long[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int employees = Integer.parseInt(st.nextToken());
			for (int j = 0; j < employees; j++) {
				sum[i] += Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(sum);
		long[] add = new long[N];
		long ans = add[0] = sum[0];
		for (int i = 1; i < N; i++) {
			add[i] = add[i - 1] + sum[i];
			ans += add[i];
		}
		System.out.print(ans);
		
	}
	
}