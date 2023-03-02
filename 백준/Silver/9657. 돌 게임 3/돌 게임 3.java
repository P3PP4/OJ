import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) % 7;
		if (N == 0 || N == 2) System.out.print("CY");
		else System.out.print("SK");
		
	}
	
}
