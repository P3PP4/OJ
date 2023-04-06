import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (max < input[i]) {
				cnt++;
				max = input[i];
			}
		}
		
		System.out.print(cnt);
	
	}
	
}