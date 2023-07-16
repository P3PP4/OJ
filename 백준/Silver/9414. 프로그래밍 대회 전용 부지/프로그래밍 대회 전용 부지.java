import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
t:		for (int tc = 0; tc < T; tc++) {
			List<Integer> list = new ArrayList<>();
			while (true) {
				int num = Integer.parseInt(br.readLine());
				if (num == 0) break;
				list.add(num);
			}
			
			int result = 0;
			Collections.sort(list, Comparator.reverseOrder());
			for (int i = 0; i < list.size(); i++) {
				result += pow(list.get(i), i);
				if (5_000_000 < result) {
					sb.append("Too expensive\n");
					continue t;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	
	}
	
	static int pow(int num, int cnt) {
		int result = num;
		for (int i = 0; i < cnt; i++) {
			result *= num;
		}
		return 2 * result;
	}
	
}