import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] input = new int[M];
		for (int i = 0; i < M; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		int maxPrice = 0;
		int maxAmount = 0;
		
		for (int i = 0; i < M; i++) {
			int temp = input[i];
			int cnt = Math.min(N, M - i);
			int amount = temp * cnt;
			if (amount > maxAmount) {
				maxPrice = input[i];
				maxAmount = amount;
			}
		}
		
		System.out.print(maxPrice + " " + maxAmount);
	
	}
	
}