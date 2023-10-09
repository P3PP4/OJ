import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				int res1 = a * i + b * j;
				if (res1 == c) {
					int res2 = d * i + e * j;
					if (res2 == f) {
						System.out.print(i + " " + j);
						return;
					}
				}
			}
		}
	
	}
	
}