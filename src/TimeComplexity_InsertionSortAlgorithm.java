public class TimeComplexity_InsertionSortAlgorithm {

    private static void insertionSort(int n, int[] S) {
        int x, j;
        for (int i = 2; i <= n; i++) {
            x = S[i];
            j = i - 1;
            while (S[j] > x) {
                S[j + 1] = S[j];
                j--;
            }
            S[j + 1] = x;
        }
    }

    public static void main(String[] args) {
        int[] S = {0, 6, 5, 4, 3, 2, 1};
        int n = S.length - 1;
        insertionSort(n, S);
        for (int i = 0; i <= n; i++) {
            System.out.println(S[i] + ", ");
        }
    }
}
