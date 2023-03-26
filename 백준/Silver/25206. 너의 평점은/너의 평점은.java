import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
	
		double total  = 0.0;
		double totalP = 0.0;
		
		while (true) {
			String input = br.readLine();
			if (input == null || input.isEmpty()) break;
			st = new StringTokenizer(input, " ");
			
			st.nextToken();
			double p = Double.parseDouble(st.nextToken());
			totalP += p;
			String g = st.nextToken();
			
			if ("A+".equals(g)) total += p * 4.5;
			else if ("A0".equals(g)) total += p * 4.0;
			else if ("B+".equals(g)) total += p * 3.5;
			else if ("B0".equals(g)) total += p * 3.0;
			else if ("C+".equals(g)) total += p * 2.5;
			else if ("C0".equals(g)) total += p * 2.0;
			else if ("D+".equals(g)) total += p * 1.5;
			else if ("D0".equals(g)) total += p * 1.0;
			else if ("P".equals(g)) totalP -= p;
		}
		
		System.out.println(total / totalP);
	
	}
	
}