import java.util.*;
public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] map = new char[n][m];
		for(int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}
		int x = 0, y = 0;
		int res = 0;
		while(x < n-1 || y < m-1) {
			if(map[x][y] == '*') res++;
			if(x == n-1) y++;
			else if(y == m-1) x++;
			else {
				if(map[x][y+1] == '*') y++;
				else if(map[x+1][y] == '*') x++;
				else y++;
			}
		}
		if(map[x][y] == '*') res++;
		System.out.println(res);
	}
}
