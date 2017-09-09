public class MutiplicationMethods {

    private static void Ala_Carte(int multiplier_A, int multiplier_B) {
        int length = (int) (Math.log(981) / Math.log(2));
        int[] indices = new int[length];
        int smaller_integer;
        int larger_integer;
        int result = 0;
        if (multiplier_A < multiplier_B) {
            smaller_integer = multiplier_A;
            larger_integer = multiplier_B;
        } else {
            larger_integer = multiplier_A;
            smaller_integer = multiplier_B;
        }
        for (int i = 0, j = 0; smaller_integer >= 1; i++) {
            if (smaller_integer % 2 != 0) {
                indices[j++] = larger_integer;
            }
            smaller_integer /= 2;
            larger_integer *= 2;
        }
        for (int i = 0; i < length; i++) {
            result += indices[i];
        }
        System.out.println(result);
    }

    private static void Rectangular(int multiplier_A, int multiplier_B) {
        char[] digits_A = (multiplier_A + "").toCharArray();
        char[] digits_B = (multiplier_B + "").toCharArray();
        int[] result = new int[digits_A.length + digits_B.length];
        int[][] storage = new int[digits_B.length][digits_A.length];
        for (int i = 0; i < digits_B.length; i++) {
            for (int j = 0; j < digits_A.length; j++) {
                storage[i][j] = (digits_A[j] - '0') * (digits_B[i] - '0');
            }
        }
        int i, j = 0;
        boolean ifUnits = false;
        for (int k = 0; k < result.length; k++) {
            i = Math.min(k, digits_B.length - 1);
            j = k < digits_B.length ? 0 : k - digits_B.length;
            ifUnits = false;
            if (k >= digits_B.length) {
                ifUnits = true;
            }
            if (k == 0) {
                result[k] = getDigits(storage[0][0])[1];    // getDidits [1]十位,[0]个位
                continue;
            } else if (k == result.length - 1) {
                result[k] = getDigits(storage[i][j])[0];    // getDidits [1]十位,[0]个位
                break;
            }
            for (; i >= 0; i--) {
                for (; j < digits_A.length; j++) {
                    if (ifUnits) {
                        result[k] += getDigits(storage[i][j])[0];
                        ifUnits = false;
                    } else {
                        result[k] += getDigits(storage[i][j])[1];
                        ifUnits = true;
                        break;
                    }
                }
            }
        }
        for (i = result.length - 1; i >= 0; i--) {
            if (result[i] >= 10) {
                result[i - 1] += result[i] / 10;
                result[i] = getDigits(result[i])[0];
            }
        }
        for (int k = 0; k < result.length; k++) {
            System.out.print(result[k]);
        }
    }

    private static int[] getDigits(int num) {
        if (num < 10) {
            return new int[]{num, 0};
        }
        int units_digit = num % 10;
        int tens_digit = num / 10 % 10;
        return new int[]{units_digit, tens_digit};
    }

    public static void main(String[] args) {
        Ala_Carte(981, 1234);
        Rectangular(999, 458);
    }
}
