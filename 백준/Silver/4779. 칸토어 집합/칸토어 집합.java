import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String temp = br.readLine();
			if (temp == null || temp.isEmpty()) break;
			
			int N = pow(Integer.parseInt(temp));
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb2.append("-");
			}
			sb.append(call(sb2)).append("\n");
		}
		System.out.print(sb);
		
	}
	
	static String call(StringBuilder s) {
		if (s.length() == 1) return "-";
		
		int len = s.length() / 3;
		StringBuilder space = new StringBuilder();
		for (int i = 0; i < len; i++) {
			space.append(" ");
		}
		StringBuilder s2 = new StringBuilder(s.substring(0, len));
		return call(s2) + space + call(s2);
	}
	
	static int pow(int i) {
		int result = 1;
		for (int j = 0; j < i; j++) {
			result *= 3;
		}
		return  result;
	}
	
}