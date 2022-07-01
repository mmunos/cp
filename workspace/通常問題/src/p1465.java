import java.util.*;
public class p1465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		dist[1] = 0;
		while(!q.isEmpty()) {
			int u = q.remove();
			int a = 2 * u;
			if(a <= n && dist[a] < 0) {
				dist[a] = dist[u]+1;
				q.add(a);
			}
			int b = u + 3;
			if(b <= n && dist[b] < 0) {
				dist[b] = dist[u] + 1;
				q.add(b);
			}
		}
		if(dist[n] >= 0 && dist[n] <= k) System.out.println("YES");
		else System.out.println("NO");
	}

}
