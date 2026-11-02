class Solution {
    public int largestSumCycle(int[] edge) {
        // code here
        int n = edge.length;

              int[] vis = new int[n]; // 0: unvisited, 1: visiting, 2: fully visited

              int ans = -1;



              for (int i = 0; i < n; i++) {

                  if (vis[i] == 0) {

                      int cur = i;

                      // Follow the path until we hit a visited node or a dead end (-1)

                      while (cur != -1 && vis[cur] == 0) {

                          vis[cur] = 1; // Mark as visiting (part of the current path)

                          cur = edge[cur];

                      }



                      // If we hit a node currently in our active path, a cycle is detected

                      if (cur != -1 && vis[cur] == 1) {

                          int sum = 0;

                          int temp = cur;

                          // Calculate the sum of the cycle elements

                          do {

                              sum += temp;

                              temp = edge[temp];

                          } while (temp != cur);



                          ans = Math.max(ans, sum);

                      }



                      // Mark all nodes traversed in this iteration as fully processed

                      cur = i;

                      while (cur != -1 && vis[cur] == 1) {

                          vis[cur] = 2;

                          cur = edge[cur];

                      }

                  }

              }

              return ans;
    }
}