import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] np = new boolean[1000];
		for (int i = 2; i < 1000; i++) {
			if (!np[i]) {
				for (int j = i * 2; j < 1000; j += i) {
					np[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
t:		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 2; i < N; i++) {
				if (np[i]) continue;
				for (int j = 2; j < N; j++) {
					if (np[j]) continue;
					for (int k = 2; k < N; k++) {
						if (np[k]) continue;
						if (N < i + j + k) break;
						else if (N == i + j + k) {
							sb.append(i).append(" ").append(j).append(" ").append(k).append("\n");
							continue t;
						}
					}
				}
			}
			sb.append(0).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}