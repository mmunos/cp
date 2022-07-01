import java.util.*;
public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(i % 2 == 0) arr[i] = -arr[i];
		}
		HashMap<Long, Integer> stat = new HashMap<>();
		stat.put(0L, 1);
		long curr = 0;
		long res = 0;
		for(int i = 0; i < n; i++) {
			curr += arr[i];
			if(stat.containsKey(curr)) {
				res += stat.get(curr);
				stat.put(curr, stat.get(curr) + 1);
			}
			else {
				stat.put(curr, 1);
			}
		}
		System.out.println(res);
	}

}
