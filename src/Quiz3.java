import java.util.Iterator;
import java.util.LinkedList;

public class Quiz3 {
    private final static int N = 8;
    private static LinkedList<Node>[] adjList = new LinkedList[N];
    private final static int MAX_INTEGER = Integer.MAX_VALUE;

    private static class Node {
        int[] info = new int[2]; // 0 node index, 1 weight

        public Node(int a, int b) {
            this.info[0] = a;
            this.info[1] = b;
        }
    }

    private static void findShortestPath_BFS(int origin) {
        int[] s = new int[N];
        int min;
        s[origin] = 1;
        for (int i = 1; i < N; i++) {
            min = MAX_INTEGER;
            int v = 0;
            for (int j = 0; j < N; j++) {
                int tempOJ = getNode(origin, j).info[1];
                if (s[j] != 1 && tempOJ < min) {
                    min = tempOJ;
                    v = j;
                }
            }
            s[v] = 1;
            for (int j = 0; j < N; j++) {
                int tempVJ = getNode(v, j).info[1];
                Node tempOJ = getNode(origin, j);
                if (s[j] != 1 && tempVJ != MAX_INTEGER && min + tempVJ < tempOJ.info[1]) {
                    if (tempOJ.info[1] != MAX_INTEGER) {
                        tempOJ.info[1] = min + tempVJ;
                    } else {
                        adjList[origin].add(new Node(j, min + tempVJ));
                    }
                }
            }
        }
        // output
        for (int i = 0; i < N; i++) {
            if (origin != i) {
                System.out.println((origin + 1) + " --> " + (i + 1) + " : " + getNode(origin, i).info[1]);
            }
        }
    }

    private static Node getNode(int a, int b) {
        Iterator<Node> iterator = adjList[a].iterator();
        Node node;
        while (iterator.hasNext()) {
            node = iterator.next();
            int v = node.info[0];
            if (v == b) {
                return node;
            }
        }
        return new Node(b, MAX_INTEGER);
    }

    private static void createGraph_LinkedList(int[][] adjMatrix) {
        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(adjMatrix[i][j]+",");
            }
            System.out.println();
        }*/
        Node node;
        for (int i = 0; i < N; i++) {
            adjList[i] = new LinkedList<>();
            node = new Node(i, 0);
            adjList[i].add(node);
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                } else if (adjMatrix[i][j] != 0) {
                    node = new Node(j, 1);
                    adjList[i].add(node);
                }
            }
        }
        /*for (int i = 0; i < N; i++) {
            Iterator<Node> iterator = adjList[i].iterator();
            for (int j = 0; iterator.hasNext(); j++) {
                int[] t = iterator.next().info;
                System.out.print(t[0] + "(" + t[1] + ") -> ");
            }
            System.out.println();
        }*/
    }

    public static void main(String[] args) {
        int[][] testCase = {{0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 0, 0, 1, 0, 0, 1, 1}, {0, 1, 1, 0, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}};
        createGraph_LinkedList(testCase);
        findShortestPath_BFS(3);
        findShortestPath_BFS(7);
    }
}
