package com.wg.demo.calculate.leetcode;

public class IsInterleave {


    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean result = isInterleave2(s1, s2, s3);
        System.out.println(result);

    }

    private static boolean isInterleave2(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length();
        if(length1 + length2 != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[length1+1][length2+1];
        dp[0][0] = true;
        for(int i=1; i<length1; i++){
            if(s1.charAt(i)==s3.charAt(i)){
                dp[i][0] = true;
            }
        }
        for(int i=1; i<length2; i++){
            if(s2.charAt(i)==s3.charAt(i)){
                dp[0][i] = true;
            }
        }
        for(int i=1; i<=length1; i++){
            for(int j=1; j<=length2; j++){
                dp[i][j] = (dp[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1))
                        || (dp[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1));
            }
        }
        return dp[length1][length2];
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) return false;
        // 动态规划，dp[i,j]表示s1前i字符能与s2前j字符组成s3前i+j个字符；
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m && s1.charAt(i - 1) == s3.charAt(i - 1); i++) dp[i][0] = true; // 不相符直接终止
        for (int j = 1; j <= n && s2.charAt(j - 1) == s3.charAt(j - 1); j++) dp[0][j] = true; // 不相符直接终止
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[m][n];
    }

}
