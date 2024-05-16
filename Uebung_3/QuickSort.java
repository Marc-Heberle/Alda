public class QuickSort {

    public static void main(String[] args) {


           String[] array = {"H", "a", "p", "pi", "n", "e", "s", "s"};



        sortieren(array, 0, array.length - 1);
        StdOut.println("Fertig: ");
        ausgabe(array);

   Stopwatch zeitStopper = new Stopwatch();
        zeitStopper.start();
        sortieren( array,0,-1 );
        long abgelaufeneZeit = zeitStopper.umrechner();
        StdOut.println("Zeit:" + abgelaufeneZeit + " nanoSekunden");


    }



    private static void sortieren(String[] a, int vorne, int hinten){
        if (hinten<= vorne) return;
        int j= teilen(a, vorne, hinten);
        ausgabe(a);
        sortieren(a, vorne, j-1);
        sortieren(a, j+1, hinten);
    }

    private static int teilen(String[] a, int vorne, int hinten){
        int i = vorne;
        int j= hinten +1;
        while(true){
            while(a[++i].compareTo(a[vorne])<0){
                if(i==hinten) 
                    break;
            }
            while(a[--j].compareTo(a[vorne])>0){
                if(j==vorne) break;
            }
            if (i>=j) break;
            Tausch(a, i, j);
        }
        Tausch(a, vorne, j);
        return j;
    }


    private static void Tausch(String[]a, int i, int j){
        String temp= a[i];
        a[i]=a[j];
        a[j]=temp;
        System.out.println(" Tausche "+a[i] + " mit " +a[j]);


    }

    private static void ausgabe(String[] a){
        System.out.print("Array: ");
        for (String s : a){
            System.out.print(s+" ");

        }
        System.out.println();
    }
    public static class Stopwatch {
        private long startTime;

        public void start() {
            startTime = System.nanoTime();
        }

        public long umrechner() {
            long zeitEnde = System.nanoTime();
            long Gemessen = zeitEnde-startTime ;
            return Gemessen;
        }
    }


}