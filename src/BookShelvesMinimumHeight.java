import java.util.Random;

public class BookShelvesMinimumHeight {

    private static int countHeight(int[][] books, int shelfWidth) {
        int n = books.length;
        int currentWidth = 0;
        int totalHeight = 0;
        int currentHeight = 0;
        int rows = 1;
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

    private static int countMinimumHeight(int[][] books, int shelfWidth) {
        int n = books.length;
        int currentWidth = 0;
        int totalHeight = 0;
        int currentHeight = 0;
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
            } else {
                currentWidth += books[i][0];
                currentHeight = Math.max(currentHeight, books[i][1]);
            }
            if (books[i][1] >= currentHeight) {
                int tempWidth = 0;
                int tempHeight = 0;
                int tempTotalHeight = 0;
                // split
                for (int j = 0; j < i; j++) {
                    for (int k = 1; k < i; k++) {
                        if (books[j][0] + tempWidth > shelfWidth) {
                            tempTotalHeight += tempHeight;
                            tempHeight = books[j][1];
                            tempWidth = books[j][0];
                        } else if (k == j) {
                            tempHeight = books[j][1];
                            tempWidth = books[j][0];
                            tempTotalHeight += tempHeight;
                            System.out.println("cut at::  " + j + "///" + books[j][0] + ", " + books[j][1]);
                        } else {
                            tempWidth += books[j][0];
                            tempHeight = Math.max(tempHeight, books[j][1]);
                        }
                    }
                }
                System.out.println("..." + totalHeight);
                totalHeight = Math.min(tempTotalHeight + tempHeight, totalHeight);
                System.out.println("..." + totalHeight);
                if (totalHeight == tempTotalHeight + tempHeight) {
                    currentHeight = tempHeight;
                    currentWidth = tempWidth;
                }
            }
        }
        return currentHeight + totalHeight;
    }


    public static void main(String[] args) {
        Random random = new Random();
        /*int[][] books = new int[10][2];
        for (int i = 0; i < books.length; i++) {
            books[i][0] = random.nextInt(5) + 2; //width
            books[i][1] = random.nextInt(6) + 10; //height
            System.out.print("{" + books[i][0] + ", " + books[i][1] + "},");
        }*/
        int[][] books = {{1, 1}, {1, 2}, {1, 2}};
//        System.out.println("Height: " + countHeight(books, 7));
        System.out.println("Height: " + countMinimumHeight(books, 2));
    }
}