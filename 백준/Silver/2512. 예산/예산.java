import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int l = 0;
		int r = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if (r < input[i]) r = input[i];
		}
		int M = Integer.parseInt(br.readLine());
		
		while (l <= r) {
			int mid = (l + r) / 2;
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				sum += Math.min(input[i], mid);
			}
			
			if (sum <= M) l = mid + 1;
			else r = mid - 1;
		}
		
		System.out.print(r);
	
	}
	
}