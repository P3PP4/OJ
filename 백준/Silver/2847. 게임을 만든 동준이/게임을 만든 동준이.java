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
		
		int num = input[N - 1];
		int sum = 0;
		for (int i = N - 2; i >= 0; i--) {
			if (input[i] >= num) {
				sum += input[i] - num + 1;
				input[i] = num - 1;
			}
			num = input[i];
		}
		System.out.print(sum);
	
	}
	
}