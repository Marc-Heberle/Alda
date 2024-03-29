public class Uebung_1_1 {


    private int[] id;

    public Uebung_1_1(int X){
        id = new int[X];

        for (int i = 0; i < X; i++){
            id[i]=i;

        }
    }



                public static void main(String[] args) {
                     int max = 10; // Anzahl
                             Uebung_1 uf = new Uebung_1(max);
                                     int p[]= {1,2,6,5,4,2,7,6,4};
                                     int q[]= {5,8,5,4,1,0,2,1,8};

                                        for (int i = 0; i < p.length; i++){
                                    if (uf.connected(p[i], q[i])) {
                                    System.out.println("schon verbunden: " +p[i]+ " und " +q[i]);
                                }
                                        else{
                                    uf.union(p[i], q[i]);
                                    System.out.println("jetzt verbunden: "+p[i]+" und " +q[i]);
                                }
                            }



}
}

