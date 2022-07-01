import java.util.*;
public class p096 {
	
	static int N = 9;
	public static void main(String...strings) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tot = 0;
		while(T-- > 0) {
			int[][] board = new int[N][N];
			for(int i = 0; i < N; i++) {
				char[] s = sc.next().toCharArray();
				for(int j = 0; j < N; j++) {
					board[i][j] = s[j] - '0';
				}
			}
			fill(board, 0, 0);
			tot += board[0][0] * 100;
			tot += board[0][1] * 10;
			tot += board[0][2] * 1;
		}
		System.out.println(tot);
	}
	static boolean fill(int[][] b, int x, int y) {
		if(b[x][y] == 0) {
			for(int d = 1; d <= N; d++) {
				if(check(b, x, y, d)) {
					b[x][y] = d;
					int u = x, v = y + 1;
					if(v == N) {
						v = 0; u++;
						if(u == N) {
							return true;
						}
					}
					if(fill(b, u, v)) return true;
					else b[x][y] = 0;
				}
			}
			return false;
		}
		else {
			int u = x, v = y + 1;
			if(v == N) {
				v = 0; u++;
				if(u == N) {
					return true;
				}
			}
			return fill(b, u, v);
		}
	}
	static boolean check(int[][] b, int x, int y, int d) {
		for(int i = 0; i < N; i++) {
			if(b[x][i] == d) return false;
			if(b[i][y] == d) return false;
		}
		int x0 = x / 3 * 3, y0 = y / 3 * 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(b[x0 + i][y0 + j] == d) return false;
			}
		}
		return true;
	}

}
