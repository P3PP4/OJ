import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) * 2;
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		int end = N - 1;
		int min = 999999;
		for (int i = 0; i < N / 2; i++) {
			int sum = input[i] + input[end--];
			if (sum < min) min = sum;
		}
		
		System.out.print(min);
	
	}
	
}