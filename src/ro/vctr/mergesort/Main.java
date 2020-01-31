package ro.vctr.mergesort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] unsortInt = {1,3,5,9,1,4,3,0,2,5,64,56,34,3,7,56,87,3,25,6,7,45,867,678,7,8,658,6578,35,25,2,3,3,4,1324,25,434,43,};
        int[] sortInt = mergeSort(unsortInt);
        double[] unsortDouble = {1.1,1.4,0.1234,0,123,0.12349,0.7671236,0.3452727,0.34527211,123.23,1.123,2.22,0.1752,0,0.1212,5.432,0.11111111111,0.1111111111111};
        double[] sortDouble = mergeSort(unsortDouble);
        String[] unsortStr = {"aabbcc","велосипед","барбекю","Корова","мама","Мама","Sport","spot","гусь","Чайка","купэ","Мама мыла раму","_34","чайник","Error","3 поросёнка","red","DNS","Build completed","2312","23 12"};
        String[] sortStr = mergeSort(unsortStr);
        String[] sortStrLength = mergeSortStringLength(unsortStr);

        System.out.println(Arrays.toString(sortInt));
        System.out.println(Arrays.toString(sortDouble));
        System.out.println(Arrays.toString(sortStr));
        System.out.println(Arrays.toString(sortStrLength));
    }

    private static int[] mergeSort(int[] unsortData) {

        if (unsortData.length <= 1) return unsortData;

        int leftSize = unsortData.length/2;
        int rightSize = unsortData.length-leftSize;
        int[] left, right, result;

        left = new int[leftSize];
        right = new int[rightSize];

        for (int i=0; i<leftSize; i++)
            left[i] = unsortData[i];
        for (int i=0; i<rightSize; i++)
            right[i] = unsortData[i+leftSize];

        left = mergeSort(left);
        right = mergeSort(right);

        //Контроль выполнения
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        result = new int[unsortData.length];

        int lIndex = 0, rIndex = 0;
        for (int i=0; i < result.length; i++)
            if (lIndex >= leftSize) {
                result[i] = right[rIndex];
                rIndex++;
            } else if (rIndex >= rightSize) {
                result[i] = left[lIndex];
                lIndex++;
            } else if (left[lIndex] < right[rIndex]) {
                result[i] = left[lIndex];
                lIndex++;
            } else {
                result[i] = right[rIndex];
                rIndex++;
            }

        return result;
    }

    private static double[] mergeSort(double[] unsortData) {

        if (unsortData.length <= 1) return unsortData;

        int leftSize = unsortData.length/2;
        int rightSize = unsortData.length-leftSize;
        double[] left, right, result;

        left = new double[leftSize];
        right = new double[rightSize];

        for (int i=0; i<leftSize; i++)
            left[i] = unsortData[i];
        for (int i=0; i<rightSize; i++)
            right[i] = unsortData[i+leftSize];

        left = mergeSort(left);
        right = mergeSort(right);

        //Контроль выполнения
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        result = new double[unsortData.length];

        int lIndex = 0, rIndex = 0;
        for (int i=0; i < result.length; i++)
            if (lIndex >= leftSize) {
                result[i] = right[rIndex];
                rIndex++;
            } else if (rIndex >= rightSize) {
                result[i] = left[lIndex];
                lIndex++;
            } else if (left[lIndex] < right[rIndex]) {
                result[i] = left[lIndex];
                lIndex++;
            } else {
                result[i] = right[rIndex];
                rIndex++;
            }

        return result;
    }

    private static String[] mergeSort(String[] unsortData) {

        if (unsortData.length <= 1) return unsortData;

        int leftSize = unsortData.length/2;
        int rightSize = unsortData.length-leftSize;
        String[] left, right, result;

        left = new String[leftSize];
        right = new String[rightSize];

        for (int i=0; i<leftSize; i++)
            left[i] = unsortData[i];
        for (int i=0; i<rightSize; i++)
            right[i] = unsortData[i+leftSize];

        left = mergeSort(left);
        right = mergeSort(right);

        //Контроль выполнения
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        result = new String[unsortData.length];

        int lIndex = 0, rIndex = 0;
        for (int i=0; i < result.length; i++)
            if (lIndex >= leftSize) {
                result[i] = right[rIndex];
                rIndex++;
            } else if (rIndex >= rightSize) {
                result[i] = left[lIndex];
                lIndex++;
            } else {
                int lengthLeft = left[lIndex].length(); //длина цикла равна длине левой строки
                // Сравниваем строки
                for (int s = 0; s<lengthLeft; s++){
                    if (s>=right[lIndex].length()) {
                        result[i] = left[lIndex];
                        lIndex++;
                        s=lengthLeft;
                    }
                    else
                        if (left[lIndex].charAt(s) != right[rIndex].charAt(s)){
                            if (left[lIndex].charAt(s) < right[rIndex].charAt(s)) {
                                result[i] = left[lIndex];
                                lIndex++;
                                s=lengthLeft;
                            } else {
                                result[i] = right[rIndex];
                                rIndex++;
                                s=lengthLeft;

                            }
                        } else if (s==left[lIndex].length()-1) {
                            result[i] = right[rIndex];
                            rIndex++;
                        }
                }
            }

        return result;
    }

    private static String[] mergeSortStringLength(String[] unsortData) {

        if (unsortData.length <= 1) return unsortData;

        int leftSize = unsortData.length/2;
        int rightSize = unsortData.length-leftSize;
        String[] left, right, result;

        left = new String[leftSize];
        right = new String[rightSize];

        for (int i=0; i<leftSize; i++)
            left[i] = unsortData[i];
        for (int i=0; i<rightSize; i++)
            right[i] = unsortData[i+leftSize];

        left = mergeSortStringLength(left);
        right = mergeSortStringLength(right);

        //Контроль выполнения
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        result = new String[unsortData.length];

        int lIndex = 0, rIndex = 0;
        for (int i=0; i < result.length; i++)
            if (lIndex >= leftSize) {
                result[i] = right[rIndex];
                rIndex++;
            } else if (rIndex >= rightSize) {
                result[i] = left[lIndex];
                lIndex++;
            } else if (left[lIndex].length() < right[rIndex].length()) {
                result[i] = left[lIndex];
                lIndex++;
            } else {
                result[i] = right[rIndex];
                rIndex++;
            }

        return result;
    }
}
