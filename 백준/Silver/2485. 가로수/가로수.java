import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, result, min = 1_000_000_000;
	static int[] input, data;
	
	public static void main(String[] args) throws Exception {
	
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		data = new int[N];
		input[0] = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			data[i] = input[i] - input[i - 1];
		} // end of input
		
		for (int i = 2; i < N; i++) {
			min = Math.min(min, euclidean(data[i], data[i - 1]));
		}
		
		for (int i = 1; i < N; i++) {
			result += (data[i] - 1) / min;
		}
		
		System.out.print(result);
		
	}
	
	static int euclidean(int a, int b) {
		int r = a % b;
		if (r == 0) return b;
		return euclidean(b, r);
	}
	
}