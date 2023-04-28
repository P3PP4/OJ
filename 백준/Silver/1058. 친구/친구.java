import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			char[] friend = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (friend[j] == 'Y') list[i].add(j);
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (Integer f : list[i]) {
				set.add(f);
				for (Integer ff : list[f]) {
					if (ff != i) set.add(ff);
				}
			}
			max = Math.max(max, set.size());
		}
		
		System.out.print(max);
	
	}
	
}