class Solution {
    public int getMaxWeight(String s) {
        // code here
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
        int single = 1 + dp[i+1];
        int pair = 0;
        if(i+1 < n) {
            if(s.charAt(i) != s.charAt(i+1))
                pair = 4 + dp[i+2];
            else
                pair = 3 + dp[i+2];
        }
        dp[i] = Math.max(single, pair);
        }
        return dp[0];
    }
}