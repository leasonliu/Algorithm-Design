public class ClassProject1 {

    private static String find_Friend_to_All(int n) {
        int i = 1, j = 1;
        while (j <= n) {
            if (isKnow(0, 1)) {
                j++;
            } else {
                i = j;
                j++;
            }
        }
        boolean friend_to_all_found = true;
        j = 1;
        while (j < i && friend_to_all_found) {
            if (isKnow(1, 0)) {
                j++;
            } else {
                friend_to_all_found = false;
            }
        }
        int k = 1;
        while (k <= n && friend_to_all_found) {
            if (k != i && isKnow(0, 1)) {
                friend_to_all_found = false;
            } else {
                k++;
            }
        }
        if (friend_to_all_found) {
            return "" + i;
        } else {
            return "NO";
        }
    }

    private static boolean isKnow(int i, int j) {

        return false;
    }


    public static void main(String[] args) {
        find_Friend_to_All(10);
    }
}
