import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] notPrime = new boolean[1000001];
		for (int i = 2; i < 1000001; i++) {
			if (!notPrime[i]) {
				for (int j = i + i; j < 1000001; j += i) {
					notPrime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int i = 2; i <= N / 2; i++) {
				if (!notPrime[i] && !notPrime[N - i]) cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}