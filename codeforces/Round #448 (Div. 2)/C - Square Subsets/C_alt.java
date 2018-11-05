import java.util.*;
public class C {
	static final long[] prime = {
			2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67
	};
	static final int N = 1 << 19;
	//static final int N = 1 << 4; //for debugging
	static final int MAX = 70;
	//static final int MAX = 10;   //for debugging also
	static final long M = 1000000007;
	static int[] bitmap = new int[MAX+1];
	static int[] pow2 = new int[100001];
	
	public static void main(String[] args) {
		for(int i = 1; i <= MAX; i++) bitmap[i] = bitmap(i); //optimization
		Arrays.fill(pow2, -1); //quite necesary optimization
		
		Scanner seer = new Scanner(System.in);
		int n = seer.nextInt();
		int[] count = new int[MAX+1];
		for(int i = 0; i < n; i++){
			count[prune(seer.nextInt())]++;
		}
		int dp[][] = new int[MAX+1][N]; //normally you'd use long for this 
									 //but memory constraints for java were tight
		dp[0][0] = 1;
		for(int i = 1; i <= MAX; i++){
			for(int j = 0; j < N; j++){
				dp[i][bitmap[i]^j] = sum(dp[i][bitmap[i]^j],
						mult(dp[i-1][j],choose_odd(count[i])) );
				dp[i][j] = sum(dp[i][j],
						mult(dp[i-1][j],choose_even(count[i])) );
			}
		}
		System.out.println(dp[MAX][0]-1);
	}
	
	public static int prune(int x){
		for(long p: prime){
			while(x % (p*p) == 0){
				x /= (p*p);
			}
		}
		return x;
	}
	public static int bitmap(long x){
		int res = 0;
		int aux = 1;
		for(long p: prime){
			while(x % (p*p) == 0){
				x /= (p*p);
			}
			if(x % p == 0){
				res += aux;
			}
			aux <<= 1;
		}
		return res;
	}
	public static int choose_even(int n){
		if(n == 0) return 1;
		else return pow2(n-1);
	}
	public static int choose_odd(int n){
		if(n == 0) return 0;
		else return pow2(n-1);
	}
	public static int pow2(int n){
		if(pow2[n] >= 0) return pow2[n];
		else{
			int res = 1;
			for(int i = 0; i < n; i++){
				res = mult(res,2);
			}
			return pow2[n] = res;
		}
	}
	public static int mult(int a, int b){
		return (int) ( ((long)a *(long)b) % M );
	}
	public static int sum(int a, int b){
		return (int) ( ((long)a +(long)b) % M );
	}
	

}