import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print((int) Math.sqrt(Double.parseDouble(br.readLine())));
	}
}