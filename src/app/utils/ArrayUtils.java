package app.utils;

import app.annotations.Author;
import app.annotations.MethodInfo;

public class ArrayUtils {

    @MethodInfo(name = "average", returnType = "double", description = "Calculates the average of elements in an array")
    @Author(firstName = "John", lastName = "Smith")
    public double average(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }

    @MethodInfo(name = "min", returnType = "int", description = "Finds the minimum element in an array")
    @Author(firstName = "Tom", lastName = "Fisher")
    public int min(int[] array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException("Array is empty");
        int min = Integer.MAX_VALUE;
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    @MethodInfo(name = "sum", returnType = "int", description = "Calculates the sum of elements in an array")
    @Author(firstName = "Bill", lastName = "Jones")
    public int sum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    @MethodInfo(name = "max", returnType = "int", description = "Finds the maximun element in an array")
    @Author(firstName = "Andrii", lastName = "Shevchenko")
    public int max(int[] array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException("Array is empty");
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @MethodInfo(name = "reverse", returnType = "int[]", description = "Reverses the elements of an array")
    @Author(firstName = "Serhii", lastName = "Kravchenko")
    public int[] reverse(int[] array) {
        if (array == null) return null;
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    @MethodInfo(name = "contains", returnType = "boolean", description = "Checks if an array contains a specific value")
    @Author(firstName = "Olena", lastName = "Bondarenko")
    public boolean contains(int[] array, int value) {
        if (array == null) return false;
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}

