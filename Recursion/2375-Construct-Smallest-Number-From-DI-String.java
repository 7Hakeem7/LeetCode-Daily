class Solution {
    public String smallestNumber(String pattern) {
        boolean[] used = new boolean[10]; // Digits 1-9
        char[] temp = new char[pattern.length() + 1]; // Store result as char array
        return helper(0, used, temp, pattern) ? new String(temp) : "";
    }

    private boolean helper(int index, boolean[] used, char[] temp, String pattern) {
        if (index == temp.length) {
            return isValid(temp, pattern);
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                temp[index] = (char) (i + '0'); // Convert int to char
                if (helper(index + 1, used, temp, pattern)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private boolean isValid(char[] num, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I' && num[i] >= num[i + 1])
                return false;
            if (pattern.charAt(i) == 'D' && num[i] <= num[i + 1])
                return false;
        }
        return true;
    }
}