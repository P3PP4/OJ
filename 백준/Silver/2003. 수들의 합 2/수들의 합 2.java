import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] input = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + input[i];
		}
		
		int head = 1;
		int tail = 0;
		int cnt = 0;
		while (head <= N) {
			int num = sum[head] - sum[tail];
			if (num == M) {
				cnt++;
				tail++;
				head = tail + 1;
			} else if (M < num) tail++;
			else head++;
		}
		System.out.print(cnt);
		
	}
	
}