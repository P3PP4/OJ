import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (s.equals(st.nextToken())) cnt++;
		}
		System.out.print(cnt);
		
	}
	
}