import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		int[] input = new int[len + 1];
		int[] sum = new int[len + 1];
		input[1] = sum[1] = s.charAt(0) - '0';
		
		for (int i = 2; i <= len; i++) {
			input[i] = s.charAt(i - 1) - '0';
			sum[i] = sum[i - 1] + input[i];
		}
		
		int max = 2;
		for (int i = 4; i <= len; i += 2) {
			int half = i / 2;
			for (int j = 0; j + i <= len; j++) {
				int left  = sum[j + half] - sum[j];
				int right = sum[j + i] - sum[j + half];
				if (left == right) {
					max = i;
					break;
				}
			}
		}
		
		System.out.print(max);
	
	}
	
}