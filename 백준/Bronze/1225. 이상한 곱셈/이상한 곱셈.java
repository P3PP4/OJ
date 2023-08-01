import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String strA = st.nextToken();
		String strB = st.nextToken();
		long sum = 0;
		for (int i = 0; i < strA.length(); i++) {
			for (int j = 0; j < strB.length(); j++) {
				sum += (strA.charAt(i) - '0') * (strB.charAt(j) - '0');
			}
		}
		System.out.print(sum);
	
	}
	
}