import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		String head = st.nextToken();
		String tail = st.nextToken();
		int len = head.length() + tail.length();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.startsWith(head) && input.endsWith(tail) && len <= input.length()) sb.append("DA\n");
			else sb.append("NE\n");
		}
		
		System.out.print(sb);
		
	}
	
}