class Solution {
    public boolean findPattern(String s) {
        // code here
        int balance = 0;
                boolean seenY = false;

                for (int i = 0; i < s.length(); i++) {

                    if (s.charAt(i) == 'x') {
                        if (seenY) {
                            if (balance != 0) {
                                return false;
                            }
                            seenY = false;
                        }
                        balance++;
                    } 
                    else {
                        seenY = true;
                        balance--;

                        if (balance < 0) {
                            return false;
                        }
                    }
                }

                return balance == 0;
    }
}
