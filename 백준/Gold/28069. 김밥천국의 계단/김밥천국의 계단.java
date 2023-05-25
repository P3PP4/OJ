import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N <= K) {
			System.out.print("minigimbob");
			return;
		}
		
		while (K < N) {
			if (N % 3 == 2) N--;
			else N = N / 3 * 2 + (N % 3 == 0 ? 0 : 1);
			
			if (--K == 0) {
				System.out.print("water");
				return;
			}
		}
		
		System.out.print("minigimbob");
		
	}
	
}