/*
Создайте массив из 20 случайных четных целых чисел. 
Вычислите среднее арифметическое элементов массива без учета минимального и максимального элементов массива.
*/
package jptv20arrayshomework;

import java.util.Arrays;
import java.util.Random;

public class JPTV20ArraysHomeWork {

    public static void main(String[] args) {
        Random random = new Random();
        int count = 0; // Переменная для цикла
        int[] nums = new int[20]; //Массив
        
//      Цикл для заполнения массива (переменная а заполняет массив) 20 только чётными числами с случайным значением.
        while(count < 20){
            int a = random.nextInt(100)+1;
            //если по условию только чётные, то число добавляется в ячейку массива
            if(a%2 == 0){
               nums[count] = a;
               count++;
            }
        }
        System.out.println("Массив:  " + Arrays.toString(nums));  //Вывод заполненого массива
        
//      Цикл для поиска максимального значения
        int max = 0; //Переменная для максимального значение
        for (int i = 0; i < nums.length; i++) { //Ищет переменную (Цикл работает до того как i получит значение последней ячейки массива) с самым большим значением в массиве и придаёт значение переменной
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println("Максимальное значение: " + max);

//      Минимальное значение
        int min = max;
        for (int i = 0; i < nums.length; i++) { //Ищет переменную по индексу с самым маленьким значением в массиве и придаёт новое значение переменной
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println("Минимальное значение: " + min);

// Среднее минимальное значение
        int countmin = 0;
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] == min) {
                countmin++;
            }
        }
        
// Среднее максимальное значение
        int countmax = 0; //Переменная количества максимального значения
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                countmax++;
            }
        }
       
        int[] newnums = new int[nums.length-(countmin+countmax)]; //Cоздали массив такой же как и nums(0-19). Прибавили Среднее и максимальное, и вычли (Убрали ячейки в массиве)
        Arrays.sort(nums); //Отсортировали
        System.arraycopy(nums, countmin, newnums, 0, newnums.length); //Взяли из массива nums значения и придали их новому массиву newnums. Копирование.
        float medium = 0;
        for (int i = 0; i < newnums.length; i++) { //Идёт по индексу массива и прибавляет значения массива, сохраняя их в переменной medium.
            medium += newnums[i];
        }
        System.out.println("Среднее значение: " + medium / newnums.length); //делим среднее значение на длину массива
    }
}