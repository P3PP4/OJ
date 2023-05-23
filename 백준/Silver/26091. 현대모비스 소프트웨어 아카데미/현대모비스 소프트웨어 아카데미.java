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
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // end of input
		
		Arrays.sort(arr);
		int head = 0;
		int tail = N - 1;
		int cnt = 0;
		
		while (head < tail) {
			int num = arr[head] + arr[tail];
			if (M <= num) {
				cnt++;
				head++;
				tail--;
			} else head++;
		}
		
		System.out.print(cnt);
	
	}
	
}