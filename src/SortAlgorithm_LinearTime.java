public class SortAlgorithm_LinearTime {

    private static void sort(int n, int[] S) {
        int[] T = new int[n];
        for (int i = 0; i < n; i++) {
            T[S[i] - 1] = S[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(T[i] + ", ");
        }
    }

    public static void main(String[] args) {
        // S needs to be integers 1 through n, inclusive.
        int[] S = {6, 5, 9, 8, 1, 4, 3, 2, 7, 10};
        int n = S.length;
        sort(n, S);
    }
}
