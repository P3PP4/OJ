import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			
			char[] input = br.readLine().toCharArray();
			LinkedList<Character> log = new LinkedList<>();
			int index = 0;
			
			for (int i = 0; i < input.length; i++) {
				if (input[i] == '<') index = index == 0 ? index : index - 1;
				else if (input[i] == '>') index = index == log.size() ? index : index + 1;
				else if (input[i] == '-') {
					if (0 < index) {
						log.remove(index - 1);
						index = index == 0 ? index : index - 1;
					}
				} else log.add(index++, input[i]);
			}
			
			log.forEach(x -> sb.append(x));
			sb.append("\n");
		
		}
		
		System.out.print(sb);
		
	}
	
}