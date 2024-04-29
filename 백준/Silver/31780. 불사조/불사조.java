import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sum = X;
		for (int i = 0; i < M; i++) {
			sum += X;
		}
		System.out.print(sum);
	
	}
	
}