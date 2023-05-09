import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int pre = set.size();
			char[] input = br.readLine().toCharArray();
			int len = input.length;
			for (int j = 0; j < len; j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < len; k++) {
					sb.append(input[(j + k) % len]);
				}
				if (set.contains(sb.toString())) break;
				set.add(sb.toString());
			}
			if (pre < set.size()) cnt++;
		}
		
		System.out.print(cnt);
		
	}
	
}