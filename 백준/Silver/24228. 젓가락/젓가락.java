import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BigInteger N = new BigInteger(st.nextToken());
		BigInteger R = new BigInteger(st.nextToken());
		System.out.print(N.add(R).add(R).subtract(BigInteger.ONE));
	
	}
	
}