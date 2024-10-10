import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int maxI = 0;
		int maxH = 0;
		int left = 1000;
		int right = 0;
		int[] map = new int[1001];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			map[index] = height;
			if (index < left) left = index;
			if (right < index) right = index;
			if (maxH < height) {
				maxH = height;
				maxI = index;
			}
		}
		
		int nowI = left;
		int nowH = map[left];
		for (int i = left + 1; i <= maxI; i++) {
			if (map[i] != 0) {
				if (nowH <= map[i]) {
					sum += (i - nowI) * nowH;
					nowI = i;
					nowH = map[i];
				}
			}
		}
		nowI = right;
		nowH = map[right];
		for (int i = right - 1; i >= maxI ; i--) {
			if (map[i] != 0) {
				if (nowH <= map[i]) {
					sum += (nowI - i) * nowH;
					nowI = i;
					nowH = map[i];
				}
			}
		}
		
		System.out.print(sum + maxH);
	
	}
	
}