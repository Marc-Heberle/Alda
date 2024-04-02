public class Uebung_1 {


    private int[] id;

    public Uebung_1(int X) {
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


    public static void main(String[] args) {
        int max = 10; // Anzahl
        Uebung_1 uf = new Uebung_1(max);

        var txt = new In("daten");
        while (txt.hasNextLine()) {

            String textLine = txt.readLine().trim();
            if (textLine.isEmpty()) {
                continue;

            }
            String[] textArray = textLine.split(";");
            for (String s : textArray) {
                StdOut.println(s);


                String[] alpha = s.split(",");
                int p = Integer.parseInt(alpha[0].replaceAll("\\(", ""));
                int q = Integer.parseInt(alpha[1].replaceAll("\\)", ""));


                if (!uf.connected(p, q)) {
                    System.out.println("schon verbunden: " +p+ " und " +q);


                } else {
                    uf.union(p, q);
                    System.out.println("jetzt verbunden: "+p+" und " +q);


            }


        }


    } }}



















