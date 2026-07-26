class Solution {
    public int inversionCount(int arr[]) {
        // code here
          int n = arr.length;
        return mergesort(arr,0,n-1);
    }
    static int mergesort(int [] arr, int low,int high){
        int count = 0;
        if(low<high){
            int mid = (high+low)/2;
            count += mergesort(arr,low,mid);
            count += mergesort(arr,mid+1,high);
            count += merge(arr,low,mid,high);
        }
        return count;
    }
    static int merge(int[] arr, int low,int mid,int high){
        int[] tem = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int count = 0;
        int k = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                tem[k++] = arr[left++];
            }
            else{
                tem[k++] = arr[right++];
                
                count += (mid - left + 1);
            }
        }
        while(left<=mid){
            tem[k++] = arr[left++];
        }
        while(right<=high){
            tem[k++] = arr[right++];
        }
        for(int i=0;i<tem.length;i++){
            arr[low+i] = tem[i];
        }
        return count;
    }
}