import java.util.*;
import java.io.*;
public class E2 {
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = br.readLine())!=null){
		StringTokenizer st = new StringTokenizer(line);
		int n = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] children = new ArrayList[n];
		int[] upw = new int[n];
		boolean[] friend = new boolean[n];
		for(int i = 0; i < n; i++){
			children[i] = new ArrayList<>();
		}
		for(int i = 0; i < n-1; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			children[a].add(b);
			upw[b] = c;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < f; i++){
			friend[Integer.parseInt(st.nextToken())-1] = true;
		}
		//bfs
		ArrayList<Integer> q = new ArrayList<>();
		q.add(0);
		for(int i = 0; i < n; i++){
			int u = q.get(i);
			for(int v: children[u]){
				q.add(v);
			}
		}
		int[] upcost = new int[n];
		int[] dncost = new int[n];
		for(int i = n-1; i > 0; i--){
			int u = q.get(i);
			if(children[u].isEmpty()){
				if(friend[u]) {
					upcost[u] = upw[u];
					dncost[u] = upw[u];
				}
			}
			else{
				int maxdn = 0;
				for(int v: children[u]){
					upcost[u] += upcost[v];
					maxdn = Integer.max(maxdn, dncost[v]);
				}
				if(upcost[u] > 0) {
					dncost[u] = upw[u] + maxdn;
					upcost[u] += upw[u];
				}
				else if(friend[u]) {
					upcost[u] = upw[u];
					dncost[u] = upw[u];
				}
			}
		}
		int maxdn = 0;
		for(int v: children[0]){
			upcost[0] += upcost[v];
			maxdn = Integer.max(maxdn, dncost[v]);
		}
		System.out.println(upcost[0] - maxdn);
		}
	}
}
