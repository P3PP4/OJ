import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] num, input, used;

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		input = new int[4];
		used = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		go(1, num[0]);
		
		System.out.print(max + "\n" + min);
		
	}

	static void go(int idx, int val) {
		if (idx == N) {
			if (max < val) max = val;
			if (min > val) min = val;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (input[i] > used[i]) {
				used[i]++;
				switch (i) {
					case 0:
						go(idx + 1, val + num[idx]);
						break;
					case 1:
						go(idx + 1, val - num[idx]);
						break;
					case 2:
						go(idx + 1, val * num[idx]);
						break;
					case 3:
						go(idx + 1, val / num[idx]);
				}
				used[i]--;
			}
		}
	}
	
}