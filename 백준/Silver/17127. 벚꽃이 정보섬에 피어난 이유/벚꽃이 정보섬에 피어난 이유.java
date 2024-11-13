import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // end of input
		
		int cut = N - 3;
		int max = 0;
		for (int i = 0; i <= N - cut; i++) {
			boolean[] check = new boolean[N];
			int sum = 1;
			for (int j = i; j < i + cut; j++) {
				sum *= arr[j];
				check[j] = true;
			}
			for (int j = 0; j < N; j++) {
				if (!check[j]) sum += arr[j];
			}
			if (max < sum) max = sum;
		}
		System.out.print(max);
	
	}
	
}