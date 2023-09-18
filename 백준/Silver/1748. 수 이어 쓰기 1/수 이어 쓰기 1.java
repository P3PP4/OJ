import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(s);
		int len = s.length();
		int cnt = 0;
		int unit = 1;
		for (int i = 1; i < len; i++) {
			unit *= 10;
			cnt += (unit - unit / 10) * Math.log10(unit);
		}
		cnt += (N - unit + 1) * Math.log10(unit * 10);
		System.out.print(cnt);
	
	}
	
}