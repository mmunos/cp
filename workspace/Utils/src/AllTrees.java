import java.util.*;
public class AllTrees { 
	public static void main(String[] args) {
		int[] perm = {3, 0, 0, 0, 0};
		int count = 0;
		while(perm != null) {
			ArrayList<Integer>[] g = permtotree(perm);
			perm = next(perm, 3);
			if(g == null) continue;
			printtree(g); count++;
		}
		System.out.println(count);
	}
	static void printtree(ArrayList<Integer>[] g) {
		int n = g.length;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			for(int u: g[i]) {
				if(u > i) {
					sb.append((i+1)+" "+(u+1)+"\n");
				}
			}
		}
		System.out.println(n);
		System.out.print(sb.toString());
	}
	static void printgraph(ArrayList<Integer>[] g) {
		int n = g.length;
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = 0; i < n; i++){
			for(int u: g[i]) {
				if(u > i) {
					sb.append((i+1)+" "+(u+1)+"\n"); count++;
				}
			}
		}
		System.out.println(n+" "+count);
		System.out.print(sb.toString());
	}
	static ArrayList<Integer>[] permtotree(int[] arr){
		int n = arr.length;
		for(int i = 1; i < n; i++){
			if(arr[i] >= i) return null;
		}
		ArrayList<Integer>[] g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<>();
		}
		for(int i = 0; i < n-1; i++){
			g[i].add(arr[i]);
			g[arr[i]].add(i);
		}
		return g;
	}
	
	static int[] next(int[] arr, int max) {
		int n = arr.length;
		int ind = n-1;
		while(ind >= 0 && arr[ind] == max) {
			arr[ind] = 0; ind--;
		}
		if(ind < 0) return null;
		arr[ind]++;
		return arr;
	}
	
}
