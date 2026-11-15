class Solution {
    public int subsequenceSum(String s) {
        // code here
        long mod = 1000000007;

               long sum = 0;
               for (int i = 0; i < s.length(); i++) {
                   sum = (sum + (s.charAt(i) - '0')) % mod;
               }

               long pow = 1;
               for (int i = 1; i < s.length(); i++) {
                   pow = (pow * 2) % mod;
               }

               long ans = (sum * pow) % mod;

               return (int) ans;
    }
}