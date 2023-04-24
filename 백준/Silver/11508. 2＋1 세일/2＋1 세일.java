import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		} // end of input
		
		Arrays.sort(input);
		int three = 0;
		int sum = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (++three == 3) three = 0;
			else sum += input[i];
		}
		
		System.out.print(sum);
	
	}
	
}