import java.io.*;
import java.util.*;
public class Electricity {
	public static void main(String...thegame)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n = Integer.parseInt(br.readLine().trim());
			if(n == 0) return; Date prev = null; int cont = 0; int tot = 0; int prevc = 0;
			for(int i = 0; i < n; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int d = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				Date curr = new Date(d,m,y);
				if(prev != null && prev.nextDate().equals(curr)){
					cont++; tot += (c-prevc);
				}
				prev = curr; prevc = c;
			}
			System.out.printf("%d %d\n",cont,tot);
		}
		
	}
	static class Date{
		int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int d, m, y;
		public Date(int d, int m, int y){
			this.d = d; this.m = m; this.y = y;
			month[2] += leap();
		}
		int leap(){
			if(y%400==0) return 1;
			if(y%100==0) return 0;
			if(y%4==0) return 1;
			return 0;
		}
		Date nextDate(){
			if(d < month[m]) return new Date(d+1,m,y);
			if(d == month[m] && m < 12) return new Date(1,m+1,y);
			return new Date(1,1,y+1);
		}
		boolean equals(Date o){
			return d == o.d && m == o.m && y == o.y;
		}
		public String toString(){
			return d+"/"+m+"/"+y;
		}
	}
	
}
