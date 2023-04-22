import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long ja1 = Integer.parseInt(st.nextToken());
		long mo1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		long ja2 = Integer.parseInt(st.nextToken());
		long mo2 = Integer.parseInt(st.nextToken());
		// end of input
		
		long mo3 = lcm(mo1, mo2);
		long ja3 = ja1 * mo3 / mo1 + ja2 * mo3 / mo2;
		
		while (true) {
			long gcd = gcd(ja3, mo3);
			if (gcd == 1) break;
			ja3 /= gcd;
			mo3 /= gcd;
		}
		
		System.out.print(ja3 + " " + mo3);
	
	}
	
	static long gcd(long a, long b) {
		if (a % b == 0) return b;
		return gcd(b, a % b);
	}
	
	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
}