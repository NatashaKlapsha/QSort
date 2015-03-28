package Qsort;

import java.util.Scanner;

/**
 * Created by Natalia on 28.03.2015.
 */
public class Sort {

    static String[] strArray;
    static int temp ;
    static int array_int;
    static int length;
    static String input;
    static boolean tr ;

    public static void main(String[] args) {

        System.out.println("Please,enter the array, exemple-->>>1,3,4<<<--");

            do {
                Scanner scaner = new Scanner(System.in);
                input = scaner.next();
                length = input.length();
                strArray = input.split(",");
                int[] intArray = new int[strArray.length];
                temp = 0;
                if (!(strArray.equals(","))) {//якщо введено не кому, а інший знак
                    for (int i = 0; i < intArray.length; i++) {
                        try {//перевiрка на тип данних, що введені
                            Integer.parseInt(strArray[i]);
                            array_int = Integer.parseInt(strArray[i]);
                            intArray[temp] = array_int;
                            temp++;//розмір нового масиву
                        } catch (Exception e) {
                            System.err.println("Error in " + (i + 1) + "elements");

                        }
                    }
                    int[] intArrayMain = new int[temp];//результуючий масив без лишніх даних, лише int
                    for (int i = 0; i < temp; i++) {
                        intArrayMain[i] = intArray[i];
                    try {//перевірка граничних значень чисел
                        if((intArrayMain[i]> Integer.MAX_VALUE )&&(intArrayMain[i]<Integer.MIN_VALUE)){

                        }
                    }catch (Exception e){
                        System.err.println("Error! Enter new value!");
                        continue;
                    }
                    }
                    for (int i = 0; i < temp; i++) {
                        System.out.println("  " + intArrayMain[i]);
                    }
                    //Сортування за допомогою фунції
                    System.out.println("Array is sorting!--->>");
                    myQSort(intArrayMain,0,intArrayMain.length-1 );
                    for (int v : intArray){
                        System.out.print(v + " ");}
                    String sc = new String();

                } else System.err.println("Error,please enter again");//якщо введенно не кому


            }while (true);
}
        //функції сортування масиву
        static void swap(int[] array, int left, int right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }

        static void myQSort(int[] array, int left, int right) {
            if (left >= right)
                return;

            swap(array, left, (left + right) / 2);
            int last = left;
            for (int i = last + 1; i <= right; ++i)
                if (array[i]>=array[left])
                    swap(array, ++last, i);

            swap(array, left, last);
            myQSort(array, left, last - 1);
            myQSort(array, last + 1, right);
        }
    }
