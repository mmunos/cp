import java.util.*;
public class SparseTableUtils {

	public static void main(String[] args) {
		int[] arr = {1,3,5,6,2,3,7,9,0,2,4,9,4,6};
		SparseTable st = new SparseTable(arr);
		
	}
	
	static class SparseTable{ //indexed and min
		int[] arr;
		int[][] table;
		public SparseTable(int[] arr) {
			this.arr = arr;
			int n = arr.length;
			int m = 0, aux = n;
			while(aux > 0) {
				aux >>= 1; m++;
			}
			table = new int[m][n];
			for(int i = 0; i < n; i++) table[0][i] = i;
			for(int lev = 0; lev < m-1; lev++) {
				Arrays.fill(table[lev+1], -1);
				for(int i = 0; i < n; i++) {
					if(i + (1 << lev) < n) {
						if(arr[table[lev][i+(1<<lev)]] < arr[table[lev][i]])
							table[lev+1][i] = table[lev][i+(1<<lev)];
						else
							table[lev+1][i] = table[lev][i];
					}
					else table[lev+1][i] = table[lev][i];
				}
			}
			System.out.println("bla");
		}
		public int rmq(int L, int R) {
			int lev = -1, aux = R - L + 1;
			while(aux > 0) {
				aux >>= 1; lev++;
			}
			int a = table[lev][L];
			int b = table[lev][R - (1 << lev) + 1];
			if(arr[a] <= arr[b]) return a;
			else return b;
		}
	}

}
