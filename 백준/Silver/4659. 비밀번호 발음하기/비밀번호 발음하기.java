import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
		
			String input = br.readLine();
			
			if ("end".equals(input)) break;
			
			boolean flag = true;
			int moCnt = 0;
			int mo = 0;
			int ja = 0;
			char pre = '1';
			
			for (int i = 0; i < input.length(); i++) {
				
				char c = input.charAt(i);
				
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					moCnt++;
					ja = 0;
					if (++mo == 3) flag = false;
					if (pre == c && (c != 'e' && c != 'o')) flag = false;
				} else {
					mo = 0;
					if (++ja == 3) flag = false;
					if (pre == c) flag = false;
				}
				
				if (!flag) break;
				pre = c;
				
			}
			
			if (flag && 0 < moCnt) sb.append("<" + input + "> is acceptable.\n");
			else sb.append("<" + input + "> is not acceptable.\n");
			
		}
	
	    System.out.print(sb.toString());
		
    }

}