import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		long[] input = new long[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		
		for (int i = 1; i <= N; i++) {
			sum += input[i];
			if (K < sum) {
				System.out.print(i);
				return;
			}
		}
		for (int i = N; i > 0; i--) {
			sum += input[i];
			if (K < sum) {
				System.out.print(i);
				return;
			}
		}
	
	}
	
}