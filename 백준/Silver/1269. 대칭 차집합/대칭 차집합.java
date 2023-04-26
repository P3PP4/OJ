import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sizeA = Integer.parseInt(st.nextToken());
		int sizeB = Integer.parseInt(st.nextToken());
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		HashSet<Integer> AB = new HashSet<>();
		HashSet<Integer> BA = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < sizeA; i++) {
			int n = Integer.parseInt(st.nextToken());
			A.add(n);
			AB.add(n);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < sizeB; i++) {
			int n = Integer.parseInt(st.nextToken());
			B.add(n);
			BA.add(n);
		}
		
		for (Integer i : B) {
			AB.remove(i);
		}
		for (Integer i : A) {
			BA.remove(i);
		}
		
		System.out.print(AB.size() + BA.size());
	
	}
	
}