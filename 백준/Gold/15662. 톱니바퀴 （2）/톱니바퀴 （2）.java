import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		List<Integer>[] wheel = new ArrayList[T + 1];
		for (int i = 1; i <= T; i++) {
			wheel[i] = new ArrayList<>();
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i].add(input.charAt(j) - '0');
			}
		}
		
		List<Integer> turn = new ArrayList<>();
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			turn.clear();
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			turn.add(idx);
			for (int j = idx - 1; j > 0; j--) {
				if (wheel[j].get(2) != wheel[j + 1].get(6)) turn.add(j);
				else break;
			}
			for (int j = idx + 1; j <= T; j++) {
				if (wheel[j].get(6) != wheel[j - 1].get(2)) turn.add(j);
				else break;
			}
			
			for (int next : turn) {
				if ((next + idx) % 2 == 0) { // idx번째 바퀴랑 같은 방향 회전
					wheel[next].add(dir == 1 ? 0 : 7, wheel[next].remove(dir == 1 ? 7 : 0));
				} else {
					wheel[next].add(dir == 1 ? 7 : 0, wheel[next].remove(dir == 1 ? 0 : 7));
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i <= T; i++) {
			if (wheel[i].get(0) == 1) result++;
		}
		System.out.print(result);
	
	}
	
}