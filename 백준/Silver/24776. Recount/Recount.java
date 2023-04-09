import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	static int cnt;
	static String name;
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = br.readLine();
			if ("***".equals(input)) break;
			map.put(input,map.getOrDefault(input, 0) + 1);
		}
		
		map.entrySet().forEach(x -> {
			if (cnt < x.getValue()) {
				cnt = x.getValue();
				name = x.getKey();
			} else if (cnt == x.getValue()) name = "";
		});
		
		if ("".equals(name)) System.out.println("Runoff!");
		else System.out.println(name);
		
	}
	
}