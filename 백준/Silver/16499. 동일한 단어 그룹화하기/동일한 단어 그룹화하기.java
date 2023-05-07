import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			Arrays.sort(input);
			set.add(Arrays.toString(input));
		}
		
		System.out.print(set.size());
	
	}
	
}