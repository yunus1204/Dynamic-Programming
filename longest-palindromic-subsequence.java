// Method -1
class Solution {
    public int longestPalindromeSubseq(String s) {
        int start=0;
        int end=s.length()-1;
        int m=s.length();
        char arr[]=s.toCharArray();
        while(start<end)
        {
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        String t=new String(arr);
        int dp[][]=new int[m+1][m+1];
        int length=lcs(m,m,s,t,dp);
        return length;

    }
    int lcs(int m,int n,String s,String t,int[][] dp)
    {
        if(m==0)
        {
            dp[m][n]=0;
            return 0;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

// or 
// Method - 2
    public int longestPalindromeSubseq(String s) {
        int m=s.length();
        int start=0;
        int end=s.length()-1;
        char arr[]=s.toCharArray();
        while(start<end)
        {
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        String t=new String(arr);
        int n=t.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        int length=lcs(m,n,s,t,dp);
        return length;
    }
    static int lcs(int m,int n,String text1,String text2,int dp[][])
    {
        if(m==0 || n==0)
        {
            dp[m][n]=0;
            return 0;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        if(text1.charAt(m-1)==text2.charAt(n-1))
        {
            dp[m][n]=1+lcs(m-1,n-1,text1,text2,dp);
            return dp[m][n];
        }
        int a=lcs(m-1,n,text1,text2,dp);
        int b=lcs(m,n-1,text1,text2,dp);
        dp[m][n]=Math.max(a,b);
        return dp[m][n];
    }
}

