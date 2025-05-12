class Solution {
    public boolean isSubsequence(String s, String t) {
       int m=s.length(),n=t.length();
        if(LCS(s,t,m,n)==s.length()){
            return true;
        }
        return false;
    }

    public int LCS(String word1,String word2,int m,int n){
        int[][] t=new int[m+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[m][n];
       

    }
}
