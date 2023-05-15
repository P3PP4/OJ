import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		int[] stack = new int[2];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (input[i] == 'S') stack[0]++;
			else if (input[i] == 'K') {
				if (0 < stack[0]) {
					cnt++;
					stack[0]--;
				}
				else break;
			}
			else if (input[i] == 'L') stack[1]++;
			else if (input[i] == 'R') {
				if (0 < stack[1]) {
					cnt++;
					stack[1]--;
				}
				else break;
			}
			else cnt++;
		}
		
		System.out.print(cnt);
	
	}
	
}