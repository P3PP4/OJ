import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] query = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			query[i][0] = Integer.parseInt(st.nextToken());
			query[i][1] = Integer.parseInt(st.nextToken());
			query[i][2] = Integer.parseInt(st.nextToken());
		} // end of input
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i == j) continue;
				for (int k = 1; k < 10; k++) {
					if (i == k || j == k) continue;
					list.add(i * 100 + j * 10 + k);
				}
			}
		}
		
		int[] a = new int[3];
		int[] b = new int[3];
		int cnt = 0;
		for (Integer n : list) {
			a[0] = n / 100;
			a[1] = n % 100 / 10;
			a[2] = n % 10;
			boolean flag = true;
			
			for (int i = 0; i < N; i++) {
				b[0] = query[i][0] / 100;
				b[1] = query[i][0] % 100 / 10;
				b[2] = query[i][0] % 10;
				int strike = 0;
				int ball = 0;
				
				for (int j = 0; j < 3; j++) {
					if (a[j] == b[j]) strike++;
					else if (a[j] == b[(j + 1) % 3] || a[j] == b[(j + 2) % 3]) ball++;
				}
				
				if (strike != query[i][1] || ball != query[i][2]) {
					flag = false;
					break;
				}
			}
			
			if (flag) cnt++;
		}
		
		System.out.print(cnt);
	
	}
	
}