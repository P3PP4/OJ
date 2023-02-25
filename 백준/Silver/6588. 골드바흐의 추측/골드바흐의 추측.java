import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] notPrime = new boolean[1000001];
		for (int i = 2; i < 1000001; i++) {
			if (!notPrime[i]) {
				for (int j = i * 2; j < 1000001; j += i) {
					notPrime[j] = true;
				}
			}
		} // sieve of Eratosthenes
		
		while (true) {
		
			int N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			int a = 2;
			
			while (true) {
				
				// 둘 다 소수면
				if (!notPrime[a] && !notPrime[N - a]) {
					sb.append(N + " = " + a + " + " + (N - a) + "\n");
					break;
				}
				// 두 소수의 합으로 N을 나타낼 수가 없는 경우
				else if (N / 2 <= a) {
					sb.append("Goldbach's conjecture is wrong.\n");
					break;
				}
				else a++;
			
			}
			
		}
		
		System.out.print(sb);
	
	}
	
}