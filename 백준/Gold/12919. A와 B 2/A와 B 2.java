import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String S, B;
	static int len;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		B = br.readLine();
		len = S.length();
		
		find(B);
		
		System.out.print(0);
		
	}
	
	static void find(String s) {
		if (s.length() < len) return;
		
		if (s.equals(S)) {
			System.out.print(1);
			System.exit(0);
		}
		
		if (s.charAt(s.length() - 1) == 'A') find(s.substring(0, s.length() - 1));
		if (s.charAt(0) == 'B') find(new StringBuilder(s.substring(1)).reverse().toString());
	}
	
}