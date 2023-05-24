import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[8001];
		int maxCnt = 0;
		double avg = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine()) + 4000;
			if (maxCnt < ++cnt[num]) ++maxCnt;
			avg += num;
		}
		
		// 산술 평균
		avg = (avg / N) - 4000;
		
		// 중앙값
		int half = N / 2 + 1;
		int mid, j = 0;
		for (mid = 0; mid < 8001; mid++) {
			j += cnt[mid];
			if (half <= j) break;
		}
		
		// 최빈값
		boolean flag = false;
		int num = 0;
		for (int i = 0; i < 8001; i++) {
			if (cnt[i] == maxCnt) {
				num = i;
				if (flag) break;
				else flag = true;
			}
		}
		
		// 범위
		int head;
		for (head = 0; head < 8001; head++) {
			if (cnt[head] != 0) break;
		}
		int tail;
		for (tail = 8000; tail >= 0; tail--) {
			if (cnt[tail] != 0) break;
		}
		
		System.out.print(Math.round(avg) + "\n" + (mid - 4000) + "\n" + (num - 4000) + "\n" + (tail - head));
		
	}
	
}