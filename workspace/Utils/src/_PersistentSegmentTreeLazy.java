public class _PersistentSegmentTreeLazy {
	
	public static void main(String...eljuego) {
		int[] arr = {2, 6, 2, 1, 5};
		Vertex v1 = PST.build(arr, 0, 4);
		Vertex v2 = PST.update(v1, 0, 4, 3, 4, 4);
		System.out.println(PST.get_sum(v1, 0, 4, 0, 1));
		System.out.println(PST.get_sum(v1, 0, 4, 3, 4));
		System.out.println(PST.get_max(v2, 0, 4, 3, 4));
		System.out.println(PST.get_max(v2, 0, 4, 0, 3));
	}
	
	static int globid = 0;
	static class Vertex {
	    Vertex l, r;
	    int sum, max, lazy;
	    int id;

	    Vertex(int val){
	    	this.sum = this.max = val; 
	    	this.lazy = 0;
	    	
	    	this.id = globid++;
	    }
	    Vertex(Vertex v, int lazy) {
	    	this.l = v.l; this.r = v.r;
	    	this.sum = v.sum; this.max = v.max; this.lazy = v.lazy + lazy;
	    	
	    	this.id = globid++;
	    }
	    Vertex(Vertex l, Vertex r, int tl, int tr, int lazy){
	    	this.l = l; this.r = r; this.lazy = lazy;
	    	this.sum = 0; this.max = Integer.MIN_VALUE;
	    	int tm = (tl + tr) / 2;
	    	if(l != null) {
	    		this.sum += l.sum + l.lazy * (tm - tl + 1); 
	    		this.max = Math.max(this.max, l.max + l.lazy);
	    	}
	    	if(r != null) {
	    		this.sum += r.sum + r.lazy * (tr - (tm + 1) + 1);
	    		this.max = Math.max(this.max, r.max + r.lazy);
	    	}
	    	this.id = globid++;
	    }
	    public String toString() {
	    	int lid = l == null ? -1 : l.id;
	    	int rid = r == null ? -1 : r.id;
	    	return String.format("%d - l:%d r:%d sum:%d max:%d lazy:%d", id, lid, rid, sum, max, lazy);
	    }
	}
	static class PST{ //SUM, MAX
		static Vertex build(int a[], int tl, int tr) {
		    if (tl == tr)
		        return new Vertex(a[tl]);
		    int tm = (tl + tr) / 2;
		    return new Vertex(build(a, tl, tm), build(a, tm+1, tr), tl, tr, 0);
		}

		static int get_sum(Vertex v, int tl, int tr, int l, int r) {
		    if(l > tr || r < tl)
		        return 0;
		    if(l <= tl && tr <= r)
		        return v.sum + v.lazy * (tr - tl + 1);
		    int tm = (tl + tr) / 2;
		    v = propagate(v, tl, tr);
		    return get_sum(v.l, tl, tm, l, r)
		         + get_sum(v.r, tm+1, tr, l, r);
		}
		
		static int get_max(Vertex v, int tl, int tr, int l, int r) {
		    if(l > tr || r < tl)
		        return Integer.MIN_VALUE;
		    if(l <= tl && tr <= r)
		        return v.max + v.lazy;
		    int tm = (tl + tr) / 2;
		    v = propagate(v, tl, tr);
		    return Math.max(get_max(v.l, tl, tm, l, r),
		    				get_max(v.r, tm+1, tr, l, r));
		}
		
		static Vertex propagate(Vertex v, int tl, int tr) {
			Vertex vl = v.l == null ? null : new Vertex(v.l, v.lazy);
			Vertex vr = v.r == null ? null : new Vertex(v.r, v.lazy);
			return new Vertex(vl, vr, tl, tr, -v.lazy);
		}
		
		static Vertex update(Vertex v, int tl, int tr, int posl, int posr, int delta) {
		    if(posl <= tl && tr <= posr) {
		    	if (tl == tr) //leaf case
			        return new Vertex(v.sum + delta);
		    	else //lazy case
		    		return new Vertex(v.l, v.r, tl, tr, v.lazy + delta);
		    }
		    if(posl > tr || posr < tl)
		    	return v;
		    int tm = (tl + tr) / 2;
		    Vertex vl = update(v.l, tl, tm, posl, posr, delta + v.lazy);
		    Vertex vr = update(v.r, tm+1, tr, posl, posr, delta + v.lazy);
		    return new Vertex(vl, vr, tl, tr, 0);
		}
	}
	

}
