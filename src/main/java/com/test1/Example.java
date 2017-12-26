package com.test1;

/**
 * Created by nec on 26.12.17.
 */
public class Example {
    public static void sortViborkoy(Comparable[] mas){
//        sort viborom
       for(int i = 0; i < mas.length; i++){
           int min = i;
           for(int j = i+1; j < mas.length; j++){
               if(less(mas[j], mas[min])){
                   min = j;
               }
           }
           exch(mas, i ,min);
       }
    }

    public static void sortVstavkoy(Comparable[] mas){
        for(int i = 1; i < mas.length; i++){
            for(int j = i; j > 0 && less(mas[j], mas[j-1]); j--){
                exch(mas, j, j-1);
            }
        }
    }

    public static void shell(Comparable[] mas){
        int h = 1;
        int N = mas.length;
        while (h < N/3) h = 3*h+1;

        while(h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(mas[j], mas[j-h]); j -= h){
                    exch(mas, j ,j-h);
                }
                h =h/3;
            }
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] mas, int a, int b){
        Comparable t = mas[a];
        mas[a] = mas[b];
        mas[b] = t;
    }

    public static void show(Comparable[] mas){
        for(int i = 0; i < mas.length; i++){
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] mas){
        for(int i = 1; i < mas.length; i++){
            if(less(mas[i], mas[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] mas = {4,2,3,1,7,5};
//        sortViborkoy(mas);
//        sortVstavkoy(mas);
        shell(mas);
        show(mas);
    }
}
