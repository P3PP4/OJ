import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int[] cnt = new int[10];
		for (int i = 0; i < input.length; i++) {
			cnt[input[i] - '0']++;
		}
		
		cnt[6] = (cnt[6] + cnt[9] + 1) / 2;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			if(max < cnt[i]) max = cnt[i];
		}
		
		System.out.print(max);
		
	}
	
}