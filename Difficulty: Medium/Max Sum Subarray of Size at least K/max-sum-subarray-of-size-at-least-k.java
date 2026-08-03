class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
         int n = arr.length;

        // maxEndingHere[i] = maximum sum subarray ending at i
        int[] maxEndingHere = new int[n];
        maxEndingHere[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere[i] = Math.max(arr[i], maxEndingHere[i - 1] + arr[i]);
        }

        // Sum of first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;

        // Slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];

            // Window alone
            ans = Math.max(ans, windowSum);

            // Extend window with previous best subarray
            ans = Math.max(ans, windowSum + maxEndingHere[i - k]);
        }

        return ans;
    }
}