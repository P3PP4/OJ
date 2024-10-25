import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		if (N < 3) {
			System.out.print(N);
			return;
		}
		
		long l = 0;
		long r = N;
		long res = 0;
		while (l <= r) {
			long m = (l + r) / 2;
			if (Math.pow(m, 2) < N) {
				l = m + 1;
			} else {
				r = m - 1;
				res = m;
			}
		}
		System.out.print(res);
		
	}
	
}