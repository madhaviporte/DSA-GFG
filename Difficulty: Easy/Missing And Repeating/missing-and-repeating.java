class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
         int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-1,-1));
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(int i=1;i<=n;i++)
        {
            if(!map.containsKey(i))
            {
                list.set(1,i);
            }
            else if(map.get(i) > 1)
            {
                list.set(0,i);
            }
        }
        return list;
    }
}
