class Solution {
    public int minInsertions(String s) {
  
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
        return m-length;

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

// befor solving this lets look for longest common substring and longest palindrome substring 
