import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}
		
		int len = input[0].length();
		for (int i = 1; i <= len; i++) {
			HashSet<String> set = new HashSet<>();
			for (int j = 0; j < N; j++) {
				set.add(input[j].substring(len - i, len));
			}
			if (set.size() == N) {
				System.out.print(i);
				return;
			}
		}
	
	}
	
}