import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
		long fv = 0;
		int fc = 0;
		for (int i = 0; i < N; i++) {
			long input = Long.parseLong(br.readLine());
			int count = map.getOrDefault(input, 0) + 1;
			map.put(input, count);
			if (fc < count || (fc == count && input < fv)) {
				fv = input;
				fc = count;
			}
		}
		
		System.out.print(fv);
	
	}
	
}