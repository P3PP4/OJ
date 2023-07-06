import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String B = br.readLine();
		int cnt = 0;
		while (st.hasMoreTokens()) {
			String A = st.nextToken();
			if (A.startsWith(B) && !B.equals(A)) cnt++;
		}
		System.out.print(cnt);
	
	}
	
}