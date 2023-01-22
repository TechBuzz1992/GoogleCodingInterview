package Day_0114;

import java.util.Arrays;

class DecodeWays {
  public int decodeWays(String digits) {
    int[] memo = new int[digits.length()];
    Arrays.fill(memo, -1);
    return dfs(0, digits, memo);
  }

  private int dfs(int startIndex, String digits, int[] memo) {
    if (startIndex == digits.length()) return 1;
    if (memo[startIndex] != -1) return memo[startIndex];
    int ways = 0;
    if (digits.charAt(startIndex) == '0') {
      return ways;
    }
    ways += dfs(startIndex + 1, digits, memo);

    if (startIndex + 2 <= digits.length()
        && Integer.parseInt(digits.substring(startIndex, startIndex + 2)) <= 26) {
      ways += dfs(startIndex + 2, digits, memo);
    }
    memo[startIndex] = ways;
    return ways;
  }
}
