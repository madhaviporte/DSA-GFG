class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
         Arrays.sort(dep);
        Arrays.sort(arr);
        
        int max=0;
        
        for(int i=0;i<arr.length;i++)
        {
            int arrTime=arr[i];
            int l=0,u=dep.length-1;
            int last=-1;
            
            while(l<=u)
            {
                int mid=(l+u)/2;
                
                if(arrTime>dep[mid])
                {
                    last=mid;
                    l=mid+1;
                }
                else
                {
                    u=mid-1;
                }
            }
            int departuresSoFar=last+1;
            int arrivalsSoFar=(i+1)-departuresSoFar;
            
            max=Math.max(max,arrivalsSoFar);
        }
        return max;
    }
}
