import java.util.*;
class Graph {
    public int A;
    public LinkedList<Integer> nei[];
    Graph(int ver) {
        A = ver;
        nei = new LinkedList[ver];
        for (int k = 0; k < ver; k++)
            nei[k] = new LinkedList<>();
    }
    void Edge(int ver, int wt) {
        nei[ver].add(wt);
    }
    void DFS(int ver, boolean vt[]) {
        vt[ver] = true;
        System.out.print(ver + " ");
        Iterator<Integer> it = nei[ver].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!vt[n])
                DFS(n, vt);
        }
    }
    void DFS(int ver) {
        boolean vt[] = new boolean[A];
        DFS(ver, vt);
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of vertices:");
        int vertices = scanner.nextInt();
        System.out.print("NO. of edges:");
        int edges = scanner.nextInt();
        Graph g = new Graph(vertices);
        System.out.println("Enter edges of source and destination for vertices:");
        for (int k = 0; k < edges; k++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            g.Edge(src, dest);
        }
        System.out.println("DFS starts at: ");
        int startVertex = scanner.nextInt();
        System.out.println("DFS" + startVertex + ":");
        g.DFS(startVertex);
    }
}
