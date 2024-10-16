import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] step = new int[2];
		step[0] = Integer.parseInt(st.nextToken());
		step[1] = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] stone = new int[100001];
		stone[N] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		while(!q.isEmpty()) {
			int now = q.poll();
			if (now == M) {
				System.out.print(stone[now] - 1);
				return;
			}
			
			for (int i = -1; i <= 1; i += 2) {
				int next = now + i;
				if (0 <= next && next <= 100000 && stone[next] == 0) {
					q.offer(next);
					stone[next] = stone[now] + 1;
				}
				
				for (int j = 0; j < 2; j++) {
					next = now + (step[j] * i);
					if (0 <= next && next <= 100000 && stone[next] == 0) {
						q.offer(next);
						stone[next] = stone[now] + 1;
					}
					
					next = now * step[j];
					if (next <= 100000 && stone[next] == 0) {
						q.offer(next);
						stone[next] = stone[now] + 1;
					}
				}
			}
		}
	
	}
	
}