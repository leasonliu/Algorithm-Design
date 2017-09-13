public class Quiz {
//    static int[] array = {4, 18, 25, 55, 62, 74, 83, 90, 95};
//    static int[] array = {11,17,32,46,52,54,61,76,79,81,81,83,84,91,97,99};
    static int[] array = {-8,-5,-4,1,4,13,19,25,30,33,37,43,47,62,75,86};
    private static int find(int itemToSearch, int cursor1, int cursor2, int cursor3, int cursor4) {
//        if (cursor1 > cursor2 || cursor2 > cursor3 || cursor3 > cursor4) {
//            return -2;
//        }
        if (array[cursor1] == itemToSearch) {
            return cursor1;
        } else if (array[cursor2] == itemToSearch) {
            return cursor2;
        } else if (array[cursor3] == itemToSearch) {
            return cursor3;
        } else if (itemToSearch < array[cursor2]) {
            return find(itemToSearch, cursor1 + 1, cursor2 / 3, 2 * cursor2 / 3, cursor2);
        } else if (itemToSearch < array[cursor3]) {
            return find(itemToSearch, cursor2 + 1, cursor2 + (cursor3 - cursor2) / 3, cursor2 + 2 * (cursor3 - cursor2) / 3, cursor3);
        } else if (itemToSearch < array[cursor4 - 1]) {
            return find(itemToSearch, cursor3 + 1, cursor3 + (cursor4 - cursor3) / 3, cursor3 + 2 * (cursor4 - cursor3) / 3, cursor4);
        }
        return -1;
    }

    public static void main(String[] args) {
        int length = array.length;
        System.out.println(find(-4, 0, length / 3, 2 * length / 3,length));
    }
}
