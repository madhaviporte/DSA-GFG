class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int n = arr.length;
        int max = -1;
        
        for(int i=0; i<n; i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        
        int sMax = -1;
        for(int i=0; i<n; i++){
            if(arr[i]>sMax && arr[i]!=max){
                sMax = arr[i];
            }
        }
        return sMax;
    }
}