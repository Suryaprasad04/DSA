class Solution {
    public int longestPalinSubseq(String s) {
        // code here
        String reversed = new StringBuilder(s).reverse().toString();
        
        return lcs(s,reversed);
    }
    static int lcs(String s1, String s2) {
        // code here
        int m=s1.length(),n=s2.length();
        int [][]t=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                t[i][j]=0;
            }
        }
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
    return t[m][n];
    }
}
