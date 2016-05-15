import java.util.*;
import java.io.*;
public class KernelKnights {
	static int[] to = new int[200000];
	static int[] indeg = new int[200000];
	static int[] kernel = new int[200000];
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line == null) return;
			int n = Integer.parseInt(line);
			Arrays.fill(indeg, 0, 2*n, 0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++){
				to[i] = Integer.parseInt(st.nextToken())-1;
				indeg[to[i]]++;
			}
			st = new StringTokenizer(br.readLine());
			for(int i = n; i < 2*n; i++){
				to[i] = Integer.parseInt(st.nextToken())-1;
				indeg[to[i]]++;
			}

			Arrays.fill(kernel, 0, 2*n, 0);
			LinkedList<Integer> q = new LinkedList<>();
			for(int i = 0; i < 2*n; i++){
				if(indeg[i] == 0){
					q.add(i);
				}
			}
			while(!q.isEmpty()){
				int u = q.pollFirst();
				kernel[u] = 1; 
				if(kernel[to[u]] == 0){
					kernel[to[u]] = -1;
					indeg[to[to[u]]]--;
					if(indeg[to[to[u]]] == 0){
						q.add(to[to[u]]);
					}
				}
			}
			for(int i = 0; i < 2*n; i++){
				if(kernel[i] == 0){
					q = new LinkedList<>();
					q.add(i);
					while(!q.isEmpty()){
						int u = q.pollFirst();
						kernel[u] = 1; 
						if(kernel[to[u]] == 0){
							kernel[to[u]] = -1;
							indeg[to[to[u]]]--;
							if(indeg[to[to[u]]] == 0){
								q.add(to[to[u]]);
							}
						}
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 2*n; i++){
				if(kernel[i] == 1){
					sb.append((1+i)+" ");
				}
			}
			System.out.println(sb.toString().trim());
		}
	}
}
