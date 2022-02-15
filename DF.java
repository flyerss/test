package À¶ÇÅcode;

import java.util.Scanner;

class DF{
	public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int buy_num = sc.nextInt();
	int coll_num=sc.nextInt();
	double p = 1.0/coll_num;
	double [][] dp= new double[buy_num+1][coll_num+1];
	dp[1][1]=1;
	
	for(int i1=2;i1<=buy_num;i1++) {
		for(int i2=2;i2<=coll_num;i2++) {
			if(i1<i2)dp[i1][i2]=0;
			else if(i2==1)dp[i1][i2]=1;
			else if(i2==i1)dp[i1][i2]=Math.pow(p, i2-1);
			else if(i1>i2)dp[i1][i2]=Math.pow(p, i2-1);
			else 
				dp[i1][i2]
		}
	}
	
	
	}
}
//result=1*(1-1/n)*(1-2/n)*(1-3/n)---(1-n-1/n);