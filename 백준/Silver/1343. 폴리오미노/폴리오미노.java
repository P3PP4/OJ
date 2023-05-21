import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int len = input.length;
		for (int i = 0; i < len; i++) {
			if (input[i] == 'X') {
				if (i + 3 < len && input[i + 1] == 'X' && input[i + 2] == 'X' && input[i + 3] == 'X') {
					input[i] = input[i + 1] = input[i + 2] = input[i + 3] = 'A';
					i += 3;
				} else if (i + 1 < len && input[i + 1] == 'X') {
					input[i] = input[i + 1] = 'B';
					i++;
				} else {
					System.out.println(-1);
					return;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(input[i]);
		}
		System.out.print(sb);
	
	}
	
}