import java.io.IOException;

public class Uebung_1_2 {




        private int[] id;

    public Uebung_1_2(int X) {
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




    public static void main(String[] args){
        int numberOfCities =10;
        Uebung_1_2 uf = new Uebung_1_2(numberOfCities);
        int p[] = new int[10];
        int q[] = new int[10];


        In txt = new In("Flugverbindungen");
        String[] city = txt.readAllStrings();
        for (int i=0 ;i < city.length-1;i++){
            String city1 = city [i];
            String city2 = city [i + 1];
            if (uf.connected(i,i+1)) {
                StdOut.println(city1 + " und " + city2 + " sind verbunden");
            } else {
                StdOut.println(city1 + " und " + city2 + " werden jetzt verbunden");
                uf.union(i, i + 1);
        }

    }
}
}
