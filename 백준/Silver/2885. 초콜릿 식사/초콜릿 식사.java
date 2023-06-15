import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int size = 1;
		while (size < K) size <<= 1;
		
		int cnt = 0;
		int sum = size;
		int next = size;
		while (sum != K) {
			cnt++;
			next >>= 1;
			if (K <= sum - next) {
				sum -= next;
			}
		}
		
		System.out.print(size + " " + cnt);
		
	}
	
}