import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 1;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			n *= 2;
		}
		System.out.print(n);
	
	}
	
}