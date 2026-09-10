class Solution {
    ArrayList<Integer> remDuplicate(int arr[]) {
        // code here
        int n = arr.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }
        return new ArrayList<>(set);
    }
}