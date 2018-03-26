public class MaxContiguousSum {

    private static int[] maxSub(int[] T, int low, int high) {
        if (high == low) {
            return new int[]{low, high, T[low]};
        } else {
            int mid = (low + high) / 2;
            int[] left = maxSub(T, low, mid);
            int[] right = maxSub(T, mid + 1, high);
            int[] cross = maxCrossSub(T, low, mid, high);
            if (left[2] >= right[2] && left[2] >= cross[2]) {
                    return left;
                } else if (right[2] >= left[2] && right[2] >= cross[2]) {
                    return right;
                } else {
                    return cross;
            }
        }
    }

    private static int[] maxCrossSub(int[] T, int low, int mid, int high) {
        int maxLeft = -Integer.MAX_VALUE;
        int maxRight = -Integer.MAX_VALUE;
        int leftSum = 0;
        int rightSum = 0;
        int left_i = mid, right_j = mid;
        for (int i = mid; i >= low; i--) {
            leftSum += T[i];
            if (leftSum >= maxLeft) {
                maxLeft = leftSum;
                left_i = i;
            }
        }
        for (int j = mid + 1; j <= high; j++) {
            rightSum += T[j];
            if (rightSum >= maxRight) {
                maxRight = rightSum;
                right_j = j;
            }
        }
        return new int[]{left_i, right_j, maxLeft + maxRight};
    }

    public static void main(String[] args) {
        int[] T = {2, 18, -22, 20, 8, -6, 10, -24, 13, 3};
        int n = T.length;
        int[] result = maxSub(T, 0, n - 1);
        System.out.println("i=" + (result[0] + 1) + ", " + "j=" + (result[1] + 1) + ", and sum=" + result[2]);
    }
}