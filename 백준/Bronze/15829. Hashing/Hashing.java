import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		BigInteger M = new BigInteger("1234567891");
		char[] arr = br.readLine().toCharArray();
		BigInteger result = BigInteger.ZERO;
		for (int i = 0; i < L; i++) {
			BigInteger l = new BigInteger(arr[i] - 'a' + 1 + "");
			result = result.add(l.multiply(pow(i)));
		}
		System.out.print(result.mod(M));
	
	}
	
	static BigInteger pow(int n) {
		BigInteger ans = BigInteger.ONE;
		BigInteger p = new BigInteger("31");
		for (int i = 0; i < n; i++) {
			ans = ans.multiply(p);
		}
		return ans;
	}
	
}