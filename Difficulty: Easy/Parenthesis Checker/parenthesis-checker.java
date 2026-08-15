class Solution {
    public boolean isBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> smap = new HashMap<>();

        smap.put(')', '(');
        smap.put('}', '{');
        smap.put(']', '[');

        for (char c : s.toCharArray()) {

            if (smap.containsValue(c)) {
                stack.push(c);
            } 
            else if (smap.containsKey(c)) {

                if (stack.isEmpty() || smap.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
