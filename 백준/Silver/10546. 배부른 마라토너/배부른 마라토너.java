import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for (int i = 1; i < N; i++) {
			String s = br.readLine();
			map.put(s, map.get(s) - 1);
		}
		map.forEach((s, i) -> {
			if (i == 1) {
				System.out.print(s);
			}
		});
		
	}
	
}