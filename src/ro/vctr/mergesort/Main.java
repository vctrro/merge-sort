package ro.vctr.mergesort;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer str;

        str = new StringTokenizer(in.readLine());
        final String dataType = str.nextToken(); //data type
        str = new StringTokenizer(in.readLine());
        final int M = Integer.parseInt(str.nextToken()); //count of string

        int[] unsortInt;
        int[] sortInt;
        double[] unsortDouble;
        double[] sortDouble;
        String[] unsortStr;
        String[] sortStr;
        String[] sortStrLength;

        switch (dataType) {
            case ("string") :
                unsortStr = new String[M];
                for (int i = 0; i < M; i++) {
                    str = new StringTokenizer(in.readLine());
                    unsortStr[i] = (str.nextToken());
                }
                sortStr = mergeSort(unsortStr);
                System.out.println(Arrays.toString(sortStr));
                sortStrLength = mergeSortStringLength(unsortStr);
                System.out.println(Arrays.toString(sortStrLength));
                break;
            case ("int") :
                unsortInt = new int[M];
                for (int i = 0; i < M; i++) {
                    str = new StringTokenizer(in.readLine());
                    unsortInt[i] = Integer.parseInt(str.nextToken());
                }
                sortInt = mergeSort(unsortInt);
                System.out.println(Arrays.toString(sortInt));
                break;
            case ("double") :
                unsortDouble = new double[M];
                for (int i = 0; i < M; i++) {
                    str = new StringTokenizer(in.readLine());
                    unsortDouble[i] = Double.parseDouble(str.nextToken());
                }
                sortDouble = mergeSort(unsortDouble);
                System.out.println(Arrays.toString(sortDouble));

                break;
            default :
                System.out.println("Wrong data");
        }
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
