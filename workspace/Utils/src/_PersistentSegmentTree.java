public class _PersistentSegmentTree {
	
	public static void main(String...eljuego) {
		int[] arr = {2, 6, 2, 1, 5};
		Vertex v1 = PST.build(arr, 0, 4); //communicate range limits (l and r inclusive) externally
		Vertex v2 = PST.update(v1, 0, 4, 3, 4); //
		System.out.println(PST.get_sum(v1, 0, 4, 0, 1));
		System.out.println(PST.get_sum(v1, 0, 4, 3, 4));
		System.out.println(PST.get_sum(v2, 0, 4, 3, 4));
	}
	
	static int globid = 0;
	static class Vertex { //vertex does not know the range it spans
	    Vertex l, r;
	    int sum;
	    int id;

	    Vertex(int val){
	    	this.sum = val;
	    	this.id = globid++;
	    }
	    Vertex(Vertex l, Vertex r){
	    	this.l = l; this.r = r; this.sum = 0;
	    	if(l != null) this.sum += l.sum;
	    	if(r != null) this.sum += r.sum;
	    	this.id = globid++;
	    }
	    public String toString() {
	    	int lid = l == null ? -1 : l.id;
	    	int rid = r == null ? -1 : r.id;
	    	return id+" - l:"+lid+" r:"+rid+" ("+sum+")";
	    }
	}
	static class PST{
		static Vertex build(int a[], int tl, int tr) {
		    if (tl == tr)
		        return new Vertex(a[tl]);
		    int tm = (tl + tr) / 2;
		    return new Vertex(build(a, tl, tm), build(a, tm+1, tr));
		}

		static int get_sum(Vertex v, int tl, int tr, int l, int r) {
		    if (l > r)
		        return 0;
		    if (l == tl && tr == r)
		        return v.sum;
		    int tm = (tl + tr) / 2;
		    return get_sum(v.l, tl, tm, l, Math.min(r, tm))
		         + get_sum(v.r, tm+1, tr, Math.max(l, tm+1), r);
		}

		static Vertex update(Vertex v, int tl, int tr, int pos, int new_val) {
		    if (tl == tr)
		        return new Vertex(new_val);
		    int tm = (tl + tr) / 2;
		    if (pos <= tm)
		        return new Vertex(update(v.l, tl, tm, pos, new_val), v.r);
		    else
		        return new Vertex(v.l, update(v.r, tm+1, tr, pos, new_val));
		}
	}
	

}
