class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        int ans = arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]<0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i],max*arr[i]);
            min = Math.min(arr[i], min*arr[i]);
            ans = Math.max(ans,max);
        }
        return ans;
        
    }
}