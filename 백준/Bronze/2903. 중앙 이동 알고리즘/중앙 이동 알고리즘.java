import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = pow(2, N) + 1;
		System.out.print(n * n);
		
	}
	
	static int pow(int num, int i) {
		int result = 1;
		for (int j = 0; j < i; j++) {
			result *= num;
		}
		return result;
	}
	
}