import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int[] cnt = new int[91];
		int odd = 0;
		int len = 0;
		for (int i = 0; i < input.length; i++) {
			if (++cnt[input[i]] % 2 == 0) odd--;
			else odd++;
			len++;
		}
		
		if (1 < odd || (odd == 1 && len % 2 == 0)) {
			System.out.print("I'm Sorry Hansoo");
			return;
		}
		
		String one = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 65; i <= 90; i++) {
			int num = cnt[i];
			
			if (num == 0) continue;
			
			for (int j = 0; j < num / 2; j++) {
				sb.append((char) i);
			}
			
			if (cnt[i] % 2 == 1) one += (char) i;
		}
		
		System.out.print(sb);
		System.out.print(one);
		System.out.print(sb.reverse());
	
	}
	
}