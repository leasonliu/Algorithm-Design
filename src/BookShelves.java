import java.util.Random;

public class BookShelves {

    private static int countHeight(int[][] books, int shelfWidth) {
        int n = books.length;
        int currentWidth = 0;
        int totalHeight = 0;
        int currentHeight = 0;
        int rows = 1;
        for (int i = 0; i < n; i++) {
            if (books[i][0] > shelfWidth) {
                return 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (books[i][0] + currentWidth > shelfWidth) {
                totalHeight += currentHeight;
                currentHeight = books[i][1];
                currentWidth = books[i][0];
                rows++;
            } else {
                currentWidth += books[i][0];
                currentHeight = Math.max(currentHeight, books[i][1]);
            }
        }
        System.out.println("Rows = " + rows);
        return totalHeight + currentHeight;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[][] books = new int[10][2];
        for (int i = 0; i < books.length; i++) {
            books[i][0] = random.nextInt(5) + 2; //width
            books[i][1] = random.nextInt(6) + 10; //height
            System.out.print("{" + books[i][0] + ", " + books[i][1] + "},");
        }
        System.out.println("Height: " + countHeight(books, 7));
    }
}