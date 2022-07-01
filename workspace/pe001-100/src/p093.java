import java.util.*;
public class p093 {

	public static void main(String[] args) {
		int[] arr = init(4);
		String res = null; int max = 0;
		while(arr != null) {
			int v = calc(arr);
			if(v > max) {
				max = v; res = Arrays.toString(arr);
			}
			arr = next(arr, 10);
		}
	}
	static int calc(int[] arr) {
		return 0;
	}
	static int[] init(int n) { //1 2 3 ... n
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i;
		}
		return arr;
	}
	static int[] next(int[] arr, int m) {//i = 0 .. m-1
		int n = arr.length;
		int s = -1;
		for(int i = n-1; i >= 0; i--) {
			arr[i]++;
			if(arr[i] != m - (n-1-i)) {
				s = i; break;
			}
		}
		if(s < 0) return null;
		for(int i = s+1; i < n; i++) {
			arr[i] = arr[i-1]+1;
		}
		return arr;
	}

}
