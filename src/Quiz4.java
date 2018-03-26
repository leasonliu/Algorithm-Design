import java.util.ArrayList;

public class Quiz4 {
    private static void BinPacking(ArrayList<Double> items) {
        ArrayList<Double>[] binList = new ArrayList[items.size()];
        double[] usedSpace = new double[items.size()];
        binList[0] = new ArrayList<>();
        int i = 0;//item
        int j = 0;//bin
        while (i < items.size()) {
            double temp = items.get(i++);
            j = 0;
            int maxBinIndex = getMaxBinIndex(binList);
            while (temp <= 1 && j < maxBinIndex) {
                if (1 - usedSpace[j] >= temp) {
                    usedSpace[j] += temp;
                    binList[j].add(temp);
                    temp += 1; // set the item to be packed
                    j = -1;
                }
                j++;
            }
            if (temp <= 1) {
                ArrayList<Double> bin = startAndGetNewBin(binList);
                int index = bin.get(0).intValue();
                bin.remove(0);
                usedSpace[index] += temp;
                binList[index].add(temp);
                temp += 1;
            }
        }
        // output
        for (int k = 0; k < binList.length; k++) {
            if (binList[k] != null) {
                System.out.print("Bin#" + (k + 1) + "= [");
                for (int l = 0; l < binList[k].size(); l++) {
                    System.out.print(binList[k].get(l) + ", ");
                }
                System.out.println("]");
            } else {
                break;
            }
        }
    }

    private static int getMaxBinIndex(ArrayList<Double>[] binList) {
        for (int i = 0; i < binList.length; i++) {
            if (binList[i] == null) {
                return i;
            }
        }
        return 0;
    }

    private static ArrayList<Double> startAndGetNewBin(ArrayList<Double>[] binList) {
        for (int i = 0; i < binList.length; i++) {
            if (binList[i] == null) {
                binList[i] = new ArrayList<>();
                binList[i].add((double) i);
                return binList[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        double[] testCase = {0.85, 0.5, 0.4, 0.4, 0.3, 0.2, 0.2, 0.1};
        double[] testCase = {0.7, 0.7, 0.5, 0.4, 0.4, 0.3, 0.1, 0.1};
        ArrayList<Double> arrayList = new ArrayList<>();
        System.out.print("testcase: [");
        for (int i = 0; i < testCase.length; i++) {
            arrayList.add(testCase[i]);
            System.out.print(testCase[i] + ", ");
        }
        System.out.println("]");
        BinPacking(arrayList);
    }
}
