/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int absDiff(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();

                inorder(root, list);

                int min = Integer.MAX_VALUE;

                for (int i = 1; i < list.size(); i++) {
                    min = Math.min(min, list.get(i) - list.get(i - 1));
                }

                return min;
            }

            void inorder(Node root, ArrayList<Integer> list) {
                if (root == null)
                    return;

                inorder(root.left, list);
                list.add(root.data);
                inorder(root.right, list);
    }
}
