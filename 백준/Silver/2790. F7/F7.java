import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int first = arr[N - 1] + 1;
		int cnt = 1;
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] + N >= first) cnt++;
			first = Math.max(first, arr[i] + N - i);
		}
		System.out.print(cnt);
		
	}
	
}