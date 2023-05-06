import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] input = new int[K];
		long l = 0;
		long r = 0;
		for (int i = 0; i < K; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if (r < input[i]) r = input[i];
		}
		r++;
		
		while (l < r) {
			long m = (l + r) >> 1;
			long sum = 0;
			
			for (int i = 0; i < K; i++) {
				sum += input[i] / m;
			}
			
			if (sum < N) r = m;
			else l = m + 1;
		}
		
		System.out.print(l - 1);
		
	}
	
}