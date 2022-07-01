import java.util.*;
import java.io.*;
public class B2 {

	public static void main(String[] args) throws Exception {
		int N = 1000000;
		sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		PrintWriter pw = new PrintWriter(new File("what3.txt"));
		for(int i = 3; i <= N; i++) {
			pw.print(calc(i)+"\n");
		}
		System.out.println("done");
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int caso = 1;
		while(T--> 0) {
			int n = sc.nextInt();
			System.out.printf("Case #%d: %d\n", caso++, calc(n));
		}
	}
	static int[] sieve;
	static int calc(int x) {
		int res = 0;
		int aux = x;
		while(aux > 1) {
			int d;
			if(sieve[aux] == 2) {
				if(aux % 4 == 0) d = 4;
				else d = 2;
			}
			else d = sieve[aux];
			if(d > 2) {
				int a = Integer.bitCount(x / sieve[aux]);
				res = Math.max(a, res);
			}
			aux /= sieve[aux];
		}
		return res;
	}
}
