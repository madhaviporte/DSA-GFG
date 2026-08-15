class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        Map<Integer,Integer> arrMap = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            int rem = target - arr[i];
            
            if(arrMap.containsKey(rem)){
                return true;
            }
                arrMap.put(arr[i],i);
            
        }
        return false;
    }
}