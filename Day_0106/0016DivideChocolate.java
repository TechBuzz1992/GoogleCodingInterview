package Day_0106;

import java.util.Arrays;

class DivideChocolate {
  public static int maximizeSweetNess(int[] sweetness, int K) {
    int low = Arrays.stream(sweetness).min().getAsInt();
    int high = Arrays.stream(sweetness).sum();
    int best = 0;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int[] portions = helper(sweetness, mid);
      if (portions[0] < K + 1) {
        high = mid - 1;
      } else {
        best = Math.max(best, portions[1]);
        low = mid + 1;
      }
    }
    return best;
  }

  private static int[] helper(int[] sweetness, int target) {
    int portionSweetness = 0;
    int portions = 0;
    int minSweetness = Integer.MAX_VALUE;
    for (int i = 0; i < sweetness.length; i++) {
        portionSweetness += sweetness[i];
        if(portionSweetness >= target){
            minSweetness = Math.min(minSweetness, portionSweetness);
            portionSweetness = 0;
            portions++;
        }
    }
    return new int[]{portions, portionSweetness};
  }
}
