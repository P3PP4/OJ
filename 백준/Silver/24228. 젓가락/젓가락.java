import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long N = Long.parseLong(st.nextToken());
		long R = Long.parseLong(st.nextToken());
		System.out.print(R * 2 + N - 1);
	
	}
	
}