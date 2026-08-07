import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            }

            else if (c == '[') {
                countStack.push(count);
                stringStack.push(current);

                count = 0;
                current = new StringBuilder();
            }

            else if (c == ']') {

                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            }

            else {
                current.append(c);
            }
        }

        return current.toString();
    }
}