import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		long[] input = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		for (int i = 0; i < X; i++) {
			sum += input[i];
		}
		
		long max = sum;
		int cnt = 1;
		int tail = 0;
		for (int i = X; i < N; i++) {
			sum = sum + input[i] - input[tail++];
			if (max < sum) {
				max = sum;
				cnt = 1;
			} else if (max == sum) cnt++;
		}
		
		if (max == 0) System.out.print("SAD");
		else System.out.print(max + "\n" + cnt);
	
	}
	
}