import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, max;
	static int[] input, arr;
	static boolean[] used;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		arr = new int[N];
		used = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		find(0);
		
		System.out.print(max);
	
	}
	
	static void find(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 1; i < N; i++) {
				sum += Math.abs(arr[i - 1] - arr[i]);
			}
			if (sum > max) max = sum;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[cnt] = input[i];
				find(cnt + 1);
				used[i] = false;
			}
		}
	}
	
}