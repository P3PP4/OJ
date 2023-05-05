import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] input = new long[N];
		long l = 0;
		long r = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());
			if (r < input[i]) r = input[i];
		}
		
		while (l < r) {
			long m = (l + r) >> 1;
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				if (m < input[i]) sum += input[i] - m;
			}
			
			if (sum < K) r = m;
			else l = m + 1;
		}
		
		System.out.print(l - 1);
		
	}
	
}