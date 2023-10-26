import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = br.readLine();
			if ("EOI".equals(s)) break;
			s = s.toUpperCase();
			if (s.contains("NEMO")) sb.append("Found\n");
			else sb.append("Missing\n");
		}
		System.out.print(sb);
	
	}
	
}