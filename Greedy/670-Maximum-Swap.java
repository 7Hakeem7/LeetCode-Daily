class Solution {
    public int maximumSwap(int num) {
        if(num < 10) return num;  // Return if the number is a single digit

        // Convert the number to a character array
        char[] digits = String.valueOf(num).toCharArray();
        int maxSoFar = -1; // The value of the largest digit
        int left = -1, right = -1; // Indices for swapping

        // Iterate over the digits
        for (int i = 0; i < digits.length; i++) {
            // Find the largest digit on the right side of the current digit
            for (int j = digits.length - 1; j > i; j--) {
                // Compare characters directly without converting to strings
                if (digits[j] > digits[i]) {
                    // Update maxSoFar and the indices to swap
                    if (digits[j] > maxSoFar) {
                        maxSoFar = digits[j];
                        left = i;
                        right = j;
                    }
                }
            }
        }

        // If a swap is found, perform the swap
        if (left != -1 && right != -1) {
            char temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;
        }

        // Convert the character array back to an integer
        return Integer.parseInt(new String(digits));
    }
}
