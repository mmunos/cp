import java.util.*;
import java.io.*;
public class HyperactiveGirl {
	static final long mod = 100000000;
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line.equals("0 0")) return;
			StringTokenizer st = new StringTokenizer(line);
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			Interval[] inits = new Interval[N];
			TreeSet<Integer> nums = new TreeSet<>();
			nums.add(0); nums.add(M);
			for(int i = 0; i < N; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nums.add(a); nums.add(b);
				nums.add(b+1); //I think this is important
				inits[i] = new Interval(a,b);
			}
			HashMap<Integer,Integer> map = new HashMap<>(); int ind = 0;
			for(int k: nums){
				map.put(k,ind); ind++;
			}
			int L = map.get(M);
			Interval[] ints = new Interval[N];
			for(int i = 0; i < N; i++){
				int a = map.get(inits[i].a);
				int b = map.get(inits[i].b);
				ints[i] = new Interval(a,b);
			}
			Arrays.sort(ints);
			long[][] dp = new long[N][L+1];
			for(int i = 0; i < N; i++){
				int a = ints[i].a; int b = ints[i].b;
				if(a == 0){
					for(int k = 1; k <= b; k++){
						dp[i][k]++; dp[i][k]%=mod;
					}
				}
				else{
					for(int j = 0; j < i; j++){
						long s = dp[j][a];
						for(int k = ints[j].b+1; k <= b; k++){
							dp[i][k] += s; dp[i][k]%=mod;
						}
					}
				}
			}
			long res = 0;
			for(int i = 0; i < N; i++){
				res += dp[i][L]; res %= mod;
			}
			System.out.println(res);
		}
	}
	static class Interval implements Comparable<Interval>{
		int a, b;
		public Interval(int a, int b){
			this.a = a; this.b = b;
		}
		public int compareTo(Interval o){
			if(a == o.a) return b - o.b;
			else return a - o.a;
		}
		public String toString(){
			return a+" "+b;
		}
	}
}
