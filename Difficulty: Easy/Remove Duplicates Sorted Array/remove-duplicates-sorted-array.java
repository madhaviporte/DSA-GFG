class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        
        if(n==0){
            res.add(0);
            return res;
        }
        
        int i=0;
        
        for(int j=1; j<n; j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        for(int k=0; k<=i; k++){
            res.add(arr[k]);
        }
        return res;
    }
}
