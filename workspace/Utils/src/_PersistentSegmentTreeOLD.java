public class _PersistentSegmentTreeOLD {
	
	static class PST{ //Persistent Segment Tree (SUM)
	    int cnt = 0, n, rc = 0;
	    Node[] st; int[] rt;
	    
	    PST(Node[] arr) {
	    	int N = 20000007;  //max number of nodes altogether
	    	st = new Node[N]; rt = new int[100001];
	    	n = arr.length; rt[rc++] = build(arr, 0, n - 1); 
	    }
	    
	    void update(int t, int p, Node v) { 
	    	rt[rc++] = update(rt[t], p, v, 0, n - 1);
	    }
	    Node query(int t, int a, int b) { 
	    	return query(rt[t], a, b, 0, n - 1); 
	    }

	    Node query(int u, int a, int b, int i, int j) {
	        if (j < a || b < i) return new Node();
	        if (a <= i && j <= b) return st[u];
	        int m = (i + j) / 2, l = st[u].l, r = st[u].r;
	        return new Node(query(l, a, b, i, m), query(r, a, b, m + 1, j), l, r);
	    }
	    int update(int u, int p, Node v, int i, int j) {
	        if (j < p || p < i) return u;
	        st[cnt] = st[u]; int x = cnt++, m = (i + j) / 2;
	        if (i == j) { st[x] = v; return x; }
	        int l = update(st[x].l, p, v, i, m);
	        int r = update(st[x].r, p, v, m + 1, j);
	        st[x] = new Node(st[l], st[r], l, r); return x;
	    }
	    int build(Node[] arr, int i, int j) {
	        int u = cnt++, m = (i + j) / 2;
	        if (i == j) { st[u] = arr[i]; return u; }
	        int l = build(arr, i, m);
	        int r = build(arr, m + 1, j);
	        st[u] = new Node(st[l], st[l], l, r); return u;
	    }

	    int search(int a, int b, int k, int i, int j) {
	        if (i == j) return i;
	        int m = (i + j) / 2;
	        int qa = query(a, i, m).v, qb = query(b + 1, i, m).v;
	        if (qb - qa >= k) return search(a, b, k, i, m);
	        else return search(a, b, k - qb + qa, m + 1, j);
	    }
	    
	    static class Node{ //(SUM)
		    int v, l, r;
		    public Node() {
		    	this.v = 0; this.l = 0; this.r = 0;
		    }
		    public Node(Node p) {
		    	this.v = p.v; this.l = p.l; this.r = p.r;
		    }
		    public Node(int v) {
		    	this.v = v;
		    }
		    public Node(Node a, Node b, int l, int r) {
		    	this.l = l; this.r = r;
		    	this.v = a.v + b.v;
		    }
		    public String toString() {
		    	return l+"-"+r+": "+v;
		    }
		}
	}
	

}
