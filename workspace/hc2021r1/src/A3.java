import java.util.*;
import java.io.*;
public class A3 {

	static long mod = 1000000007;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 0;
		while(T-->0) {
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			
			long res =  0;
			long c_left_x = 0;
			long c_left_f = 1;
			long c_left_o = 0;
			long r_left_x = 0;
			long r_left_f = 0; //always 0
			long r_left_o = 0;
			long r_right_x = 0;
			long r_right_f = 0;
			long r_right_o = 0;
			int qx = -1, qf = 0, qo = 1;
			long currx = 0, currf = 0, curro = 0;
			long count = 0;
			for(char c: s) {
				if(c == 'X') {
					if(qx == 1) currx = (currx + 1) % mod;
					if(qf == 1) currf = (currf + 1) % mod;
					if(qo == 1) curro = (curro + 1) % mod;
					qx = -1; qf = -1; qo = -1;
					r_right_x = (r_right_x + currx) % mod;
					r_right_f = (r_right_f + currf) % mod;
					r_right_o = (r_right_o + curro) % mod;
					
					r_left_x = (r_left_x + r_left_o) % mod;
					r_left_x = (r_left_x + c_left_o) % mod;
					r_left_o = 0;
					
					res = (res + r_left_x) % mod;
					
					c_left_x = (c_left_x + c_left_f + c_left_o) % mod;
					c_left_f = 1; c_left_o = 0;
					
					count = (count + 1) % mod;
				}
				else if(c == 'F') {
					r_right_x = (r_right_x + currx) % mod;
					r_right_f = (r_right_f + currf) % mod;
					r_right_o = (r_right_o + curro) % mod;
					
					res = (res + r_left_x + r_left_o) % mod;
					
					c_left_f = (c_left_f + 1) % mod;

					count = (count + 1) % mod;
				}
				else if(c == 'O') {
					if(qx == -1) currx = (currx + 1) % mod;
					if(qf == -1) currf = (currf + 1) % mod;
					if(qo == -1) curro = (curro + 1) % mod;
					qx = 1; qf = 1; qo = 1;
					r_right_x = (r_right_x + currx) % mod;
					r_right_f = (r_right_f + currf) % mod;
					r_right_o = (r_right_o + curro) % mod;

					r_left_o = (r_left_x + r_left_o) % mod;
					r_left_o = (r_left_o + c_left_x) % mod;
					r_left_x = 0;
					
					res = (res + r_left_o) % mod;
					
					c_left_o = (c_left_x + c_left_f + c_left_o) % mod;
					c_left_x = 0; c_left_f = 1;
					
					count = (count + 1) % mod;
				}
				else {//c == '.'
					
					res = res * 2 % mod;
					long vax = c_left_x * r_right_x % mod;
					long vaf = c_left_f * r_right_f % mod;
					long vao = c_left_o * r_right_o % mod;
					long va = (vax + vaf + vao) % mod;
					res = (res + va) % mod;
					
					long vbx = r_left_x * count % mod;
					long vbf = r_left_f * count % mod;
					long vbo = r_left_o * count % mod;
					long vb = (vbx + vbf + vbo) % mod;
					res = (res + vb) % mod;
					
					if(qf == -1) c_left_x = (count + c_left_x) % mod;
					else if(qf == 1) c_left_o = (count + c_left_o) % mod; 
					else c_left_f = (count + c_left_f) % mod;
					
					if(qf == -1) {
						r_left_x = r_left_x * 2 % mod;
						r_left_x = (r_left_x + (count * currx % mod)) % mod;
					}
					else if(qf == 1){
						r_left_o = r_left_o * 2 % mod;
						r_left_o = (r_left_o + (count * curro % mod)) % mod;
					}
					else {//cursed case - do nothing
						
					}
					
					long r_right_x_new = 0;
					long r_right_f_new = 0;
					long r_right_o_new = 0;
					if(qf == -1) {
						r_right_x_new = (r_right_x + (count * currx % mod) + r_right_x) % mod;
						r_right_f_new = (r_right_f + (count * currf % mod) + r_right_x) % mod;
						r_right_o_new = (r_right_o + (count * curro % mod) + r_right_x) % mod;
						r_right_x = r_right_x_new;
						r_right_f = r_right_f_new;
						r_right_o = r_right_o_new;
					}
					else if(qf == 1) {
						r_right_x_new = (r_right_x + (count * currx % mod) + r_right_o) % mod;
						r_right_f_new = (r_right_f + (count * currf % mod) + r_right_o) % mod;
						r_right_o_new = (r_right_o + (count * curro % mod) + r_right_o) % mod;
						r_right_x = r_right_x_new;
						r_right_f = r_right_f_new;
						r_right_o = r_right_o_new;
					}
					
					if(qf == -1) {
						currx = currx * 2 % mod;
						curro = (curro + currx) % mod;
					}
					else if(qf == 1){
						curro = curro * 2 % mod;
						currx = (currx + curro) % mod;
					}
					else {//cursed case - do nothing
						
					}
					

					count = count * 2 % mod;
				}
			}
			
			System.out.printf("Case #%d: %d\n", ++caso, res);
		}
	}
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
