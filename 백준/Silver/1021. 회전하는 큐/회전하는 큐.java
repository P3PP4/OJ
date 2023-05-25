import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int cnt = 0;
		int index = 0;
		int targetIndex;
		int size = N;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			for (targetIndex = 0; targetIndex < N; targetIndex++) {
				if (list.get(targetIndex) == target) break;
			}
			int diff = Math.abs(targetIndex - index);
			if (diff <= size >> 1) cnt += diff;
			else cnt += size - diff;
			list.remove(targetIndex);
			size--;
			index = targetIndex;
			if (size <= index) index = 0;
		}
		
		System.out.print(cnt);
		
	}
	
}