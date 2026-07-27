/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {

    int preIndex = 0;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        return build(pre, preMirror, 0, pre.length - 1);
    }

    private Node build(int[] pre, int[] preMirror, int l, int h) {

        if (preIndex >= pre.length || l > h)
            return null;

        Node root = new Node(pre[preIndex++]);

        // Leaf node
        if (l == h || preIndex >= pre.length)
            return root;

        // Find next preorder element in mirror preorder
        int i;
        for (i = l; i <= h; i++) {
            if (preMirror[i] == pre[preIndex])
                break;
        }

        // Build left and right subtrees
        if (i <= h) {
            root.left = build(pre, preMirror, i, h);
            root.right = build(pre, preMirror, l + 1, i - 1);
        }

        return root;
    }
}