import java.util.Random;

public class Mergesort {
    public static void main(String[] args) {

        int [] Noten = {1, 2 , 3 , 4 , 5};
        Student Marc = new Student("Marc"," Marc@gmail.com", zufallsnoten(Noten), false);
        Student Annikey = new Student("LOL", "Annikey@gmail.com", zufallsnoten(Noten), false);
        Student YOLO = new Student("YOLO", "YOLO@gmail.com", zufallsnoten(Noten), false);
        Student Swag = new Student("Swag", "SWAG@gmail.com", zufallsnoten(Noten), false);
        Student Bingo = new Student("bingo", "Bingo@gmail.com", zufallsnoten(Noten), false);
        Student Bongo = new Student("Bongo", "Bongo@gmail.com", zufallsnoten(Noten), false);
        Student [] students = {Marc, Annikey, YOLO, Swag, Bingo, Bongo};

        int nummerStudent = students.length;
        int [] ZufallNote = new int[nummerStudent];
        String[] emailStudent = new String[nummerStudent];
        int i=0;

        for (Student student : students) {
            ZufallNote[i] = student.getNoteStudent();
            emailStudent[i] = student.getEmailStudent();
            i++;
        }

        for (int j = 0; j < ZufallNote.length; j++) {
            StdOut.println(students[j].getName() + " hat die Note " + ZufallNote[j]);
        }

        int[] hilfe = new int[ZufallNote.length];
        sort(ZufallNote, hilfe, 0, ZufallNote.length);


        StdOut.println("/// ist sortiert ///");

        for (int grade : ZufallNote) {
            for (Student student : students) {
                if (student.getNoteStudent() == grade && !student.getStatus()) {
                    StdOut.println(" Student " + student.getName() + " hat die Note "+ grade + " und die Mail "+ student.getEmailStudent());
                    student.setStatus(true);
                }
            }
        }

        String[] emails = emailMacher(10000);
       String[] emails2 = emailMacher(100000);

        Stopwatch zeitStopper = new Stopwatch();
        zeitStopper.start();
       insertionSortString(emails, 0, emails.length);
        long elapsedTime = zeitStopper.umrechner();
        StdOut.println("Zeit für InsertionSort bei 10000 Mails: " + elapsedTime + " MilliSekunden");

        String[] hilfe3 = new String[emails2.length];
        Stopwatch zeitStopp2 = new Stopwatch();
        zeitStopp2.start();
        sortString(emails2, hilfe3 ,0, emails2.length-1);
        for (String mail : emails2) {
            StdOut.println(mail);
        }
        long elapsedTime2 = zeitStopp2.umrechner();
        StdOut.println("Zeit für MergeSort " + elapsedTime2 + " MilliSekunden");




    }

    public static void merge(int[] a, int[] hilfe, int vorne, int mitte, int hinten){

        for (int k= vorne; k <= hinten; k++){
            hilfe[k] = a[k];
        }
        int i= vorne;
        int j= mitte +1;
        for (int k = vorne; k <= hinten; k++){
            if (i > mitte){
                a[k] = hilfe[j++];
            }

            else if (j > hinten) {
                a[k] = hilfe[i++];
            }

            else if (hilfe[j]>(hilfe[i])){

            }
            else {a[k] = hilfe[i++];}
        }
    }

    public static void sort(int[] a, int[] hilfe, int vorne, int hinten){
        if(hinten-vorne<= 7){
            insertionSort(a, vorne, hinten);
            return;
        }
        if (hinten <= vorne) return;
        int mitte = vorne + (hinten - vorne)/2;
        sort(a, hilfe, vorne, mitte);
        sort(a, hilfe, mitte+1, hinten);
        if (a[mitte]>=a[mitte+1]) return;
        merge(a, hilfe, vorne, mitte, hinten);
    }

    public static void mergeString(String[] a, String[] hilfe, int vorne, int mitte, int hinten) {
        for (int k = vorne; k <= hinten; k++) {
            hilfe[k] = a[k];
        }
        int i = vorne;
        int j = mitte + 1;
        for (int k = vorne; k <= hinten; k++) {
            if (i > mitte) {
                a[k] = hilfe[j++];
            } else if (j > hinten) {
                a[k] = hilfe[i++];
            } else if (hilfe[j].compareTo(hilfe[i]) > 0) { // Ändere die Bedingung für absteigende Sortierung
                a[k] = hilfe[j++];
            } else {
                a[k] = hilfe[i++];
            }
        }
    }

    public static void sortString(String[] a, String[] hilfe, int vorne, int hinten) {
        if (hinten - vorne <= 7) {
            insertionSortString(a, vorne, hinten);
            return;
        }
        if (hinten <= vorne) return;
        int mitte = vorne + (hinten - vorne) / 2;
        sortString(a, hilfe, vorne, mitte);
        sortString(a, hilfe, mitte + 1, hinten);
        if (mitte < hinten && a[mitte].compareTo(a[mitte + 1]) >= 0) return;
        mergeString(a, hilfe, vorne, mitte, hinten);
    }


    private static void insertionSort(int[] array, int vorne, int hinten) {
        for (int i = vorne+1; i < hinten; i++) {
            int temp = array[i];
            int j = i-1;

            while (j >= vorne && array[j] < temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
    private static void insertionSortString(String[] array, int vorne, int hinten) {
        for (int i = vorne + 1; i < hinten; i++) {
            String temp = array[i];
            int j = i - 1;


            while (j >= vorne && array[j].compareTo(temp) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }


    public static int zufallsnoten(int[] macher) {

        Random random = new Random();
        int indexFinal = random.nextInt(macher.length);
        return macher[indexFinal];
    }

    public static String[] emailMacher(int count) {
        String[] emails = new String[count];

        for (int i = 0; i < count; i++) {
            emails[i] = zufallsEmail();
        }

        return emails;
    }

    public static String zufallsEmail() {
        String nameEmail = "ALDA";
        String[] domains = {"htwg-konstanz.de"};

        Random random = new Random();


        StringBuilder prefixBuilder = new StringBuilder();
        long prefixLength = random.nextInt(10);
        for (long i = 0; i < prefixLength; i++) {
            char randomLetter = nameEmail.charAt(random.nextInt(nameEmail.length()));
            prefixBuilder.append(randomLetter);
        }

        String randomPrefix = prefixBuilder.toString();
        String randomDomain = domains[random.nextInt(domains.length)];

        return randomPrefix + "@" + randomDomain;
    }
    public static class Stopwatch {
        private long startTime;

        public void start() {
            startTime = System.nanoTime();
        }

        public long umrechner() {
            long zeitEnde = System.nanoTime();
            long zeitgemessen = zeitEnde - startTime;
            return zeitgemessen / 1_000_000;
        }
    }
}
