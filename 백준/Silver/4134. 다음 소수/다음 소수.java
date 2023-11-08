import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			BigInteger bi = new BigInteger(br.readLine());
			if (bi.isProbablePrime(10)) sb.append(bi).append("\n");
			else sb.append(bi.nextProbablePrime()).append("\n");
		}
		System.out.print(sb);
	
	}
	
}