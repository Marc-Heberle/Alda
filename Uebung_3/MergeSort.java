import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {










    }

    public static void merge(int[] a, int[] hilfe, int vorne, int mitte, int hinten){//vereinigt

        for (int k= vorne; k <= hinten; k++){
            hilfe[k] = a[k];
        }
        int i= vorne;
        int j= mitte +1;
        for (int k = vorne; k <= hinten; k++){
            if (i > mitte){
                a[k] = hilfe[j++]; //schaut ob Zeiger i die Mitte überschritten hat, in dem Fall werden die restlichen Werte von rechts ins array a gepflanzt
            }

            else if (j > hinten) { //schaut ob Zeiger j das Ende des Hilfsarrays überschritten hat, in dem Fall werden die restlichen Werte von links angefügt
                a[k] = hilfe[i++];
            }

            else if (hilfe[j]>(hilfe[i])){
                a[k]=hilfe[j++];
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
        if (mitte < hinten && a[mitte].compareTo(a[mitte + 1]) >= 0) return; // Ändere die Bedingung für absteigende Sortierung
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

            // Ändere die Bedingung auf array[j].compareTo(temp) < 0 für absteigende Sortierung
            while (j >= vorne && array[j].compareTo(temp) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }






    }

