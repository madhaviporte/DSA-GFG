class Solution {
    public int palindromicStrings(int n, int k) {
        // code here
        final long MOD = 1_000_000_007L;

        long ans = 0;
        long perm = 1;

        for (int m = 0; 2 * m <= n; m++) {

            // P(k, m)
            if (m > 0) {
                perm = (perm * (k - m + 1)) % MOD;
            }

            // Odd length: 2*m + 1
            if (2 * m + 1 <= n) {
                ans = (ans + perm * (k - m)) % MOD;
            }

            // Even length: 2*m
            if (m > 0 && 2 * m <= n) {
                ans = (ans + perm) % MOD;
            }
        }

        return (int) ans;
    }
}