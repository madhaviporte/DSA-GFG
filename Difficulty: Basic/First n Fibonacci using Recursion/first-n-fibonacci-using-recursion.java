class Solution {
    public ArrayList<Integer> fibonacciNumbers(int n) {
        // code here
    ArrayList<Integer> ans = new ArrayList<>();

    int a = 0;
    int b = 1;

    for (int i = 0; i < n; i++) {
        ans.add(a);

        int c = a + b;
        a = b;
        b = c;
    }

    return ans;
    }
}
