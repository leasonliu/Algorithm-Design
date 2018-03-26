public class Quiz2 {

    private static int countMinWidth(int[] books, int L, int k) {
        int n = books.length;
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (books[i] > L) {
                return 0;
            }
        }
        sort(books, n);
        int[] bookShelves = new int[k];
        int[] currentWidth = new int[k];
        for (int i = 0; i < k; i++) {
            bookShelves[i] = books[i];
            currentWidth[i] = bookShelves[i];
        }
        int avgWidth = countAvgWidthPerShelf(books, k);
        System.out.println("avg: "+avgWidth);
        int[] diff = new int[k];
        for (int i = 0; i < k; i++) {
            diff[i] = avgWidth - books[i];
        }
        for (int i = k; i < n; i++) {
            int[] indices = findMinPair(diff, books, currentWidth);
            System.out.println("min: "+books[indices[1]] + ", in shelf: " + indices[0]);
            currentWidth[indices[0]] += books[indices[1]];
            diff[indices[0]] -= books[indices[1]];
            books[indices[1]] = Integer.MAX_VALUE;
        }
//        for (int i = 0; i < currentWidth.length; i++) {
//            System.out.println("Width of EveryShelf: " + currentWidth[i]);
//        }
        return findMaxWidth(currentWidth);
    }

    private static int[] findMinPair(int[] diff, int[] books, int[] currentWidth) {
        int d = Integer.MAX_VALUE;
        int indexD = -1;
        int indexB = -1;
        for (int i = currentWidth.length; i < books.length; i++) {
            for (int j = 0; j < currentWidth.length; j++) {
                if (Math.abs(diff[j] - books[i]) < d) {
                    d = Math.abs(diff[j] - books[i]);
                    indexB = i;
                    indexD = j;
                }
            }
        }
        return new int[]{indexD, indexB};
    }

    private static int findMaxWidth(int[] currentWidth) {
        int n = currentWidth.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (currentWidth[i] > max) {
                max = currentWidth[i];
            }
        }
        return max;
    }

    private static int countAvgWidthPerShelf(int[] books, int k) {
        float sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum += books[i];
        }
        return Math.round(sum / k);
    }

    private static void sort(int[] books, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (books[i] < books[j]) {
                    books[i] = books[i] ^ books[j];
                    books[j] = books[j] ^ books[i];
                    books[i] = books[i] ^ books[j];
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] books = {1, 2, 3, 2, 1, 2};
//        System.out.println("minWidth: " + countMinWidth(books, 5, 4));
//        int[] books = {8, 7, 6, 4, 2, 1, 1, 1};
//        System.out.println("minWidth: " + countMinWidth(books, 20, 3));
        int[] books = {80, 70, 65, 30, 20, 18, 17};
        System.out.println("minWidth: " + countMinWidth(books, 200, 2));
//        int[] books = {90,70,40,40,20};
//        System.out.println("minWidth: " + countMinWidth(books, 200, 3));
    }
}
