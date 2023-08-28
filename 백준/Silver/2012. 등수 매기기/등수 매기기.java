import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] input = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(input);
		long result = 0;
		for (int i = 1; i <= N; i++) {
			result += Math.abs(i - input[i]);
		}
		System.out.print(result);
	
	}
	
}