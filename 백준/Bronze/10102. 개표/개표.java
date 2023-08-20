import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		int a = 0;
		int b = 0;
		for (int i = 0; i < V; i++) {
			if (input[i] == 'A') a++;
			else b++;
		}
		if (a == b) System.out.print("Tie");
		else if (a < b) System.out.print("B");
		else System.out.print("A");
	
	}
	
}