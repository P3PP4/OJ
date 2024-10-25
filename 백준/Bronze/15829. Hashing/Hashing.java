import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		long M = 1_234_567_891;
		char[] arr = br.readLine().toCharArray();
		long result = 0;
		for (int i = 0; i < L; i++) {
			long l = arr[i] - 'a' + 1;
			result += (l * pow(i)) % M;
		}
		System.out.print(result);
	
	}
	
	static long pow(int n) {
		long ans = 1;
		for (int i = 0; i < n; i++) {
			ans *= 31;
		}
		return ans;
	}
	
}