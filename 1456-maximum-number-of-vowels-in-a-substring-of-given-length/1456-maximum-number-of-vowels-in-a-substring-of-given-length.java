class Solution {
    public int maxVowels(String s, int k) {

        int count = 0;
        int maxCount = 0;

        // Count vowels in first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        maxCount = count;

        // Sliding window
        for (int i = k; i < s.length(); i++) {

            // Add new character
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // Remove old character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || 
               c == 'o' || c == 'u';
    }
}