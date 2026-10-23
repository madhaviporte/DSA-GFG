/* BST Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int pairsViolatingBST(Node root) {
        // code here
        java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();
               inorder(root, arr);

               int n = arr.size();
               int[] a = new int[n];
               int[] temp = new int[n];

               for (int i = 0; i < n; i++) {
                   a[i] = arr.get(i);
               }

               return (int) mergeSort(a, temp, 0, n - 1);
           }

           void inorder(Node root, java.util.ArrayList<Integer> arr) {
               if (root == null) return;
               inorder(root.left, arr);
               arr.add(root.data);
               inorder(root.right, arr);
           }

           long mergeSort(int[] a, int[] temp, int left, int right) {
               if (left >= right) return 0;

               int mid = left + (right - left) / 2;

               long count = mergeSort(a, temp, left, mid);
               count += mergeSort(a, temp, mid + 1, right);
               count += merge(a, temp, left, mid, right);

               return count;
           }

           long merge(int[] a, int[] temp, int left, int mid, int right) {
               int i = left, j = mid + 1, k = left;
               long count = 0;

               while (i <= mid && j <= right) {
                   if (a[i] <= a[j]) {
                       temp[k++] = a[i++];
                   } else {
                       count += mid - i + 1L;
                       temp[k++] = a[j++];
                   }
               }

               while (i <= mid) temp[k++] = a[i++];
               while (j <= right) temp[k++] = a[j++];

               for (i = left; i <= right; i++) {
                   a[i] = temp[i];
               }

               return count;
    }
}