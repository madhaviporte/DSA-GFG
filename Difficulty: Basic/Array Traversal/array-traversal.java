class Solution {
    public static void arrayTraversal(int[] arr) {
        // Code here
        int idx = 0;
        while(arr.length!=0){
            System.out.print(arr[idx] + " ");
            idx++;
            if(idx==arr.length) return;
        }
    }
}
