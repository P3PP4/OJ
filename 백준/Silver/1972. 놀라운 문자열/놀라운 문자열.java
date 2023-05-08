import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String line = br.readLine();
			if ("*".equals(line)) break;
			
			int len = line.length();
			boolean flag = true;
			
			for (int i = 1; i < len; i++) {
				HashSet<String> set = new HashSet<>();
				
				for (int j = 0; j < len - i; j++) {
					String s = "" + line.charAt(j) + line.charAt(j + i);
					set.add(s);
				}
				
				if (set.size() != len - i) {
					flag = false;
					break;
				}
			}
			
			if (flag) sb.append(line).append(" is surprising.\n");
			else sb.append(line).append(" is NOT surprising.\n");
		}
		
		System.out.print(sb);
	
	}
	
}