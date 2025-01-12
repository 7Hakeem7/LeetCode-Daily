public class Solution {
  public boolean canBeValid(String s, String locked) {
    int n = s.length();
    if (n % 2 == 1) {
      return false;
    }
    // forward check ')'
    // number of unlocked and locked '('
    int remain = 0;
    for (int i = 0; i < n; i++) {
      // check locked ')'
      if (locked.charAt(i) == '1' && s.charAt(i) == ')') {
        // don't have nothing left to pair ')'
        if (remain == 0) {
          return false;
        } else {
          remain--;
        }
      } else {
        remain++;
      }
    }

    // backward check '('
    // number of unlocked and locked ')'
    remain = 0;
    for (int i = n - 1; i >= 0; i--) {
      // check locked '('
      if (locked.charAt(i) == '1' && s.charAt(i) == '(') {
        // don't have nothing left to pair '('
        if (remain == 0) {
          return false;
        } else {
          remain--;
        }
      } else {
        remain++;
      }
    }

    return true;
  }
}