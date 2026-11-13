/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};
*/

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
                Stack<Node> s1 = new Stack<>();
                Stack<Node> s2 = new Stack<>();
                addAll(r1,s1);
                addAll(r2,s2);
                while(true) {
                    if(s1.isEmpty() || s2.isEmpty()) break;
                    if(s1.peek().data == s2.peek().data) {
                        ans.add(s1.peek().data);
                        Node s1r = s1.peek().right;
                        Node s2r = s2.peek().right;
                        s1.pop();
                        s2.pop();
                        if(s1r!=null) addAll(s1r,s1);
                        if(s2r != null) addAll(s2r,s2);
                    } else if(s1.peek().data < s2.peek().data) {
                        Node s1r = s1.peek().right;
                        s1.pop();
                        if(s1r!=null) addAll(s1r,s1);
                    } else {
                        Node s2r = s2.peek().right;
                        s2.pop();
                        if(s2r!=null) addAll(s2r,s2);
                    }
                }
                return ans;
            }
            private void addAll(Node node, Stack<Node> stack) {
                while(node != null) {
                    stack.add(node);
                    node = node.left;
                }
    }
}