public class Notruf {


    public static void main(String[] args) {

        Notruf eq = new Notruf(10);
        eq.enqueue(9,"Marc");
        eq.enqueue(1,"Batz");
        eq.enqueue(5,"Lost");
        eq.enqueue(3,"ALDA");
        eq.enqueue(8,"Ewr");
        eq.enqueue(7,"Muster");
        eq.enqueue(40,"Asta");
        eq.enqueue(12,"Annika");

        eq.printQueue();

        System.out.println("aktueller Patient: "+eq.dequeue());

        eq.printQueue();

    }


    private int[] rang;
    public String[] name;
    private int N;

    public Notruf(int QueueSize) {
        rang = new int[QueueSize + 1];
        name = new String[QueueSize + 1];

    }

    public void enqueue(int Notfallstufe, String Patient) {
        rang[N + 1] = Notfallstufe;
        name[N + 1] = Patient;
        N++;
        oben(N);

    }

    public String dequeue() {
      String root = name[1];
         exchange(1, N);
        rang[N + 1] = 0;
        name[N + 1] = null;
        unter(1);
        N--; // wichtig weil N runterzählt
        return root;







    }

    public boolean isEmpty() {
        return rang[1] == Integer.parseInt(null);
    }

    private void oben(int x) {
        while ((x > 1 && rang[x / 2] < rang[x])) {
            exchange(x, x / 2);
            x = x / 2;
        }
    }

    private void unter(int x) {
        while (2 * x <= N) {
            int j = 2 * x;
            if (j < N && (rang[j] < rang[j + 1])) j++;
            if (rang[x] >= rang[j]) break;
            exchange(x, j);
            x = j;
        }
    }

    private void exchange(int i, int j) {
        int Aktuellerrang = rang[i];
        rang[i] = rang[j];
        rang[j] = Aktuellerrang;

        String AktuellerName = name[i];
        name[i] = name[j];
        name[j] = AktuellerName;
    }

    public void printQueue() {
        System.out.println("Aktueller Zustand der Warteschlange:");
        for (int i = 1; i < N + 1; i++) {
            System.out.println("Notfallstufe: " + rang[i] + ", patient: " + name[i]);
        }
    }
}
