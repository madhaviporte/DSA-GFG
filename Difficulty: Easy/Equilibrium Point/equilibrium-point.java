class Solution {
    public static int findEquilibrium(int arr[]) {
        // code here
         int total = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int left = 0;
        for(int i = 0; i < arr.length; i++) {
            int right = total - left - arr[i];
            if(right == left){
                return i;
            }
            left += arr[i];
            
        }
        return -1;
    }
}
