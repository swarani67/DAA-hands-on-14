import java.util.*;
class Graph {
    private int A;
    private LinkedList<Integer> nei[];
    Graph(int ver) {
        A = ver;
        nei = new LinkedList[ver];
        for (int k = 0; k < ver; k++)
            nei[k] = new LinkedList<>();
    }
    void addEdge(int ver, int wt) {
        nei[ver].add(wt);
    }
    void topologicalSortUtil(int ver, boolean vt[], Stack<Integer> stack) {
        vt[ver] = true;
        Integer k;
        Iterator<Integer> it = nei[ver].iterator();
        while (it.hasNext()) {
            k = it.next();
            if (!vt[k])
                topologicalSortUtil(k, vt, stack);
        }
        stack.push(new Integer(ver));
    }
    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean vt[] = new boolean[A];
        for (int k = 0; k < A; k++)
            vt[k] = false;
        for (int k = 0; k < A; k++)
            if (!vt[k])
                topologicalSortUtil(k, vt, stack);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of vertices:");
        int vertices = scanner.nextInt();
        System.out.print("No. of edges:");
        int edges = scanner.nextInt();
        Graph g = new Graph(vertices);
        System.out.println("Enter edges in source and destination of vertex:");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            g.addEdge(src, dest);
        }
        System.out.println("Topological Sort:");
        g.topologicalSort();
    }
}
