import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		BigInteger[] fibo = new BigInteger[10001];
		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;
		for (int i = 2; i < 10001; i++) {
			fibo[i] = fibo[i - 2].add(fibo[i - 1]);
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			BigInteger Q = new BigInteger(st.nextToken());
			sb.append("Case #").append(tc).append(": ").append(fibo[P].mod(Q)).append("\n");
		}
		System.out.print(sb);
	
	}
	
}