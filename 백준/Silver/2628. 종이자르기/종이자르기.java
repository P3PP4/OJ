import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> hor = new ArrayList<>();
		ArrayList<Integer> ver = new ArrayList<>();
		hor.add(0);
		hor.add(N);
		ver.add(0);
		ver.add(M);
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 0) hor.add(b);
			else ver.add(b);
		}
		
		Collections.sort(hor);
		Collections.sort(ver);
		int result = 0;
		for (int i = 1; i < ver.size(); i++) {
			int verLen = ver.get(i) - ver.get(i - 1);
			for (int j = 1; j < hor.size(); j++) {
				int horLen = hor.get(j) - hor.get(j - 1);
				int temp = verLen * horLen;
				if (result < temp) result = temp;
			}
		}
		System.out.print(result);
	
	}
	
}