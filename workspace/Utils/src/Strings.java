import java.util.*;
public class Strings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		char[] s = sc.next().toCharArray();
//		SuffixArray sa = new SuffixArray(s);
//		System.out.println(Arrays.toString(sa.rank));
		char[] s = sc.next().toCharArray();
	}
	static int[] rank(char[] s) {
		int[] arr = new int[s.length+3];
		for(int i = 0; i < s.length; i++) {
			arr[i] = s[i] - 'a';
		}
		int[] sa = new int[s.length];
		SuffixArrayFast.suffixArray(arr, sa, s.length, 26);
		int[] rank = new int[s.length+3];
		for(int i = 0; i < s.length; i++) {
			rank[sa[i]] = i;
		}
		return rank;
	}
	
	static class SuffixArrayFast { 
		// adapted from https://pastebin.com/WZb3WNQa
		// https://www.cs.helsinki.fi/u/tpkarkka/publications/icalp03.pdf
		
		// lexicographic order for pairs
		static boolean leq(int a1, int a2, int b1, int b2) {
		    return(a1 < b1 || a1 == b1 && a2 <= b2);
		}

		// and triples
		static boolean leq(int a1, int a2, int a3, int b1, int b2, int b3) {
		    return(a1 < b1 || a1 == b1 && leq(a2,a3, b2,b3));
		} // and triples

		// stably sort a[0..n-1] to b[0..n-1] with keys in 0..K from r
		static void radixPass(int[] a, int[] b, int[] r, int n, int K) {// count occurrences
		    int[] c = new int[K + 1]; // counter array
		    for (int i = 0; i <= K; i++) c[i] = 0; // reset counters
		    for (int i = 0; i < n; i++) c[r[a[i]]]++; // count occurrences
		    for (int i = 0, sum = 0; i <= K; i++) // exclusive prefix sums
		    {
		        int t = c[i];
		        c[i] = sum;
		        sum += t;
		    }
		    for (int i = 0;  i < n; i++) b[c[r[a[i]]]++] = a[i]; // sort
		}

		// find the suffix array SA of s[0..n-1] in {1..K}ˆn
		// require s[n]=s[n+1]=s[n+2]=0, n>=2
		static void suffixArray(int[] s, int[] SA, int n, int K) {
		    int n0 = (n+2)/3, n1 = (n+1)/3, n2 = n/3, n02 = n0+n2;
		    int[] s12 = new int[n02+3]; s12[n02] = s12[n02+1] = s12[n02+2] = 0;
		    int[] SA12 = new int[n02+3]; SA12[n02] = SA12[n02+1] = SA12[n02+2] = 0;
		    int[] s0 = new int[n0];
		    int[] SA0 = new int[n0];
		    // generate positions of mod 1 and mod 2 suffixes
		    // the "+(n0-n1)" adds a dummy mod 1 suffix if n%3 == 1
		    for (int i=0, j=0; i < n + (n0-n1); i++)
		        if (i%3 != 0) s12[j++] = i;
		    // lsb radix sort the mod 1 and mod 2 triples
		    int[] splus2 = new int[s.length-2]; for(int i = 2; i < s.length; i++) splus2[i-2] = s[i];
		    int[] splus1 = new int[s.length-1]; for(int i = 1; i < s.length; i++) splus1[i-1] = s[i];
		    radixPass(s12 , SA12, splus2, n02, K);
		    radixPass(SA12, s12 , splus1, n02, K);
		    radixPass(s12 , SA12, s  , n02, K);
		    // find lexicographic names of triples
		    int name = 0, c0 = -1, c1 = -1, c2 = -1;
		    for (int i = 0; i < n02; i++) {
		        if (s[SA12[i]] != c0 || s[SA12[i]+1] != c1 || s[SA12[i]+2] != c2) {
		            name++;
		            c0 = s[SA12[i]];
		            c1 = s[SA12[i]+1];
		            c2 = s[SA12[i]+2];
		        }
		        if (SA12[i]%3 == 1) s12[SA12[i]/3] = name; // left half
		        else s12[SA12[i]/3 + n0] = name; // right half
		    }
		    // recurse if names are not yet unique
		    if (name < n02) {
		        suffixArray(s12, SA12, n02, name);
		        // store unique names in s12 using the suffix array
		        for (int i = 0; i < n02; i++) s12[SA12[i]] = i + 1;
		    } else // generate the suffix array of s12 directly
		        for (int i = 0;  i < n02; i++) SA12[s12[i] - 1] = i;
		    // stably sort the mod 0 suffixes from SA12 by their first character
		    for (int i = 0, j = 0; i < n02; i++)
		        if (SA12[i] < n0) s0[j++] = 3*SA12[i];
		    radixPass(s0, SA0, s, n0, K);
		    // merge sorted SA0 suffixes and sorted SA12 suffixes
		    for (int p = 0, t = n0-n1, k = 0; k < n; k++) {
		        int i = (SA12[t] < n0 ? SA12[t] * 3 + 1 : (SA12[t] - n0) * 3 + 2); // pos of current offset 12 suffix
		        int j = SA0[p]; // pos of current offset 0 suffix
		        if (SA12[t] < n0 ? // different compares for mod 1 and mod 2 suffixes
		            leq(s[i], s12[SA12[t] + n0], s[j], s12[j/3]) :
		            leq(s[i],s[i+1],s12[SA12[t]-n0+1], s[j],s[j+1],s12[j/3+n0]))
		        {// suffix from SA12 is smaller
		            SA[k] = i; t++;
		            if (t == n02) // done --- only SA0 suffixes left
		            for (k++; p < n0; p++, k++) SA[k] = SA0[p];
		        } else {// suffix from SA0 is smaller
		            SA[k] = j; p++;
		            if (p == n0) // done --- only SA12 suffixes left
		            for (k++; t < n02; t++, k++) SA[k] = (SA12[t] < n0 ? SA12[t] * 3 + 1 : (SA12[t] - n0) * 3 + 2);
		        }
		    }
//		    delete [] s12; delete [] SA12; delete [] SA0; delete [] s0;
		}
	}
	
	static class SuffixArray{
		
		// ========================================================
		// Suffix Array Construction : Prefix Doubling + Radix Sort
		// ========================================================
		// Complexity: O(N*log(N))
		// references: https://www.cs.helsinki.fi/u/tpkarkka/opetus/10s/spa/lecture11.pdf
		// https://youtu.be/_TUeAdu-U_k
		// adapted from https://github.com/PabloMessina/Competitive-Programming-Material/blob/master/Strings/suffix_array.cpp
		
	    int n; int[] counts, rank, rank_, sa, sa_, lcp; // lcp is optional
	    int gr(int i) { return i < n ? rank[i]: 0; }
	    void csort(int maxv, int k) {
	    	counts = new int[maxv+1];
	    	for(int i = 0; i < n; i++) {
	    		counts[gr(i+k)]++;
			}
	    	for(int i = 1; i < maxv+1; i++) {
	    		counts[i] += counts[i-1];
			}
	    	for(int i = n-1; i >= 0; i--) {
	    		sa_[--counts[gr(sa[i]+k)]] = sa[i];
			}
	    	int[] aux = sa; sa = sa_; sa_ = aux;
	    }
	    void get_sa(int[] s) {
	    	for(int i = 0; i < n; i++) {
	        	sa[i] = i;
	        }
	    	sa = sortby(sa, s);
	        int r = rank[sa[0]] = 1;
	        for(int i = 1; i < n; i++) {
	        	rank[sa[i]] = (s[sa[i]] != s[sa[i-1]]) ? ++r : r;
			}
	        for (int h=1; h < n && r < n; h <<= 1) {
	            csort(r, h); csort(r, 0); r = rank_[sa[0]] = 1;
	            for(int i = 1; i < n; i++) {
	                if (rank[sa[i]] != rank[sa[i-1]] ||
	                    gr(sa[i]+h) != gr(sa[i-1]+h)) ++r;
	                rank_[sa[i]] = r;
				}
	            int[] aux = rank; rank = rank_; rank_ = aux;
	        }
	    }
	    void get_lcp(int[] s) { // lcp is optional
	    	lcp = new int[n];
	    	int k = 0;
	    	for(int i = 0; i < n; i++) {
	            int r = rank[i]-1;
	            if (r == n-1) { k = 0; continue; }
	            int j = sa[r+1];
	            while (i+k<n && j+k<n && s[i+k] == s[j+k]) k++;
	            lcp[r] = k;
	            if(k > 0) k--;
			}
	    }
	    SuffixArray(int[] s) {
	        n = s.length;
	        rank = new int[n];
	        rank_ = new int[n];
	        sa = new int[n];
	        sa_ = new int[n];
	        get_sa(s); //get_lcp(s); // lcp is optional
	    }
	    static int[] convert(char[] s) {
	    	int[] res = new int[s.length];
	    	for(int i = 0; i < s.length; i++) {
				res[i] = s[i];
			}
	    	return res;
	    }
	    SuffixArray(char[] s) {
	    	this(convert(s));
	    }
	    
	    static class Pair implements Comparable<Pair>{
			int a, b;
			public Pair(int a, int b) {
				this.a = a; this.b = b;
			}
			@Override
			public int compareTo(Pair p) {
				if(b == p.b) return a - p.a;
				else return b - p.b;
			}
			public String toString() {
				return a+" "+b;
			}
		}
		static int[] sortby(int[] arr, int[] brr) {
			//this method was implemented because the author refuses to use the Integer class
			int n = arr.length;
	    	Pair[] p = new Pair[n];
	    	for(int i = 0; i < n; i++) {
				p[i] = new Pair(i, brr[i]);
			}
	    	Arrays.sort(p);
	    	int[] aux = new int[n];
	    	for(int i = 0; i < n; i++) {
				aux[i] = arr[p[i].a];
			}
	    	return aux;
		}
		
	}

}
