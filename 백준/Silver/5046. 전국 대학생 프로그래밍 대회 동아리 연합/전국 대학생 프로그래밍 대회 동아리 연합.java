import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 인원
		int B = Integer.parseInt(st.nextToken());	// 예산
		int H = Integer.parseInt(st.nextToken());	// 호텔 수
		int W = Integer.parseInt(st.nextToken());	// 주의 개수
		Hotel[] info = new Hotel[H];
		for (int i = 0; i < H; i++) {
			int pee = Integer.parseInt(br.readLine());
			int[] tmp = new int[W];
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			info[i] = new Hotel(pee, tmp);
		}
        
		Arrays.sort(info, (o1, o2) -> o1.pee - o2.pee);
		for (Hotel h : info) {
			int total = N * h.pee;
			if (total <= B) {
				for (int i = 0; i < W; i++) {
					if (N <= h.capacity[i]) {
						System.out.print(total);
						return;
					}
				}
			}
		}
		System.out.print("stay home");
		
	}
	
	static class Hotel {
		int pee;
		int[] capacity;
		
		public Hotel(int pee, int[] capacity) {
			this.pee = pee;
			this.capacity = capacity;
		}
	}
	
}