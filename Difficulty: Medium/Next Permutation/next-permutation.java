class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int pivot = -1;
        
        //find pivote number
        for(int i=n-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                pivot=i;
                break;
            }
        }
        
        //find number which is greter than pivot number
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
        
        //revers element after pivot
        int st = pivot + 1;
        int end = n-1;
        while(st<end){
            int d = arr[st];
            arr[st] = arr[end];
            arr[end] = d;
            st++;
            end--;
        }
    }
}