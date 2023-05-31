import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	static int N, K;
	static String[] input;
	static boolean[] used;
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		input = new String[N];
		used = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}
		
		run(0, "");
		
		System.out.print(set.size());
		
	}
	
	static void run(int cnt, String s) {
		if (cnt == K) {
			set.add(s);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (used[i]) continue;
			
			used[i] = true;
			run(cnt + 1, s + input[i]);
			used[i] = false;
		}
	}
	
}