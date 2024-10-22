import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 신호의 개수
		int L = Integer.parseInt(st.nextToken());	// 도로의 길이
		int[][] light = new int[L + 1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int D = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			light[D][0] = R;
			light[D][1] = G;
		} // end of input
		
		int idx = 0;
		int time = 0;
		while (idx < L) {
			time++;
			if (light[idx][0] == 0) idx++;
			else {
				int tt = light[idx][0] + light[idx][1];
				int rt = time % tt;
				if (light[idx][0] < rt || rt == 0) idx++;
			}
		}
		System.out.print(time);
		
	}
	
}