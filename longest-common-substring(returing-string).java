import java.util.*;
class Main 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String text1=sc.nextLine();
        String text2=sc.nextLine();
        int m=text1.length(),n=text2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        String res=lcs(m,n,text1,text2,dp);
        System.out.println(res);
    }
    static String lcs(int m,int n,String text1,String text2,int dp[][])
    {
        if(m==0 || n==0)
        {
            dp[m][n]=0;
            return "";
        }
        String ans="";
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    ans+=text1.charAt(i-1);
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return ans;
    }
}
