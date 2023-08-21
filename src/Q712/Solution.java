package Q712;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] dpTable = new int [s1Len+1][s2Len+1];
        for (int i=0;i<=s1Len;i++) {
            for (int j=0;j<=s2Len;j++) {
                if (i==0 || j==0) {
                    dpTable[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dpTable[i][j] = Math.max(Math.max(dpTable[i-1][j-1] + s1.charAt(i-1), dpTable[i-1][j]), dpTable[i][j-1]);
                } else {
                    dpTable[i][j] = Math.max(Math.max(dpTable[i-1][j], dpTable[i][j-1]), dpTable[i-1][j-1]);
                }
            }
        }

        int sum = 0;
        for (int i=0;i<s1Len;i++) {
            sum = sum + s1.charAt(i);
        }
        for (int j=0;j<s2Len;j++) {
            sum = sum + s2.charAt(j);
        }
        return sum - 2 * dpTable[s1Len][s2Len];
    }
}
