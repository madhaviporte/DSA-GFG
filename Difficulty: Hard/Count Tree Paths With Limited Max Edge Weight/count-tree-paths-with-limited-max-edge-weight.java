class Solution {
    static int[] parent, sz;

        static int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        // code here
   parent = new int[n + 1];
           sz = new int[n + 1];
           for (int i = 1; i <= n; i++) {
               parent[i] = i;
               sz[i] = 1;
           }

           // edges ko weight ke hisaab se sort karo
           Arrays.sort(edges, (a, b) -> a[2] - b[2]);

           // queries ke indices ko query value ke hisaab se sort karo
           int q = queries.length;
           Integer[] idx = new Integer[q];
           for (int i = 0; i < q; i++) idx[i] = i;
           Arrays.sort(idx, (a, b) -> queries[a] - queries[b]);

           int[] ans = new int[q];
           long total = 0;
           int ptr = 0;

           for (int i = 0; i < q; i++) {
               int x = queries[idx[i]];

               while (ptr < edges.length && edges[ptr][2] <= x) {
                   int pa = find(edges[ptr][0]);
                   int pb = find(edges[ptr][1]);

                   if (pa != pb) {
                       total += (long) sz[pa] * sz[pb];
                       if (sz[pa] < sz[pb]) {
                           int t = pa; pa = pb; pb = t;
                       }
                       parent[pb] = pa;
                       sz[pa] += sz[pb];
                   }
                   ptr++;
               }
               ans[idx[i]] = (int) total;
           }

           ArrayList<Integer> res = new ArrayList<>();
           for (int v : ans) res.add(v);
           return res;
       }
};