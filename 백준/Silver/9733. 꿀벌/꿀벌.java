import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		double total = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 24; i++) {
			String input = br.readLine();
			if (input == null || input.isEmpty()) break;
			StringTokenizer st = new StringTokenizer(input, " ");
			while (st.hasMoreTokens()) {
				String work = st.nextToken();
				if ("Re".equals(work)) map.put("Re", map.getOrDefault("Re", 0) + 1);
				else if ("Pt".equals(work)) map.put("Pt", map.getOrDefault("Pt", 0) + 1);
				else if ("Cc".equals(work)) map.put("Cc", map.getOrDefault("Cc", 0) + 1);
				else if ("Ea".equals(work)) map.put("Ea", map.getOrDefault("Ea", 0) + 1);
				else if ("Tb".equals(work)) map.put("Tb", map.getOrDefault("Tb", 0) + 1);
				else if ("Cm".equals(work)) map.put("Cm", map.getOrDefault("Cm", 0) + 1);
				else if ("Ex".equals(work)) map.put("Ex", map.getOrDefault("Ex", 0) + 1);
				total++;
			}
		}
		
		sb.append("Re ").append(map.getOrDefault("Re", 0)).append(" ").append(String.format("%.2f", map.getOrDefault("Re", 0) / total)).append("\n");
		sb.append("Pt ").append(map.getOrDefault("Pt", 0)).append(" ").append(String.format("%.2f", map.getOrDefault("Pt", 0) / total)).append("\n");
		sb.append("Cc ").append(map.getOrDefault("Cc", 0)).append(" ").append(String.format("%.2f", map.getOrDefault("Cc", 0) / total)).append("\n");
		sb.append("Ea ").append(map.getOrDefault("Ea", 0)).append(" ").append(String.format("%.2f", map.getOrDefault("Ea", 0) / total)).append("\n");
		sb.append("Tb ").append(map.getOrDefault("Tb", 0)).append(" ").append(String.format("%.2f", map.getOrDefault("Tb", 0) / total)).append("\n");
		sb.append("Cm ").append(map.getOrDefault("Cm", 0)).append(" ").append(String.format("%.2f", map.getOrDefault("Cm", 0) / total)).append("\n");
		sb.append("Ex ").append(map.getOrDefault("Ex", 0)).append(" ").append(String.format("%.2f", map.getOrDefault("Ex", 0) / total)).append("\n");
		sb.append("Total ").append((int) total).append(" 1.00").append("\n");
		System.out.print(sb);
	
	}
	
}