import java.util.Scanner;
public class InsertionSortNotenMails {

    public static int zufallsnoten(int[] possibleCalifications) {

        double randomIndex = (int) (Math.random() * possibleCalifications.length);
        int indexFinal = (int) randomIndex;
        return possibleCalifications [indexFinal];
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;

            while (j >= 0 && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
    public static void sort(String[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if(a[j-1].compareTo(a[j])>0)
                    exchange(a, j-1,j);
                else break;
            }
        }
    }

    public static void exchange(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a [j];
        a[j] = t;
    }
    public static void main(String[] args) {

        int [] notenHTWG = {1, 2 , 3 , 4 , 5};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welche Note sollte ich haben?");
        int meineNote = scanner.nextInt();
        Student annika = new Student("Annika","anban@gmail.com", meineNote, false);
        Student marc = new Student("Marc", "marc@gmail.com", zufallsnoten(notenHTWG), false);

        Student [] students = {annika, marc};

        int numStudents = students.length;
        int [] randomGradeStudent = new int[numStudents];
        String[] emailStudent = new String[numStudents];
        int i=0;

        for (Student student : students) {
            randomGradeStudent[i] = student.getNoteStudent();
            emailStudent[i] = student.getEmailStudent();
            i++;
        }

        for (int j = 0; j < randomGradeStudent.length; j++) {
            System.out.println(students[j].getName() + " has the grade " + randomGradeStudent[j]);
        }


        insertionSort(randomGradeStudent);


        System.out.println();
        System.out.println("/// After insertion Sort ///");

        for (int grade : randomGradeStudent) {
            for (Student student : students) {
                if (student.getNoteStudent() == grade && !student.getStatus()) {
                    System.out.println(" Student " + student.getName() + " hat die Note "+ grade + " und die Mail "+ student.getEmailStudent());
                    student.setStatus(true);
                }
            }
        }

        System.out.println();
        System.out.println("/// SelectionSortAlphabeticalOrder ///");

        sort(emailStudent);

        for (String f: emailStudent) {
            System.out.println(f);
        }
    }

}
