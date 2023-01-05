package Day_0105;

class ShipInKDays {
  public static int shipWithinDays(int[] weights, int K) {
    int sum = 0;
    int maxWeight = Integer.MIN_VALUE;
    for (int weight : weights) {
      sum += weight;
      maxWeight = Math.max(maxWeight, weight);
    }
    int left = maxWeight;
    int right = sum;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (isFeasible(weights, mid, K)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private static boolean isFeasible(int[] weights, int capacity, int K) {
    int days = 1;
    int currSum = 0;
    for (int weight : weights) {
      if (currSum + weight > capacity) {
        days++;
        currSum = 0;
      }
      currSum += weight;
    }
    return days <= K;
  }
}
