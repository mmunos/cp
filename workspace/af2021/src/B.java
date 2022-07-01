import java.util.*;
public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n >= 10) n = convert(n);
		System.out.println(n);
	}
	static int convert(int n) {
		int res = 0;
		while(n > 0) {
			res += n % 10;
			n /= 10;
		}
		return res;
	}

}
