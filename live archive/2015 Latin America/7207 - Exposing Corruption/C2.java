import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class C2 {
	public static void main(String...strings) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int[] cd = new int[100]; int[] cp = new int[100];
		ArrayList<Integer>[] gd = new ArrayList[100]; ArrayList<Integer>[] gp = new ArrayList[100];
		int[] grsd = new int[100]; int[] grsp = new int[100];
		int[] A = new int[200]; int[] C = new int[200];
		int[][] dpmax = new int[201][10001];
		int[][] dpmin = new int[201][10001];
		while((line = br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line);
			int D = Integer.parseInt(st.nextToken()); int P = Integer.parseInt(st.nextToken()); int R = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < D; i++) cd[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < P; i++) cp[i] = Integer.parseInt(st.nextToken());
			for(int i = 0; i < D; i++) gd[i] = new ArrayList<>();
			for(int i = 0; i < P; i++) gp[i] = new ArrayList<>();
			for(int i = 0; i < R; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1; //DSP
				int b = Integer.parseInt(st.nextToken())-1; //PPP
				gd[a].add(b); gp[b].add(a);
			}
			//bfs
			int G = 1;
			Arrays.fill(grsd, 0, D, 0);
			Arrays.fill(grsp, 0, P, 0);
			for(int i = 0; i < D; i++){
				if(grsd[i] == 0){
					grsd[i] = G;
					ArrayList<Integer> q = new ArrayList<>();
					q.add(i);
					while(!q.isEmpty()){
						int u = q.remove(0);
						for(int v: gd[u]){
							if(grsp[v] == 0){
								grsp[v] = G;
								for(int w: gp[v]){
									if(grsd[w] == 0){
										grsd[w] = G;
										q.add(w);
									}
								}
							}
						}
					}
					G++;
				}
			}
			for(int i = 0; i < P; i++){
				if(grsp[i] == 0){
					grsp[i] = G; G++;
				}
			}
			G--; //starts on 1
			Arrays.fill(A, 0, G, 0);
			Arrays.fill(C, 0, G, 0);
			for(int i = 0; i < D; i++){
				A[grsd[i]-1]++;
				C[grsd[i]-1] += cd[i];
			}
			for(int i = 0; i < P; i++){
				A[grsp[i]-1]--;
				C[grsp[i]-1] += cp[i];
			}
			//knapsack
			for(int i = 0; i <= G; i++) Arrays.fill(dpmax[i], 0, B+1, -1);
			dpmax[0][0] = 0;
			for(int gr = 1; gr <= G; gr++){
				for(int c = 0; c <= B; c++){
					if(A[gr-1] > 0 && dpmax[gr-1][c] >= 0 && c+C[gr-1] <= B){
						if(dpmax[gr-1][c] + A[gr-1] > dpmax[gr][c+C[gr-1]]){
							dpmax[gr][c+C[gr-1]] = dpmax[gr-1][c] + A[gr-1];
						}
					}
					if(dpmax[gr-1][c] > dpmax[gr][c]){
						dpmax[gr][c] = dpmax[gr-1][c];
					}
				}
			}
			for(int i = 0; i <= G; i++) Arrays.fill(dpmin[i], 0, B+1, -1);
			dpmin[0][0] = 0;
			for(int gr = 1; gr <= G; gr++){
				for(int c = 0; c <= B; c++){
					if(A[gr-1] < 0 && dpmin[gr-1][c] >= 0 && c+C[gr-1] <= B){
						if(dpmin[gr-1][c] - A[gr-1] > dpmin[gr][c+C[gr-1]]){
							dpmin[gr][c+C[gr-1]] = dpmin[gr-1][c] - A[gr-1];
						}
					}
					if(dpmin[gr-1][c] > dpmin[gr][c]){
						dpmin[gr][c] = dpmin[gr-1][c];
					}
				}
			}
			int max = 0;
			for(int c = 0; c <= B; c++) max = Integer.max(max, dpmax[G][c]);
			int min = 0;
			for(int c = 0; c <= B; c++) min = Integer.max(min, dpmin[G][c]);
			System.out.printf("%d %d\n",D+min,P+max);		
		}
	}
}
