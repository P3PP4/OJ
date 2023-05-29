import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
		Collections.sort(distinctList);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		for (int i = 0; i < distinctList.size(); i++) {
			map.put(distinctList.get(i), cnt++);
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(map.get(list.get(i))).append(" ");
		}
		System.out.print(sb);
	
	}
	
}