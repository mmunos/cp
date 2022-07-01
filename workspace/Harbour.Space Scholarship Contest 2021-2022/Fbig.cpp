#include <iostream>
#include <vector> 
#include <cmath>
#include <algorithm> 
using namespace std;
#define int64 long long

const int bignumlen=2; 
const int64 base=100000000; //对应的基数 


struct bignum{
	int len;
	int64 data[bignumlen];
	int64 &operator [](int x){ return(data[x]);}
	const int64 &operator [](int x)const { return(data[x]);}
	bignum (){
		memset(data,0,sizeof(data));
		len=0;
	}
	void clear(){
		for(int i=len;i>=1;--i)data[i]=0;
		len=0;
	}
	int check (const bignum &a,const bignum &b){
		if(a.len>b.len)return(0);
		if(b.len>a.len)return(1);
		for(int i=a.len;i>=1;--i){
			if(a.data[i]<b.data[i])return(1);
			if(b.data[i]<a.data[i])return(0);
		}
		return 2;
	}
	bool operator < (const bignum &b){ return(check(*this,b)==1);}
	bool operator > (const bignum &b){ return(check(*this,b)==0);}
	bool operator <=(const bignum &b){ return(check(*this,b)>=1);}
	bool operator >=(const bignum &b){ return(check(*this,b)%2==0);}
	bool operator !=(const bignum &b){ return(check(*this,b)!=2);}
	bool operator ==(const bignum &b){ return(check(*this,b)==2);}
	
	bignum operator=(const bignum &x){
		for(int i=x.len+1;i<=len;++i)data[i]=0;
		for(int i=1;i<=x.len;++i)data[i]=x.data[i];
		len=x.len;
		return *this;
	}
	bignum operator=(int64 x){
		for(int i=len;i>=0;--i)data[i]=0;
		len=0;
		while(x){
			data[++len]=x%base;
			x/=base;
		}
		return *this;
	}
	bignum(int64 x){
		memset(data,0,sizeof(data));
		len=0;
		(*this)=x;
	}
	bignum operator *(const bignum &b){
		int i,j;
		bignum tmp;
		for(i=1;i<=len;++i)if(data[i]!=0)
			for(j=1;j<=b.len;++j)if(b.data[j]!=0){
				tmp.data[i+j-1]+=data[i]*b.data[j];
				tmp.data[i+j]+=tmp.data[i+j-1]/base;
				tmp.data[i+j-1]%=base;
			}
		tmp.len=len+b.len-1;
		while(tmp.data[tmp.len+1])tmp.len++;
		return tmp;
	}
	bignum operator *(int64 x){
		int i;
		bignum tmp;
		for(i=1;i<=len;++i)tmp[i]=data[i]*x;
		tmp.len=len;
		for(i=1;i<=len;++i){
			tmp[i+1]+=tmp[i]/base,tmp[i]%=base;
			if(tmp[i+1]&&i+1>tmp.len)tmp.len++;
		}
		return tmp;
	}
	bignum operator /(int64 x){
		int i;
		bignum tmp;
		int64 y=0;
		for(i=len;i>=1;--i){
			y=y*base+data[i];
			tmp[i]=y/x;
			y%=x;
		}
		tmp.len=len;
		while(tmp[tmp.len]==0&&tmp.len>1)tmp.len--;
		return tmp;
	}
	bignum operator +(const bignum &b){
		bignum tmp;
		int i,l=max(len,b.len);
		for(i=1;i<=l;++i)tmp[i]=data[i]+b[i];
		for(i=1;i<=l;++i)tmp[i+1]+=tmp[i]/base,tmp[i]%=base;
		tmp.len=l;
		if(tmp[tmp.len+1])tmp.len++;
		return tmp;
	}
	bignum operator +(int64 x){
		bignum tmp; tmp=*this;
		tmp[1]+=x;
		for(int i=1;i<=len&&tmp[i]>=base;++i)tmp[i+1]+=tmp[i]/base,tmp[i]%=base;
		while(tmp[tmp.len+1])tmp.len++;
		return tmp;
	}
	bignum operator -(const bignum &b){
		int i;
		bignum tmp;
		for(i=1;i<=len;++i)tmp.data[i]=data[i]-b.data[i];
		for(i=1;i<=len;++i){
			if(tmp[i]<0)tmp.data[i]+=base,tmp.data[i+1]--;
		}
		tmp.len=len;
		while(tmp[tmp.len]==0&&tmp.len>1)tmp.len--;
		return tmp;
	}
	bignum operator -(int64 x){
		bignum tmp; tmp=*this;
		tmp[1]-=x;
		for(int i=1;i<=len&&tmp[i]<0;++i){
			tmp[i+1]+=(tmp[i]+1)/base-1;
			tmp[i]=(tmp[i]+1)%base+base-1;
		}
		while(!tmp[tmp.len]&&tmp.len>1)tmp.len--;
		return tmp;
	}
	
	bignum operator +=(const bignum &b){return *this=(*this+b);}
	bignum operator *=(const bignum &b){return *this=(*this*b);}
	bignum operator -=(const bignum &b){return *this=(*this -b);}
	bignum operator *=(int64 x) {return( *this=(*this *x));}
	bignum operator +=(int64 x) {return( *this=(*this +x));}
	bignum operator -=(int64 x) {return( *this=(*this -x));}
	bignum operator /=(int64 x) {return( *this=(*this /x));}
	void write(){
		printf("%I64d",data[len]);
		for(int i=len-1;i>=1;--i)printf("%0*I64d",8,data[i]);
	}
};

int N = 300003;
int sqN = 10;

int main(){
    int n;
    cin >> n;
    int sqn = 400;
    int arr[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
	vector<bignum> res; res.resize(n);
	vector<bignum> f; f.resize(N+1);
	vector<bignum> facc; facc.resize(N+1);
	vector<bignum> fiacc; fiacc.resize(N+1);
    bignum asum = 0;
	vector<bignum> smallmods; smallmods.resize(n);

	for(int iter = 0; iter < n; iter++){
        int a = arr[iter];
        bignum val = 0;

        //a mod the rest
        //n * a - sum_{k = 1..N} k * c(k) * [a / k] . 
        val += ((int64)a) * iter;

        //the rest mod a
        //sum_{i < n} arr[i] - sum_{k = 1..N} c(k) * a * [k / a] . 
        val += asum;

        res[iter] += val;

    	cout << "ok5" << endl;

        asum += a;
    }

    for(int iter = 0; iter < n; iter++){
        int a = arr[iter];
    	cout << "ok" << endl;
        if(iter % sqn == 0){//update
            for(int d = 1; d <= sqn && iter-d >= 0; d++){
                for(int i = 1; i < sqN; i++){
                    smallmods[i] += (arr[iter-d] / i) * i;
                }
                f[arr[iter-d]] += 1;
            }
            for(int i = 1; i <= N; i++){
                facc[i] = f[i] * i;
                facc[i] += facc[i-1];
                fiacc[i] = f[i];
                fiacc[i] += fiacc[i-1];
            }
        }
        bignum val = res[iter];
    	cout << "ok2" << endl;


        //a mod the rest
        //n * a - sum_{k = 1..N} k * c(k) * [a / k] . 
        //val += ((int64)a) * iter;
    	cout << "ok22" << endl;
        int sqa = (int)sqrt(a);
    	cout << "ok223" << endl;
        for(int d = 1; d < sqa; d++){
            int l = a / (d+1) + 1, r = a / d;
    		cout << "ok23" << endl;
            val -= (facc[r] - facc[l-1]) * d;
    		cout << "ok24" << endl;
        }
    	cout << "ok224" << endl;
		cout << sqa << endl;
        for(int i = a / sqa; i >= 1; i--){
    		cout << "ok226" << endl;
            val -= (f[i] * i) * (a / i);
    		cout << "ok25" << endl;
        }
    	cout << "ok3" << endl;

        //the rest mod a
        //sum_{i < n} arr[i] - sum_{k = 1..N} c(k) * a * [k / a] . 
        //val += asum;
        if(a < sqN){
            val -= smallmods[a];
        }
        else{
            int mul = 1;
            while((mul+1) * a <= N){
                val -= (fiacc[(mul+1) * a] - fiacc[mul * a - 1]) * a * mul;
                mul++;
            }
            val -= (fiacc[N] - fiacc[mul * a - 1]) * a * mul;
        }
    	cout << "ok4" << endl;

        res[iter] = val;
        //offline update
        for(int it = iter+1; it < n && it % sqn != 0; it++){
            res[it] -= a * (arr[it] / a);
            res[it] -= arr[it] * (a / arr[it]);
        }
    	cout << "ok5" << endl;

        asum += a;
    }
    bignum totres = 0;
    for(int i = 0; i < n; i++){
        totres += res[i];
        totres.write();
        if(i < n-1) cout << ' ';
    }
    cout << '\n';
}