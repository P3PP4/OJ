import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		char s = '0';
		char e = '0';
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			set.add(arr[i]);
		}
		for (int i = 0; i < N; i++) {
			if ("?".equals(arr[i])) {
				if (0 < i) s = arr[i - 1].charAt(arr[i - 1].length() - 1);
				if (i < N - 1) e = arr[i + 1].charAt(0);
			}
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (set.contains(input)) continue;
			if (s != '0' && input.charAt(0) != s) continue;
			if (e != '0' && input.charAt(input.length() - 1) != e) continue;
			System.out.print(input);
			return;
		}
	
	}
	
}