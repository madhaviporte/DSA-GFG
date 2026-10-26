class Solution {
    public int minDiff(int k, int[] arr) {
        // code here
        Map<Integer,Integer> map= new HashMap<>();
               PriorityQueue<Integer> minheap=new PriorityQueue<>();
               PriorityQueue<Integer> maxheap= new PriorityQueue<>(Collections.reverseOrder());
               for(int i=0;i<arr.length;i++){
                   map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                   minheap.add(arr[i]);
                   maxheap.add(arr[i]);
               }
               int min=Integer.MAX_VALUE;
               for(int i=0;i<k;i++){
                   map.put(arr[i],map.get(arr[i])-1);
               }
               while(map.get(minheap.peek())==0) minheap.poll();
               while(map.get(maxheap.peek())==0) maxheap.poll();
               min=Math.min(min,maxheap.peek()-minheap.peek());
               int i=k;
               while(i<arr.length){
                    map.put(arr[i],map.getOrDefault(arr[i],0)-1);
                    map.put(arr[i-k],map.get(arr[i-k])+1);
                    if(map.get(arr[i-k])==1){
                        minheap.add(arr[i-k]);
                        maxheap.add(arr[i-k]);
                    }
               while(map.get(minheap.peek())==0) minheap.poll();
               while(map.get(maxheap.peek())==0) maxheap.poll();
                min=Math.min(min,maxheap.peek()-minheap.peek());
                i++;




               }
               return min;
    }
}