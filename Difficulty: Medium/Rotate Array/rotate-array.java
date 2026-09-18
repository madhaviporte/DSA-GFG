class Solution {
    public void rotateArr(int arr[], int d) {
        // code here
        int n = arr.length;
        d = d % n;
        
        // rotate d elements
        reverse(arr,0,d-1);
        
        // roated rest of array
        reverse(arr,d,n-1);
        
        // rotate whole the array
        reverse(arr,0,n-1);
    }
    
    public void reverse(int arr[], int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}