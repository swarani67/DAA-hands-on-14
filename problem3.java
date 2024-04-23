import java.util.*;
class Edge implements Comparable<Edge> {
    int s, d, wt;
    Edge(int s, int d, int wt) {
        this.s = s;
        this.d = d;
        this.wt = wt;
    }
    public int compareTo(Edge compareEdge) {
        return this.wt - compareEdge.wt;
    }
}
class Graph {
    private int A, E;
    private Edge edge[];
    Graph(int ver, int e) {
        A = ver;
        E = e;
        edge = new Edge[E];
        for (int k = 0; k < e; k++)
            edge[k] = new Edge(0, 0, 0);
    }
    int find(int pt[], int k) {
        if (pt[k] == -1)
            return k;
        return find(pt, pt[k]);
    }
    void union(int pt[], int a, int b) {
        int aset = find(pt, a);
        int bset = find(pt, b);
        pt[aset] = bset;
    }
    void KruskalMST() {
        Edge result[] = new Edge[A];
        int e = 0;
        int k = 0;
        for (k = 0; k < A; k++)
            result[k] = new Edge(0, 0, 0);
        Arrays.sort(edge);
        int pt[] = new int[A];
        for (k = 0; k < A; k++)
            pt[k] = -1;
        k = 0;
        while (e < A - 1) {
            Edge next_edge = edge[k++];
            int a = find(pt, next_edge.s);
            int b = find(pt, next_edge.d);
            if (a != b) {
                result[e++] = next_edge;
                union(pt, a, b);
            }
        }
        System.out.println("Edges of constructed MST");
        for (k = 0; k < e; k++)
            System.out.println(result[k].s + " --> " + result[k].d + " = " + result[k].wt);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of vertices:");
        int A = scanner.nextInt();
        System.out.print(" No. of edges:");
        int E = scanner.nextInt();
        Graph graph = new Graph(A, E);
        System.out.println("Enter source destination and weight:");
        for (int k = 0; k < E; k++) {
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int wt = scanner.nextInt();
            graph.edge[k] = new Edge(s, d, wt);
        }
        graph.KruskalMST();
    }
}
