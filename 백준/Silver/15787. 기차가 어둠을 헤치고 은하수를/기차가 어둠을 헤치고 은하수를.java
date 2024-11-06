import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] train = new int[N + 1];
		int limit = 1 << 19;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int o1 = Integer.parseInt(st.nextToken());
			int o2 = Integer.parseInt(st.nextToken());
			if (o1 == 1) {
				int o3 = Integer.parseInt(st.nextToken()) - 1;
				train[o2] |= 1 << o3;
			} else if (o1 == 2) {
				int o3 = Integer.parseInt(st.nextToken()) - 1;
				if (Integer.bitCount(train[o2] & 1 << o3) != 0) train[o2] -= 1 << o3;
			} else if (o1 == 3) {
				if (Integer.bitCount(train[o2] & limit) != 0) train[o2] -= limit;
				train[o2] <<= 1;
			} else {
				train[o2] >>= 1;
			}
		}
		
		int sum = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			if (!set.contains(train[i])) {
				set.add(train[i]);
				sum++;
			}
		}
		System.out.print(sum);
	
	}
	
}