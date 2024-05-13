import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] input = new String[N];
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}
		for (int i = 0; i < M; i++) {
			set.add(br.readLine());
		}
		
		Arrays.sort(input, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				StringTokenizer st = new StringTokenizer(o1, ".");
				String name1 = st.nextToken();
				String extension1 = st.nextToken();
				st = new StringTokenizer(o2, ".");
				String name2 = st.nextToken();
				String extension2 = st.nextToken();
				
				if (name1.equals(name2)) {
					if (set.contains(extension1)) {
						if (set.contains(extension2)) return extension1.compareTo(extension2);
						return -1;
					} else if (set.contains(extension2)) return 1;
					return extension1.compareTo(extension2);
				}
				return name1.compareTo(name2);
			}
		});
		
		for (String s : input) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	
	}
	
}