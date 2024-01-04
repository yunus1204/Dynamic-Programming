//    Method - 1
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        int length=lcs(m,n,text1,text2,dp);
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


// or  


// Method - 2
 // Matrix concept
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];        
    }
    /*
    Approach

    We have 2 state variables - i and j. \
    i is for text1 length, j for text2 length

    As our dp should solve subproblems which are overlapping, we assume that our memo[i][j] will contain the answer to that problem for i and j lengths

    f(0,0) = 0
    f(1,0) = 0
    f(0,1) = 0
    as there is just one word (length > 0)

    f(1,1) = 1 if text1[1] == text2[1], 0 otherwise
    f(1,2) = f(1,1)
    f(2,1) = f(1,1)

    f(2,2) = f(1,1) + 1 if text1[2] == text2[2], 0 otherwise
    f(5,3) = f(4,3) + 1 if text1[5] == text2[4], 0 otherwise   

    We should check constraints for strings with different lengths!
    If the characters are equal we move to the right in both strings
    If not, we move to the right in the one

    f(i,j) = f(i - 1, j) + {1, if text1[i] = text2[j]; 0}

    Had some issues. If text[i] = text[j] we add 1 to solution with text1(0, i - 1) and text2(0, j - 1)
    Otherwise take max solution for (text1(i, j - 1) and text(j, i - 1))
    
     */
}
