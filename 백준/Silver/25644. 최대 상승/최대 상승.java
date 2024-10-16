import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		while (st.hasMoreTokens()) {
			int now = Integer.parseInt(st.nextToken());
			if (now < min) min = now;
			if (max < now - min) max = now - min;
		}
		System.out.print(max);
	
	}
	
}