#include <stdio.h>
#include <string.h>

int nextval[683];
int compmap[683][683];
int rangmap[683];

int M = 1000007;
int rang(int x){
	int res = 0;
	while(x > 0){
		if((x&1)==1) res++;
		x >>= 1;
	}
	return res;
}
int sum(int a, int b){
	return (a+b)%M;
}
int king(int hash, int pos){
	return (hash & (1 << pos)) > 0;
}
int valid(int hash){
	for(int i = 0; i < 9; i++){
		if(king(hash, i) && king(hash, i+1)) return 0;
	}
	return 1;
}
int compatible(int h1, int h2){//h1 > h2
	while(h2 > 0){
		if( ( (h1 & 1) == 1) && ( (h2 & 1) == 1 ) ) return 0;
		if( ( (h1 & 2) == 2) && ( (h2 & 1) == 1 ) ) return 0;
		if( ( (h1 & 1) == 1) && ( (h2 & 2) == 2 ) ) return 0;
		h1 >>= 1; h2 >>= 1;
	}
	return 1;
}
int comp(int h1, int h2){
	if(h1 == h2){
		if(h1 == 0) return 1;
		else return 0;
	}
	else if(h1 < h2) return compmap[h2][h1];
	else return compmap[h1][h2];
}

int main(){
	int n, m, k;
	scanf("%d %d %d", &n, &m, &k);

	int maxm = (1 << m);
	if(m == 8) maxm = 171;
	if(m == 9) maxm = 342;
	if(m == 10) maxm = 683;

	int dp[51][683][9];
	memset(dp, 0, sizeof(dp[0][0][0])*n*maxm*(k+1));

	int lastval = 0;
	memset(nextval, -1, sizeof(nextval[0])*683);
	for(int h = 1; h < 683; h++){
		if(valid(h)){
			nextval[lastval] = h;
			lastval = h;
		}
		rangmap[h] = rang(h);
		int g = 0;
		while(g >= 0 && g < h){
			compmap[h][g] = compatible(h,g);
			g = nextval[g];
		}
	}

	for(int i = 0; i < n; i++){
		if(i == 0){
			int hash = 0;
			while(hash >= 0 && hash < maxm){
				int r = rangmap[hash];
				if(r <= k) dp[0][hash][r] = 1;
				hash = nextval[hash];
			}
		}
		else{
			int hash = 0;
			while(hash >= 0 && hash < maxm){
				int r = rangmap[hash];
				for(int s = 0; s+r <= k; s++){
					int h = 0;
					while(h >= 0 && h < maxm){
						if(comp(hash,h)){
							dp[i][hash][s+r] = sum(dp[i][hash][s+r], dp[i-1][h][s]);
						}
						h = nextval[h];
					}
				}
				hash = nextval[hash];
			}
		}
	}
	int res = 0, hash = 0;
	while(hash >= 0 && hash < maxm){
		res = sum(res, dp[n-1][hash][k]); 
		hash = nextval[hash];
	}
	printf("%d\n", res);
}
