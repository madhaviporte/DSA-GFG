class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int n = arr.length;
        int max = -1;
        
        for(int i=0; i<n; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int Smax = -1;
        for(int i=0; i<n; i++){
            if(arr[i]> Smax && arr[i] != max){
                Smax = arr[i];
            }
        }
        return Smax;
    }
}