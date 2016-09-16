import java.util.*;
public class dirty {
	static int[][] dp1, dp0;
	public static void main(String[] args){
		Scanner seer = new Scanner(System.in);
		int T = seer.nextInt();
		for(int test = 1; test <= T; test++){
			int c = seer.nextInt();
			int s = seer.nextInt();
			int d = seer.nextInt();
			dp0 = new int[c+1][c+s+1];
			dp1 = new int[c+1][c+s+1];
			System.out.printf("Scenario #%d: %d\n",test,calc(c,s,d,0));
		}
	}
	static int calc(int c, int s, int d, int table){
		if(c < 0 || s < 0 || d < 0) return -1;
		if(table == 0){
			if(dp0[c][s] > 0) return dp0[c][s];
			if(c == 0 && s == 0) return dp0[c][s] = 0;
			if(valid(c,s,d,table)){
				return dp0[c][s] = 1 + Integer.max(calc(c-1,s+1,d,table),calc(c,s-1,d+1,table));
			}
			else{
				int A = calc(c-1,s+1,d,table);
				int B = calc(c,s-1,d+1,table);
				return dp0[c][s] = Integer.max(Integer.max(A, B), calc(c,s,d,1));
			}
		}
		else{
			if(dp1[c][s] > 0) return dp1[c][s];
			if(c == 0 && s == 0) return dp1[c][s] = 0;
			if(valid(c,s,d,table)){
				return dp1[c][s] = 1 + Integer.max(calc(c-1,s+1,d,table),calc(c,s-1,d+1,table));
			}
			else{
				int A = calc(c-1,s+1,d,table);
				int B = calc(c,s-1,d+1,table);
				return dp1[c][s] = Integer.max(A, B);
			}
		}
	}
	static boolean valid(int c, int s, int d, int table){
		if(table == 0){ // table is clean
			if(d > 0){
				if(s < 2) return false;
				else return s%2==0;
			}
			else return s%2==0;
		}
		else{
			return s%2==1;
		}
	}
}
