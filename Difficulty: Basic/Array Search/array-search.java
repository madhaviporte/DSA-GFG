class Solution {
    public int search(int arr[], int x) {
        // code here
        // code here
        int result = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == x)
            {
                result = i;
                break;
            }else{
                result = -1;
            }
            
        }
        return result;
    }
}
