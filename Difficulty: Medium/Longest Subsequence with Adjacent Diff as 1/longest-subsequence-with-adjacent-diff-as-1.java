class Solution {
    public int longestSubseq(int[] arr) {
        // code here
        int n = arr.length;
        
        if(arr==null || n==0){
            return 0;
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        int maxlength = 0;
        
        for(int num : arr){
            int current = 1;

                      if (map.containsKey(num - 1)) {
                          current = Math.max(current, map.get(num - 1) + 1);
                      }

                      if (map.containsKey(num + 1)) {
                          current = Math.max(current, map.get(num + 1) + 1);
                      }

                      map.put(num, current);

                      maxlength = Math.max(maxlength, current);
                  }

                  return maxlength;
        
    }
}
