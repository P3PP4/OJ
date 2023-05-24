import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long l = 1;
		long r = 100000;
		while (l < r) {
			long mid = (l + r) >> 1;
			long num = (mid * (mid + 1)) >> 1;
			if (S < num) r = mid;
			else l = mid + 1;
		}
		
		System.out.print(l - 1);
	
	}
	
}