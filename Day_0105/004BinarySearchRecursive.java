package Day_0105;

import java.util.Arrays;

class BinarySearchRecursive {
  public static boolean binarySearch(int[] array, int target) {
    Arrays.sort(array);
    return helper(array, target, 0, array.length - 1);
  }

  private static boolean helper(int[] array, int target, int left, int right) {
    if (left > right) {
      return false;
    }
    int mid = left + (right - left) / 2;
    if (array[mid] == target) {
        return true;
    } else if (array[mid] > target) {
      return helper(array, target, left, mid - 1);
    } else {
      return helper(array, target, mid + 1, right);
    }
  }
}
