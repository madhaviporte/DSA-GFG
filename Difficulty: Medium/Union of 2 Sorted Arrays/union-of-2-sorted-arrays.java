class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
          ArrayList<Integer> ans = new ArrayList<>();
        int n = a.length;
        int m = b.length;
        int i=0;
        int j=0;
        
        while(i<n && j<m){
            
            if(a[i]<b[j]){
                if(ans.isEmpty() || ans.get(ans.size() -1)!= a[i])
                ans.add(a[i]);
                i++;
            }
            else if(a[i]>b[j]){
                if(ans.isEmpty() || ans.get(ans.size()-1)!=b[j])
                ans.add(b[j]);
                j++;
            }
            else{
                if(ans.isEmpty() || ans.get(ans.size()-1)!=a[i])
                ans.add(a[i]);
                i++;
                j++;
            }
        }
        while (i < a.length) {
                    if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i])
                        ans.add(a[i]);
                    i++;
                }

                while (j < b.length) {
                    if (ans.isEmpty() || ans.get(ans.size() - 1) != b[j])
                        ans.add(b[j]);
                    j++;
                }

                return ans;
    }
}
