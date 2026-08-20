/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    
        //  code here
        public int[] solve(Node root){
            if(root == null){
                                // Maximum Val       Minimum Val       Max Diff
                return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE};
            }

            int[] left = solve(root.left);
            int[] right = solve(root.right);

            int rootVal = root.data;

            int maxDiff = Math.max(left[2] , right[2]);

            if(left[0] != Integer.MIN_VALUE && left[1] != Integer.MAX_VALUE){
                maxDiff = Math.max(maxDiff , Math.max((rootVal - left[0]) , (rootVal - left[1])));
            }
            if(right[0] != Integer.MIN_VALUE && right[1] != Integer.MAX_VALUE){
                maxDiff = Math.max(maxDiff , Math.max((rootVal - right[0]) , (rootVal - right[1])));
            }

            int maxVal = Math.max(rootVal , Math.max(left[0] , right[0]));//max value from entire subtree including the current node
            int minVal = Math.min(rootVal , Math.min(left[1] , right[1]));//min value from entire subtree including the current node

            return new int[]{maxVal , minVal , maxDiff};
        }
        int maxDiff(Node root) {
            //  code here
            int[] result = solve(root);
            return result[2];
        
    }
}