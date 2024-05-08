import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = new String[N];
			for (int i = 0; i < N; i++) {
				input[i] = br.readLine();
			}
			Arrays.stream(input).sorted(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int len = Math.min(o1.length(), o2.length());
					for (int i = 0; i < len; i++) {
						char c1 = o1.charAt(i);
						char c2 = o2.charAt(i);
						if (c1 != c2) {
							if (c1 == '-') return 1;
							if (c2 == '-') return -1;
							
							char c1l = o1.toLowerCase().charAt(i);
							char c2l = o2.toLowerCase().charAt(i);
							if (c1l != c2l) return c1l - c2l;
							return c1 - c2;
						}
					}
					return o1.compareTo(o2);
				}
			}).forEach(a -> sb.append(a).append("\n"));
		}
		System.out.print(sb);
	
	}
	
}