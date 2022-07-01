import java.util.*;
import java.io.*;
public class p090 {

	static int[][] nums = { {0,1}, {0,4}, {0,9}, {1,6}, {2,5}, {3,6}, {4,9}, {6,4}, {8,1} };
	public static void main(String[] args) {
		int[] bla = {0, 5, 6, 7, 8, 9};
		int[] ble = {1, 2, 3, 4, 8, 9};
		check(bla, ble);
		
		int[] arr = init(6);
		int res = 0;
		while(arr != null) {
 			int[] brr = arr.clone();
			while(brr != null) {
				if(check(arr, brr)) res++;
				brr = next(brr, 10);
			}
 			arr = next(arr, 10);
		}
		System.out.println(res);
	}
	static boolean cmp(int a, int b) {
		if(a == b) return true;
		if(a == 6 && b == 9) return true;
		if(a == 9 && b == 6) return true;
		return false;
	}
	static boolean check(int[] arr, int[] brr) {
		int k = nums.length;
		for(int i = 0; i < k; i++) {
			boolean yes = false;
			for(int u = 0; u < arr.length; u++) {
				for(int v = 0; v < brr.length; v++) {	
					if(cmp(arr[u],nums[i][0]) && cmp(brr[v],nums[i][1])) yes = true;
					if(cmp(arr[u],nums[i][1]) && cmp(brr[v],nums[i][0])) yes = true;
				}
			}
			if(!yes) return false;
		}
		return true;
	}
	static int[] init(int n) {
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i;
		}
		return arr;
	}
	static int[] next(int[] arr, int m) {
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
