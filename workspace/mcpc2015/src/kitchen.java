import java.util.*;
public class kitchen {

	public static void main(String[] args) {
		System.out.println(calc(64, 5));
		
	}
	static int calc(int sum, int k) {
		if(k == 0) {
			if(sum == 0) return 1;
			else return 0;
		}
		int res = 0;
		for(int i = 0; i <= sum; i++) {
			res += calc(sum - i, k-1);
		}
		return res;
	}

}