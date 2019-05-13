import java.io.*;
import java.util.*;
public class Main {

	static int[][] dir = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
	public static void main(String[] args) throws Exception {
		//read all the hecking input
		int ck; StringBuilder cito = new StringBuilder();
		while((ck = System.in.read())!=-1){
			cito.append((char)ck);
		}
		int caso = 1;
		StringTokenizer st = new StringTokenizer(cito.toString());
		while(st.hasMoreTokens()){
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][][] map = new char[M][P][K];
			String line = null;
			for(int i = 0; i < M; i++){
				for(int j = 0; j < P; j++){
					map[i][j] = st.nextToken().toCharArray();
				}
			}
			//bfs
			ArrayList<Integer>[] res = new ArrayList[4];
			for(int i = 0; i < 4; i++) res[i] = new ArrayList<>();
			for(int i = 0; i < M; i++){
				for(int j = 0; j < P; j++){
					for(int k = 0; k < K; k++){
						if(map[i][j][k] >= 'a' && map[i][j][k] <= 'd'){
							char ch = map[i][j][k];
							map[i][j][k] = '.';
							int count = 1;
							ArrayList<Coor> q = new ArrayList<>();
							q.add(new Coor(i,j,k));
							while(!q.isEmpty()){
								Coor c = q.remove(0);
								for(int[] d: dir){
									int x = c.x+d[0]; int y = c.y+d[1]; int  z = c.z+d[2];
									if(x >= 0 && x < M && y >= 0 && y < P && z >= 0 && z < K
											&& (map[x][y][z] == ch)){
										map[x][y][z] = '.';
										q.add(new Coor(x,y,z));
										count++;
									}
								}
							}
							res[ch-'a'].add(count);
						}
					}
				}
			}
			if(caso > 1) System.out.println("");
			System.out.printf("Case %d:\n", caso);
			for(int i = 0; i < 4; i++) {
				Collections.sort(res[i]);
				Collections.reverse(res[i]);
				StringBuilder sb = new StringBuilder();
				sb.append((char)(i+'a')+" ");
				if(res[i].isEmpty()){
					sb.append("0");
				}
				for(int n: res[i]){
					sb.append(n+" ");
				}
				System.out.println(sb.toString().trim());
			}
			caso++;
		}
	}
	static class Coor{
		int x, y, z;
		public Coor(int x, int y, int z){
			this.x = x; this.y = y; this.z = z;
		}
		public String toString(){
			return x+","+y+","+z;
		}
	}
}
