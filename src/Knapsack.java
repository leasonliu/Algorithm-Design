public class Knapsack {
    private final static int W = 9;
    private static int[][] objects = {{1, 20, 2, 10}, {2, 30, 5, 6}, {3, 35, 7, 5}, {4, 12, 3, 4}, {5, 3, 1, 3}};
    private static boolean[] include = new boolean[5];

    private static void knapsack(int i, int profit, int weight) {
        int maxprofit = -1;
        int numbest = 0;
        boolean[] bestset;
        if (weight <= W && profit > maxprofit) {
            maxprofit = profit;
            numbest = i;
            bestset = include;
        }
        if (promising(i)) {

        }
    }

    private static boolean promising(int i) {

        return false;
    }

    public static void main(String[] args) {
        knapsack(0, 0, 0);
    }
}
