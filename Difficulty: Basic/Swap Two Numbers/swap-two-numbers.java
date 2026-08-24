class Solution {
    public void swap(int a, int b) {
        // code here
        int temp = 0;
        temp = a;
        a=b;
        b=temp;

        System.out.println(a + " " + b);
    }
}
