import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long ans = 0;
		long sum = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			long input = Integer.parseInt(st.nextToken());
			ans = ans + input * sum;
			sum += input;
		}
		System.out.print(ans);
	
	}
	
}