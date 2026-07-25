class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
          int[] freq = new int[100001];
        for(int i: arr) {
            freq[i]++;
        }
        for(int i=0; i< freq.length; i++) {
            while(freq[i] > 0) {
                k--;
                if(k == 0) return i;
                freq[i]--;
            }
        }
        
        return -1;
    }
}
