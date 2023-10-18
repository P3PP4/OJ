import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}
		Arrays.sort(input, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) return o1.length() - o2.length();
				int o1cnt = 0;
				int o2cnt = 0;
				for (int i = 0; i < o1.length(); i++) {
					if ('1' <= o1.charAt(i) && o1.charAt(i) <= '9') o1cnt += o1.charAt(i) - '0';
					if ('1' <= o2.charAt(i) && o2.charAt(i) <= '9') o2cnt += o2.charAt(i) - '0';
				}
				if (o1cnt == o2cnt) return o1.compareTo(o2);
				return o1cnt - o2cnt;
			}
		});
		for (int i = 0; i < N; i++) {
			sb.append(input[i]).append("\n");
		}
		System.out.print(sb);
	
	}
	
}