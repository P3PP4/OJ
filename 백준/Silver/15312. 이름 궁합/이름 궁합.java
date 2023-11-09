import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int[] x = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		int len = A.length();
		int[][] cnt = new int[len * 2][len * 2];
		for (int i = 0; i < len; i++) {
			cnt[0][i * 2] = x[A.charAt(i) - 'A'];
		}
		for (int i = 0; i < len; i++) {
			cnt[0][i * 2 + 1] = x[B.charAt(i) - 'A'];
		}
		
		for (int i = 1; i < len * 2 - 1; i++) {
			for (int j = 0; j < len * 2 - i; j++) {
				cnt[i][j] = (cnt[i - 1][j] + cnt[i - 1][j + 1]) % 10;
			}
		}
		System.out.print(cnt[len * 2 - 2][0] + "" + cnt[len * 2 - 2][1]);
		
	}
	
}