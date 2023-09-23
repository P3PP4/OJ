import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<BigInteger> pqA = new PriorityQueue<>();
        PriorityQueue<BigInteger> pqB = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < 3; j++) {
            pqA.offer(new BigInteger(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < 3; j++) {
            pqB.offer(new BigInteger(st.nextToken()));
        }

        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < 3; i++) {
            sum = sum.add(pqA.poll().multiply(pqB.poll()));
        }
        System.out.print(sum);

    }

}