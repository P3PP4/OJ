import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] input = new int[1000001];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			input[x] = g;
		}
		
		int sum = 0;
		int max = 0;
		int bound = K * 2;
		for (int i = 0; i < 1000001; i++) {
			if (bound < i) sum -= input[i - bound - 1];
			sum += input[i];
			if (max < sum) max = sum;
		}
		
		System.out.print(max);
	
	}
	
}