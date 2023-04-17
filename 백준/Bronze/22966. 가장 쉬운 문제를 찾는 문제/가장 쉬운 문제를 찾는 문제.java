import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String s = "";
		int num = 5;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String line = st.nextToken();
			int newNum = Integer.parseInt(st.nextToken());
			if (newNum < num) {
				s = line;
				num = newNum;
			}
		}
		
		System.out.print(s);
	
	}
	
}