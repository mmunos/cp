
public class p154 {

	public static void main(String[] args) {
		int n = 200000;
		int[][] ps = new int[n+1][2];
		for(int i = 1; i <= n; i++) {
			int aux = i;
			while(aux % 2 == 0) {
				ps[i][0]++; aux /= 2;
			}
			while(aux % 5 == 0) {
				ps[i][1]++; aux /= 5; 
			}
		}
		int[][] fac = new int[n+1][2];
		for(int i = 1; i <= n; i++) {
			fac[i][0] = fac[i-1][0] + ps[i][0];
			fac[i][1] = fac[i-1][1] + ps[i][1];
		}
		int res = 0;
		for(int i = 0; i <= n; i++) {
			int[] ch = new int[2];
			ch[0] = fac[n][0] - fac[i][0] - fac[n-i][0];
			ch[1] = fac[n][1] - fac[i][1] - fac[n-i][1];
			if(ch[0] >= 12 && ch[1] >= 12) {
				res += (i+1);
			}
			else {
				for(int j = 0; j <= i; j++) {
					int[] dh = new int[2];
					dh[0] = fac[i][0] - fac[j][0] - fac[i-j][0];
					dh[1] = fac[i][1] - fac[j][1] - fac[i-j][1];
					if(ch[0] + dh[0] >= 12 && ch[1] + dh[1] >= 12) {
						res++;
					}
				}
			}
		}
		System.out.println(res);
	}

}
