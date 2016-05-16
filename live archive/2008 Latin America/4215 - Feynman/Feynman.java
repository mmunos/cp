import java.util.*;
public class Feynman {
	static long[] feyn = new long[101];
	public static void main(String...thegame){
		feyn[1] = 1;
		for(long i = 2; i <= 100; i++) {
			feyn[(int)i] = feyn[(int)i-1] + i*i; 
		}
		Scanner seer = new Scanner(System.in);
		while(true){
			int n = seer.nextInt();
			if(n == 0) return;
			System.out.println(feyn[n]);
		}
	}
}
