class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int pivot = -1;
        
        // find the pivote number;
        for(int i=n-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                pivot = i;
                break;
            }
        }
        
        // find the just greater number to pivote
        if(pivot != -1){
            for(int i=n-1; i>pivot; i--){
                if(arr[i]>arr[pivot]){
                    int c = arr[i];
                    arr[i] = arr[pivot];
                    arr[pivot] = c;
                    break;
                }
            }
        }
        
        // reverse the number
        
        int st = pivot + 1;
        int end = n-1;
        while(st<end){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }
}