import java.util.*;
public class Balt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()+1;
		char[] s = (sc.next()+"1").toCharArray();
		char[] t = (sc.next()+"1").toCharArray();
		int res = 0;
		int i = 0, j = 0;
		for(; i < n && j < n; i++, j++) {
			while(i < n && s[i] != '0') i++;
			while(j < n && t[j] != '0') j++;
			if(i != j) res++;
		}
		if(i != j) res = -1;
		System.out.println(res);
	}

}
