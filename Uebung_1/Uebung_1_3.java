import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Uebung_1_3 {
    private int[] id;

    public Uebung_1_3(int X) {
        id = new int[X];

        for (int i = 0; i < X; i++) {
            id[i] = i;

        }
    }

    public boolean connected(int p, int q) {

        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
    }


    public static void main(String[] args) throws IOException {
        int N = 1000;
        Uebung_1_3 uf = new Uebung_1_3(N);

        int counter = 0;
        int p[] = new int[500];
        int q[] = new int[500];

        Path filePath = Paths.get("Uebung_1/Test");
        Scanner Hallo2 = new Scanner(filePath, "UTF-8");
        while (Hallo2.hasNextInt()) {
            p [counter] =  Hallo2.nextInt();
            q [counter] =  Hallo2.nextInt();
            counter++;
        }
        Stopwatch stopHallo = new Stopwatch();
        for (int u = 0; u < p.length; u++) {
            uf.union(p[u], q[u]);

            for (int i = 0; i < p.length; i++) {
            if (uf.connected(p[i], q[i])) {
                System.out.println("schon verbunden: " + p[i] + " und " + q[i]);}
            else {
                uf.union(p[i], q[i]);
                System.out.println("jetzt verbunden: " + p[i] + " und " + q[i]);
            }}
        double elapsedTime = stopHallo.elapsedTime();
        System.out.println("Zeit für Union-Operationen: " + elapsedTime + " Sekunden");
        }}}




