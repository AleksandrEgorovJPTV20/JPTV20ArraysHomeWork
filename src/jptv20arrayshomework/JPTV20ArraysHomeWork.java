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
        int count = 0; 
        int[] nums = new int[20]; //создали массив
        
//      Заполняет массив чётными числами
        while(count < 20){
            int a = random.nextInt(100);
            if(a%2 == 0){
               nums[count] = a;
               count++;
            }
        }
        System.out.println("Массив:  " + Arrays.toString(nums));
        
//      Максимальное значения
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println("Максимальное значение: " + max);

//      Минимальное значение
        int min = max;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println("Минимальное значение: " + min);

        int countmin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) {
                countmin++;
            }
        }
        
        int countmax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                countmax++;
            }
        }
       
        int[] newnums = new int[nums.length-(countmin+countmax)];
        Arrays.sort(nums);
        System.arraycopy(nums, countmin, newnums, 0, newnums.length);
        float medium = 0;
        for (int i = 0; i < newnums.length; i++) {
            medium += newnums[i];
        }
        System.out.println("Среднее значение: " + medium / newnums.length);
    }
}